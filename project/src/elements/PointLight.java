package elements;

import java.awt.Color;

import primitives.*;

public class PointLight extends Light {
	Point3D position;
	double kc;
	double kl;
	double kq;
	
	// ***************** Constructors ********************** //

	public PointLight(Color color, Point3D position, double kc, double kl, double kq) {
		super(color);
		this.position = new Point3D(position);
		this.kc = kc;
		this.kl = kl;
		this.kq = kq;
	}
	public PointLight(PointLight p) {
		super(p.color);
		this.position = new Point3D(p.position);
		this.kc = p.kc;
		this.kl = p.kl;
		this.kq = p.kq;
	}
	public PointLight() {
		super(new Color (255,255,255));
		this.position = new Point3D();
		this.kc = 0;
		this.kl = 0;
		this.kq = 0;
	}
	// ***************** Getters/Setters ********************** // 
	public Point3D getPosition() {
		return new Point3D(position);
	}
	public void setPosition(Point3D position) {
		this.position = new Point3D(position);
	}
	public double getKc() {
		return kc;
	}
	public void setKc(double kc) {
		this.kc = kc;
	}
	public double getKl() {
		return kl;
	}
	public void setKl(double kl) {
		this.kl = kl;
	}
	public double getKq() {
		return kq;
	}
	public void setKq(double kq) {
		this.kq = kq;
	}
	// ***************** Administration  ******************** // 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(kc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(kl);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(kq);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((position == null) ? 0 : position.hashCode());
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
		PointLight other = (PointLight) obj;
		if (Double.doubleToLongBits(kc) != Double.doubleToLongBits(other.kc))
			return false;
		if (Double.doubleToLongBits(kl) != Double.doubleToLongBits(other.kl))
			return false;
		if (Double.doubleToLongBits(kq) != Double.doubleToLongBits(other.kq))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PointLight [position=" + position + ", kc=" + kc + ", kl=" + kl + ", kq=" + kq + ", color=" + color
				+ "]";
	}
	@Override
	public Color getIntensity(Point3D point) {
	double d=position.Distance(point);
	float p=(float)(1/ (kc+kl*d+kq*Math.pow(d, 2)));
	if(p>1)
		p=1;
	float r=(float) (color.getRed()*p);
//	if (r>255)
//	r=255;
	float g=(float) (color.getGreen()*p);
//	if (g>255)
//	g=255;
	float b=(float) (color.getBlue()*p);
//	if (b>255)
//	b=255;
	return new Color((int)r,(int)g,(int)b );	
	}
	
	@Override
	public Vector getL(Point3D point) {
		Vector vec1= new Vector(position,point);
		
//vec1.normalize();
return vec1;
	}


}
