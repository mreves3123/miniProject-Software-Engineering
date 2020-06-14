package Geometries;

import java.awt.Color;
import java.util.ArrayList;

import primitives.Material;
//import primitives.Point2D;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Sphere extends Geometry
{
double radiuos;
Point3D _p;
//Vector direction;

// ***************** Constructors ********************** //
public Sphere() {
	super();
radiuos=0;
_p= new Point3D();


//direction=new Vector();
}
public Sphere(Double radiuos, Point3D _p,Color c,Material m) {
	super(c,m);
	this.radiuos = radiuos;
	this._p = new Point3D(_p);
	//this.direction = new Vector(direction);
}
public Sphere(Double radiuos, Point3D _p,Color c) 
{
	super(c);
	this.radiuos = radiuos;
	this._p = new Point3D(_p);
	//this.direction = new Vector(direction);
}
public Sphere(Sphere g) 
{
	super(g.getEmmission());
	this.radiuos = g.getRadiuos();
	this._p = new Point3D(g._p);
	//this.direction = new Vector(g.direction);

	
}
// ***************** Getters/Setters ********************** // 

public double getRadiuos() {
	return radiuos;
}
public void setRadiuos(double radiuos) {
	this.radiuos = radiuos;
}
public Point3D get_p() {
	return new Point3D(_p);
}
public void set_p(Point3D _p) {
	this._p = new Point3D(_p);
}
//***************** Administration  ******************** // 
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((_p == null) ? 0 : _p.hashCode());
	long temp;
	temp = Double.doubleToLongBits(radiuos);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
}
@Override
public String toString() {
	return "Sphere [radiuos=" + radiuos + ", _p=" + _p + ", color=" + emmission + ", material=" + material
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
	Sphere other = (Sphere) obj;
	if (_p == null) {
		if (other._p != null)
			return false;
	} else if (!_p.equals(other._p))
		return false;
	if (Double.doubleToLongBits(radiuos) != Double.doubleToLongBits(other.radiuos))
		return false;
	return true;
}

@Override
public Vector getNormal(Point3D point) {
	
	Vector v1= new Vector(_p,point);
	v1.normalize();
	//v1.scale(-1.0);
	return v1;
}
@Override
public ArrayList<Point3D> findIntersections(Ray ray) {

	ArrayList<Point3D> intersectionPoints= new ArrayList<Point3D>(2);
	
	Vector L = new Vector(ray.getPoint(), this.get_p());
	double tm = L.dotProduct(ray.getVector());
	double d = Math.sqrt(Math.pow(L.length(), 2) - Math.pow(tm, 2));
	
	if (d > this.getRadiuos())
		return intersectionPoints;
	
	double th = Math.sqrt(Math.pow(this.getRadiuos(), 2) - Math.pow(d, 2));
	
	double t1 = tm - th;
	double t2 = tm + th;
	
	if (t1 >= 0){
		Vector V = ray.getVector();
		V.scale(t1);
		Point3D P1 = ray.getPoint();
		P1.add(V.getHead());
		intersectionPoints.add(P1);
	}
	
	if (t2 >= 0){
		Vector V = ray.getVector();
		V.scale(t2);
		Point3D P2 = ray.getPoint();
		P2.add(V.getHead());
		intersectionPoints.add(P2);
	}
	
	return intersectionPoints;
}







}
