package elements;

import java.awt.Color;

import primitives.Coordinate;
import primitives.Point3D;
import primitives.Vector;

public class AmbientLight extends Light
{
double _ka=0.1;
// ***************** Constructors ********************** //

public AmbientLight(Color color, double _ka)
{
	super(color);
	this._ka = _ka;
}
public AmbientLight()
{
	super(new Color (255,255,255));
	
}
public AmbientLight(AmbientLight a)
{
	super(a.color);
	this._ka = a.get_ka();
}
// ***************** Getters/Setters ********************** // 

public double get_ka() {
	return _ka;
}
public void set_ka(double _ka) {
	this._ka = _ka;
}
// ***************** Administration  ******************** // 
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	long temp;
	temp = Double.doubleToLongBits(_ka);
	result = prime * result + (int) (temp ^ (temp >>> 32));
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
	AmbientLight other = (AmbientLight) obj;
	if (Double.doubleToLongBits(_ka) != Double.doubleToLongBits(other._ka))
		return false;
	return true;
}
@Override
public String toString() {
	return "AmbientLight [_ka=" + _ka + ", color=" + color + "]";
}


@Override
public Color getIntensity(Point3D point) {
	float r=(float) (color.getRed()*_ka);
	if (r>255)
	r=255;
	float g=(float) (color.getGreen()*_ka);
	if (g>255)
	g=255;
	float b=(float) (color.getBlue()*_ka);
	if (b>255)
	b=255;
	return new Color((int)r,(int)g,(int)b );
}


@Override
public Vector getL(Point3D point) {

return new Vector (point);//the defult
}
}
