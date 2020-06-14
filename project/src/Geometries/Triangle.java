package Geometries;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Geometries.FlatGeometry;
//import geometries.*;
import primitives.*;

public class Triangle extends Geometry implements FlatGeometry
{
	Point3D _p1;
    Point3D _p2;
	Point3D _p3;
	
	
	// ***************** Constructors ********************** //
	public Triangle() {
		super();
		this._p1 = new Point3D();
		this._p2 = new Point3D();
		this._p3 = new Point3D();
	}
	public Triangle(Point3D _p1, Point3D _p2, Point3D _p3,Color c,Material m) {
		super(c,m);
		this._p1 = new Point3D(_p1);
		this._p2 = new Point3D(_p2);
		this._p3 = new Point3D(_p3);
	}
	public Triangle(Point3D _p1, Point3D _p2, Point3D _p3,Color c) {
		super(c);
		this._p1 = new Point3D(_p1);
		this._p2 = new Point3D(_p2);
		this._p3 = new Point3D(_p3);
	}
	public Triangle(Triangle g) 
	{
		super(g.getEmmission(),g.getMaterial());
		this._p1 = new Point3D(g.get_p1());
		this._p2 = new Point3D(g.get_p2());
		this._p3 = new Point3D(g.get_p3());
		
	}
	// ***************** Getters/Setters ********************** // 
	public Point3D get_p1() {
		return new Point3D(_p1);
	}
	public void set_p1(Point3D _p1) {
		this._p1 = new Point3D(_p1);
	}
	public Point3D get_p2() {
		return new Point3D(_p2);
	}
	public void set_p2(Point3D _p2) {
		this._p2 = new Point3D(_p2);
	}
	public Point3D get_p3() {
		return new Point3D(_p3);
	}
	public void set_p3(Point3D _p3) {
		this._p3 = new Point3D(_p3);
	}
	// ***************** Administration  ******************** // 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_p1 == null) ? 0 : _p1.hashCode());
		result = prime * result + ((_p2 == null) ? 0 : _p2.hashCode());
		result = prime * result + ((_p3 == null) ? 0 : _p3.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "Triangle [_p1=" + _p1 + ", _p2=" + _p2 + ", _p3=" + _p3 + ", color=" + emmission + ", material=" + material
				+ ", intersections=" + intersections + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		if (_p1 == null) {
			if (other._p1 != null)
				return false;
		} else if (!_p1.equals(other._p1))
			return false;
		if (_p2 == null) {
			if (other._p2 != null)
				return false;
		} else if (!_p2.equals(other._p2))
			return false;
		if (_p3 == null) {
			if (other._p3 != null)
				return false;
		} else if (!_p3.equals(other._p3))
			return false;
		return true;
	}
	
	//***************** Operations ******************** // 
	
	
	
	@Override
	public Vector getNormal(Point3D point) {
								
		
		Vector v1= new Vector(_p1,_p2);
		
		Vector v2= new Vector(_p1,_p3);
		
		Vector vec=new Vector (v1.crossProduct(v2));
		vec.normalize();
		vec.scale(-1);
		return vec;
	}
	
	@Override
	public ArrayList<Point3D> findIntersections(Ray ray) 
	{
		
	
ArrayList<Point3D> intersectionPoints = new ArrayList<Point3D>(1);
		
		// Intersecting the triangular plane
		
		Point3D P0 = ray.getPoint();
		
		Vector N = getNormal(null);
		Plane plane = new Plane(_p3, N,new Color(0,0,0));
		
		if (plane.findIntersections(ray).isEmpty())
			return intersectionPoints;
		
		Point3D intersectionPlane = plane.findIntersections(ray).get(0);
		
		// Checking if the interseculating point is bounded by the triangle
		Vector P_P0 = new Vector(P0, intersectionPlane);
		
		// Checking 1/3 triangular side
		Vector V1_1 = new Vector(P0, this._p1);
		Vector V2_1 = new Vector(P0, this._p2);
		Vector N1 = V1_1.crossProduct(V2_1);
		N1.normalize();
		double S1 = -P_P0.dotProduct(N1);
		
		// Checking 2/3 triangular side
		Vector V1_2 = new Vector(P0, this._p2);
		Vector V2_2 = new Vector(P0, this._p3);
		Vector N2 = V1_2.crossProduct(V2_2);
		N2.normalize();
		double S2 = -P_P0.dotProduct(N2);
		
		// Checking 1/3 triangular side
		Vector V1_3 = new Vector(P0, this._p3);
		Vector V2_3 = new Vector(P0, this._p1);
		Vector N3 = V1_3.crossProduct(V2_3);
		N3.normalize();
		double S3 = -P_P0.dotProduct(N3);
				
		if (((S1 > 0) && (S2 > 0) && (S3 > 0)) || 
			((S1 < 0) && (S2 < 0) && (S3 < 0))){
			intersectionPoints.add(intersectionPlane);
		}
		
		return intersectionPoints;

	}
	}
