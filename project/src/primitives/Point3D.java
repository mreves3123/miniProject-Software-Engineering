package primitives;


import primitives.Coordinate;


public class Point3D {
	Coordinate x;
	Coordinate y;
	Coordinate z;
	
	// ***************** Constructors ********************** //
	public Point3D() {
		this.x = new Coordinate();
		this.y = new Coordinate();
		this.z = new Coordinate();
	}
	public Point3D(Coordinate x, Coordinate y,Coordinate z) {
		this.x = new Coordinate(x);
		this.y =new Coordinate( y);
		this.z = new Coordinate(z);
	}
	public Point3D(double x, double y,double z) {
		this.x = new Coordinate(x);
		this.y =new Coordinate( y);
		this.z = new Coordinate(z);
	}
	public Point3D(Point3D point) {
		this.x =new Coordinate( point.x);
		this.y =new Coordinate(point.y);
		this.z =new Coordinate(point.z);
	}
	// ***************** Getters/Setters ********************** //

	public Coordinate getX() {
		return new Coordinate(x);
	}
	public void setX(Coordinate x) {
		this.x = new Coordinate(x);
	}
	public Coordinate getY() {
		return new Coordinate(y);
	}
	public void setY(Coordinate y) {
		this.y = new Coordinate(y);
	}
	public Coordinate getZ() {
		return new Coordinate(z);
	}
	public void setZ(Coordinate z) {
		this.z = new Coordinate(z);
	}
	// ***************** Administration  ******************** // 

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		result = prime * result + ((z == null) ? 0 : z.hashCode());
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
		Point3D other = (Point3D) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		if (z == null) {
			if (other.z != null)
				return false;
		} else if (!z.equals(other.z))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Point3D [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	// ***************** Operations ******************** // 
	public double Distance(Point3D point)
	{
		double dis= Math.sqrt(Math.pow((this.getX().getCoordinate()-point.getX().getCoordinate()),2)+Math.pow((this.getY().getCoordinate()-point.getY().getCoordinate()),2)+Math.pow((this.getZ().getCoordinate()-point.getZ().getCoordinate()),2));
		return dis;
		//d2= (x1-x2)2+(y1-y2)2+(Z1-Z2)^2
	}
	
	public void add(Point3D head) {
		this.x.add(head.x);
		this.y.add(head.y);
		this.z.add(head.z);

		// TODO Auto-generated method stub
		
	}
	public void add(Vector v) {
		this.x.add(v.head.x);
		this.y.add(v.head.y);
		this.z.add(v.head.z);

		
	}
	 public Point3D addPoint(Point3D p1) {
	        double _x = x.addCoordinate(p1.getX());
	        double _y = y.addCoordinate(p1.getY());
	        double _z = z.addCoordinate(p1.getZ());
	        Point3D p = new Point3D(_x, _y, _z);
	        return p;
	    }
	public void subtract (Point3D Point )
	{
		this.x.substrct(Point.getX());
		this.y.substrct(Point.getY());
		this.z.substrct(Point.getZ());
	}
	
	/*
	public void subtract2point (Point3D Point1,Point3D Point2 )
	{
		(Point1.x).substrct(Point2.x);
		(Point1.y).substrct(Point2.y);
		(Point1.z).substrct(Point2.z);
	}*/
	public Point3D substructPoint(Point3D p1) {
		double _x = x.substructCoordinate(p1.getX());
        double _y = y.substructCoordinate(p1.getY());
        double _z = z.substructCoordinate(p1.getZ());
        Point3D p = new Point3D(_x, _y, _z);
        return p;
	}
	public Point3D mult(double num) {
		setX(new Coordinate(getX().coordinate * num));
	    setY(new Coordinate(getY().coordinate * num));
	   setZ(new Coordinate(getZ().coordinate * num));	
	   return new Point3D(this);
	}
	
}
