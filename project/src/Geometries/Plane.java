package Geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import primitives.Material;
import primitives.Point2D;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Plane extends Geometry implements FlatGeometry
{
	Point3D _p1;
   Vector plumb;
	
	
	// ***************** Constructors ********************** //
	public Plane() {
		super();
		this._p1 = new Point3D();
		this.plumb=new Vector();
		
	}
	public Plane(Point3D _p1, Vector plumb) {
		super();
		this._p1 = new Point3D(_p1);
		this.plumb = new Vector(plumb);
		
	}
	public Plane(Point3D _p1, Vector plumb,Color emmision) {
		super(emmision);
		this._p1 = new Point3D(_p1);
		this.plumb = new Vector(plumb);
		this.plumb.normalize();
	}
	public Plane(Plane g) 
	{
		super(g.getEmmission(),g.material);
		this._p1 = new Point3D(g._p1);
		this.plumb = g.getNormal(null);
		
	}
	
	// ***************** Getters/Setters ********************** // 
	public Point3D get_p1() {
		return new Point3D(_p1);
	}
	public void set_p1(Point3D _p1) {
		this._p1 = new Point3D(_p1);
	}
	public Vector getPlumb() {
		return new Vector(plumb);
	}
	public void setPlumb(Vector plumb) {
		this.plumb = new Vector(plumb);
	}
	
	// ***************** Administration  ******************** // 
	@Override
	public String toString() {
		return "Plane [_p1=" + _p1 + ", plumb=" + plumb + ", color=" + emmission + ", material=" + material
				+ ", intersections=" + intersections + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_p1 == null) ? 0 : _p1.hashCode());
		result = prime * result + ((plumb == null) ? 0 : plumb.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plane other = (Plane) obj;
		if (_p1 == null) {
			if (other._p1 != null)
				return false;
		} else if (!_p1.equals(other._p1))
			return false;
		if (plumb == null) {
			if (other.plumb != null)
				return false;
		} else if (!plumb.equals(other.plumb))
			return false;
		return true;
	}
	
	//***************** Operations ******************** // 
	@Override
	public Vector getNormal(Point3D point) {
		Vector v=this.getPlumb();
		
		return v;
	}
	
	@Override
	public ArrayList<Point3D> findIntersections(Ray ray) {
		
		ArrayList<Point3D> intersectionPoint = new ArrayList<Point3D>(1);
		
		Point3D P0 = ray.getPoint();
		Point3D Q0 = this.get_p1();
		Vector N = this.getNormal(null);
		Vector V = ray.getVector();
		
		Vector v = new Vector (Q0, P0);
		double t = (N.dotProduct(v) * -1) / N.dotProduct(V);

		if (t >= 0){
			V.scale(t);
			P0.add(V.getHead());
			intersectionPoint.add(P0);
		}
		
		return intersectionPoint;
		
	}
	
	
}
