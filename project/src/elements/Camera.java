package elements;

import java.util.ArrayList;
import java.util.List;

import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Camera {
Point3D center;
Vector vup;
Vector vright;
Vector Vtoward;
//***************** Constructors ********************** //
public Camera(Point3D center, Vector vup, Vector vright, Vector vtoward) {
	super();
	this.center = new Point3D(center);
	this.vup = new Vector(vup);
	this.vright = new Vector(vright);
	this.Vtoward = new Vector(vtoward);
}
public Camera() 
{
	super();
	this.center = new Point3D();
	this.vup = new Vector(new Point3D(0,1,0));
	this.Vtoward = new Vector(new Point3D(0, 0, -1));
	this.vright = new Vector(new Point3D(1,0,0));
}
public Camera (Point3D P0, Vector vUp, Vector vTo){
	
	this.center = new Point3D(P0);
	this.vup = new Vector(vUp);
	this.Vtoward = new Vector(vTo);
	
	this.vright = vup.crossProduct(Vtoward);
	this.vup = Vtoward.crossProduct(vright);
	
	this.vup.normalize();
	this.Vtoward.normalize();
	this.vright.normalize();
	
}
public Camera(Camera myCam) {
	super();
	this.center = new Point3D(myCam.center);
	this.vup = new Vector(myCam.vup);
	this.vright =new Vector( myCam.vright);
	Vtoward = new Vector(myCam.Vtoward);
}
//***************** Getters/Setters ********************** //
public Point3D getCenter() {
	return new Point3D(center);
}
public void setCenter(Point3D center) {
	this.center = new Point3D(center);
}
public Vector getVup() {
	return new Vector(vup);
}
public void setVup(Vector vup) {
	this.vup = new Vector(vup);
}
public Vector getVright() {
	return new Vector(vright);
}
public void setVright(Vector vright) {
	this.vright = new Vector(vright);
}
public Vector getVtoward() {
	return new Vector(Vtoward);
}
public void setVtoward(Vector vtoward) {
	Vtoward = new Vector(vtoward);
}
//***************** Administration  ******************** //
@Override
public String toString() {
	return "Camera [center=" + center + ", vup=" + vup + ", vright=" + vright + ", Vtoward=" + Vtoward + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Vtoward == null) ? 0 : Vtoward.hashCode());
	result = prime * result + ((center == null) ? 0 : center.hashCode());
	result = prime * result + ((vright == null) ? 0 : vright.hashCode());
	result = prime * result + ((vup == null) ? 0 : vup.hashCode());
	return result;
}

@Override
public boolean equals(Object obj)
{
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Camera other = (Camera) obj;
	if (Vtoward == null) {
		if (other.Vtoward != null)
			return false;
	} else if (!Vtoward.equals(other.Vtoward))
		return false;
	if (center == null) {
		if (other.center != null)
			return false;
	} else if (!center.equals(other.center))
		return false;
	if (vright == null) {
		if (other.vright != null)
			return false;
	} else if (!vright.equals(other.vright))
		return false;
	if (vup == null) {
		if (other.vup != null)
			return false;
	} else if (!vup.equals(other.vup))
		return false;
	return true;
}


//***************** Operations ******************** // 

public Ray constructRayThroughPixel1 (int Nx, int Ny, double x, double y, double screenDist, double screenWidth,double screenHeight)
{
//	if(x==238&&y==163)
//		System.out.println("here");
	Vector vto = new Vector(this.Vtoward);
	Vector vright = new Vector(this.vright);
	Vector vup = new Vector(this.vup);
	
	vto.scale(screenDist);
	
	Point3D pc = new Point3D(center);
	pc.add(vto.getHead());//pc
	
	double rx=screenWidth/Nx;
	double ry=screenHeight/Ny;
	
	vright.scale((x-Nx/2.0)*rx+rx/2.0);
	vup.scale((y-Ny/2.0)*ry+ry/2.0);
	
	vright.subtract(vup);
	pc.add(vright.getHead());
	
	Point3D p=new Point3D(pc);//p is pc after the changes
	Vector vec=new Vector(getCenter(),p);
	vec.normalize();
	
	return new Ray(new Point3D(p),vec);
	
}
public List<Ray> constructRayThroughPixel (int Nx, int Ny, double x, double y,
		 double screenDist, double screenWidth,
		 double screenHeight){

	List<Ray> rays=new ArrayList<Ray>();
// Calculating the image center
Vector vToward = new Vector(this.Vtoward);
vToward.scale(screenDist);

//Point3D Pc = new Point3D(this.center);
//Pc.add(vToward.getHead());

// Calculating x-y ratios
double Rx = screenWidth  / Nx; 
double Ry = screenHeight / Ny; 

// Calculating P - the intersection point

Point3D Pc = new Point3D(this.center);
Pc.add(vToward.getHead());
Vector vRight = new Vector(this.vright);
Vector vUp = new Vector(this.vup);

vRight.scale(((x - (Nx*0.5)) * Rx + 0.5 * Rx));
vUp.   scale(((y - (Ny*0.5)) * Ry + 0.5 * Ry));

vRight.subtract(vUp);

Pc.add(vRight.getHead());

Point3D P = new Point3D(Pc);


// constructing ray between P0 and the intersection point
Vector ray = new Vector(center, P);
Point3D P2=new Point3D(P.addPoint(new Point3D(0.25*Rx,0.25*Ry,0)));
Vector ray2 = new Vector(center, P2);
Point3D P3=new Point3D(P.addPoint(new Point3D(0.25*Rx,(-0.25)*Ry,0)));
Vector ray3 = new Vector(center,P3 );
Point3D P4=new Point3D(P.addPoint(new Point3D((-0.25)*Rx,0.25*Ry,0)));
Vector ray4 = new Vector(center,P4);
Point3D P5=new Point3D(P.addPoint(new Point3D((-0.25)*Rx,(-0.25)*Ry,0)));
Vector ray5= new Vector(center, P5);
Point3D P6=new Point3D(P.addPoint(new Point3D((0)*Rx,(-0.25)*Ry,0)));
Vector ray6= new Vector(center, P5);
Point3D P7=new Point3D(P.addPoint(new Point3D((0)*Rx,(0.25)*Ry,0)));
Vector ray7= new Vector(center, P5);
Point3D P8=new Point3D(P.addPoint(new Point3D((-0.25)*Rx,(0)*Ry,0)));
Vector ray8= new Vector(center, P5);
Point3D P9=new Point3D(P.addPoint(new Point3D((0.25)*Rx,(0)*Ry,0)));
Vector ray9= new Vector(center, P5);
ray.normalize();
ray2.normalize();
ray3.normalize();
ray4.normalize();
ray5.normalize();
ray6.normalize();
ray7.normalize();
ray8.normalize();
ray9.normalize();
rays.add(new Ray(P, ray));
rays.add(new Ray(P2, ray2));
rays.add(new Ray(P3, ray3));
rays.add(new Ray(P4, ray4));
rays.add(new Ray(P5, ray5));
rays.add(new Ray(P6, ray6));
rays.add(new Ray(P7, ray7));
rays.add(new Ray(P8, ray8));
rays.add(new Ray(P9, ray9));


return rays;

}
}
	


