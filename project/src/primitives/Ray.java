package primitives;

public class Ray {
Point3D point;
Vector vector;



	// ***************** Constructors ********************** // 


	public Ray(Point3D point, Vector vector) {
		super();
		this.point = new Point3D(point);
		this.vector = new Vector(vector);
		this.vector.normalize();
	}
	public Ray(Ray myRay) {
		super();
		this.point = new Point3D(myRay.point);
		this.vector = new Vector (myRay.vector);
		this.vector.normalize();

	}
	public Ray() {
		super();
		this.point = new Point3D();
		this.vector = new Vector();
		this.vector.normalize();

	}
	// ***************** Getters/Setters ********************** // 
	public Point3D getPoint() {
		return new Point3D(point);
	}
	public void setPoint(Point3D point) {
		this.point = new Point3D(point);
	}
	public Vector getVector() {
		return new Vector(vector);
	}
	public void setVector(Vector vector) {
		this.vector = new Vector(vector);
		this.vector.normalize();

	}
		// ***************** Administration  ******************** // 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((point == null) ? 0 : point.hashCode());
		result = prime * result + ((vector == null) ? 0 : vector.hashCode());
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
		Ray other = (Ray) obj;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		if (vector == null) {
			if (other.vector != null)
				return false;
		} else if (!vector.equals(other.vector))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Ray [point=" + point + ", vector=" + vector + "]";
	}
	
}


