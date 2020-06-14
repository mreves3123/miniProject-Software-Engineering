package primitives;

public class Point2D  
{
	Coordinate x;
	Coordinate y;
	
	// ***************** Constructors ********************** // 
	public Point2D() {
		this.x = new Coordinate();
		this.y = new Coordinate();
	}
	public Point2D(Coordinate x, Coordinate y) {
		this.x = new Coordinate(x);
		this.y = new Coordinate(y);
	}
	public Point2D(Point2D point) {
		this.x = new Coordinate(point.x);
		this.y = new Coordinate(point.y);
	}
	// ***************** Getters/Setters ********************** // 
	
	public Coordinate getX() {
		return x;
	}
	public void setX(Coordinate x) {
		this.x = x;
	}
	public Coordinate getY() {
		return y;
	}
	public void setY(Coordinate y) {
		this.y = y;
	}
	// ***************** Administration  ******************** // 

	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
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
		Point2D other = (Point2D) obj;
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
		return true;
	}
	@Override
	public String toString() {
		return "Point2D [x=" + x + ", y=" + y + "]";
	}
	//***************** Operations ******************** // 
	public double Distance(Point2D point)
	{
		return Math.sqrt(Math.pow((this.getX().getCoordinate()-point.getX().getCoordinate()),2)+Math.pow((this.getY().getCoordinate()-point.getY().getCoordinate()),2));
			//d2= (x1-x2)2+(y1-y2)2
	}
	public void add(Point2D head) {
		this.x.add(head.x);
		this.y.add(head.y);
		

		// TODO Auto-generated method stub
		
	}

}
