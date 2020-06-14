package primitives;


public class Vector implements Comparable<Vector>
{
	Point3D head;
	
	
	


	// ***************** Constructors ********************** //
	public Vector(Point3D head) {
		super();
		this.head = new Point3D(head);
		
	}
	public Vector() {
		super();
		this.head = new Point3D();
		
	}
	public Vector(Point3D _head,Point3D tail) //מחשב וקטור חדש משתי נקודות
	{
		///check it
		super();
		Point3D t= new Point3D(tail);
		t.subtract(_head);
		
		this.head = t;
		//tail.substrct(new Vector(_head));
		//this._head = tail;
	}
	public Vector(Vector vec) {
		super();
		this.head = new Point3D(vec.getHead());
		
	}
	public Vector(int i, int j, int k) {
		this.head=new Point3D(i,j,k);
	}
	// ***************** Getters/Setters ********************** // 
	
	
	public Point3D getHead() {
		return new Point3D(head);
	}
	public void setHead(Point3D head) {
		this.head =new Point3D( head);
	}
	
	// ***************** Administration  ******************** // 
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((head == null) ? 0 : head.hashCode());
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
		Vector other = (Vector) obj;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vector [head=" + head + "]";
	}
	// ***************** Operations ******************** // 
	
public void add(Vector vector) {
		
		this.head.x.add(vector.getHead().getX());
		this.head.y.add(vector.getHead().getY());
		this.head.z.add(vector.getHead().getZ());

	}
	public void subtract (Vector vector )
	{
		this.head.subtract(vector.getHead());
	}
	 public Vector substructVector(Vector v1) {
	        Vector v3 = new Vector();
	        v3.head = head.substructPoint(v1.head);
	        return v3;
	    }
	
	public void scale(double scalingFacor)
	{
		
			
			this.head.setX(new Coordinate(
					scalingFacor * head.getX().getCoordinate()));
			
			this.head.setY(new Coordinate(
					scalingFacor * head.getY().getCoordinate()));
			
			this.head.setZ(new Coordinate(
					scalingFacor * head.getZ().getCoordinate()));
		
	}
	public Vector ScaledVector(double scalingFacor) {
		Vector v = new Vector(this);
		v.head.x.coordinate = v.head.x.coordinate * scalingFacor;
		v.head.y.coordinate = v.head.y.coordinate * scalingFacor;
		v.head.z.coordinate = v.head.z.coordinate * scalingFacor;
		return v;
	}
	
	public double length()
	{
		Coordinate c1=new Coordinate(this.getHead().getX());
		Coordinate c2=new Coordinate(this.getHead().getY());
		Coordinate c3=new Coordinate(this.getHead().getZ());
		c1.pow();
		c2.pow();
		c3.pow();
		return Math.sqrt(c1.getCoordinate()+c2.getCoordinate()+c3.getCoordinate());
	}
	public void normalize()
	{
		if(this.length()!=0)
		this.scale((double)(1/this.length()));
	}
	public Vector crossProduct (Vector vector)
	{
		 double u1=this.getHead().getX().getCoordinate();
		 double u2=this.getHead().getY().getCoordinate();
		 double u3=this.getHead().getZ().getCoordinate();
		 double v1=vector.getHead().getX().getCoordinate();
		 double v2=vector.getHead().getY().getCoordinate();
		 double v3=vector.getHead().getZ().getCoordinate();
		 Coordinate x=new Coordinate(u2*v3 - u3*v2);
		 Coordinate y=new Coordinate(u3*v1 - u1*v3);
		 Coordinate z=new Coordinate(u1*v2 - u2*v1);
		 return new Vector(new Point3D(x,y,z));
		 
		
	
	}
	public double dotProduct(Vector vector)
	{
		return(this.getHead().getX().remult(vector.getHead().getX())+this.getHead().getY().remult(vector.getHead().getY())+this.getHead().getZ().remult(vector.getHead().getZ()));
	}
	
	
	  public double magnitude() //the distance from the reshit(0,0,0)
	  {
	        Point3D p0 = new Point3D(0, 0, 0);
	        double x = head.Distance(p0);
	        return x;
	    }
	public int compareTo(Vector arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

