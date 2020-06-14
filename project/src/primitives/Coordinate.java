package primitives;


public class Coordinate implements Comparable<Coordinate>  
{
double coordinate;
// ***************** Constructors ********************** // 
public Coordinate() {

	this.coordinate = 0.0;
}
public Coordinate(double coordinate) {

	this.coordinate = coordinate;
}
public Coordinate(Coordinate coor) 
{
	this.coordinate=coor.coordinate;
}
// ***************** Getters/Setters ********************** // 
public double getCoordinate() {
	return coordinate;
}
public void setCoordinate(double coordinate) {
	this.coordinate = coordinate;
}
// ***************** Administration  ******************** // 

public int compareTo(Coordinate arg0) 
{
	
	if (this.coordinate==arg0.getCoordinate())
	return 0;
	else
	{
		if(this.coordinate>arg0.getCoordinate())
			return 1;
		else
			return -1;//this.coordinate<arg0.getCoordinate()
	}
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	long temp;
	temp = Double.doubleToLongBits(coordinate);
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
	Coordinate other = (Coordinate) obj;
	if (Double.doubleToLongBits(coordinate) != Double.doubleToLongBits(other.coordinate))
		return false;
	return true;
}
@Override
public String toString() {
	return "[coordinate=" + coordinate + "]";
}
//***************** Operations ******************** // 

public void add (Coordinate arg0) 
{
	this.coordinate+=arg0.getCoordinate();
}
public double addCoordinate(Coordinate _coordinate) {
    double x = coordinate+ _coordinate.coordinate;
    return x;
}
public void substrct  (Coordinate arg0) 
{
	this.coordinate-=arg0.getCoordinate();
}
public double substructCoordinate(Coordinate _coordinate) {
    double x = coordinate - _coordinate.coordinate;
    return x;
}
public void mult(double multi)//change the coordinate
{
	this.coordinate*=multi;
}
public double remult(Coordinate multi)//return the value
{
	return this.coordinate*multi.coordinate;
}
public Coordinate reCoorMult(Coordinate multi)//return the coordinate
{
	return new Coordinate(this.coordinate*multi.coordinate);
}
public void pow()
{
	this.coordinate*=this.coordinate;
}
}
