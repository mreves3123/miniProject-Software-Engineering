package primitives;

public class myMain {

	public static void main(String[] args) {
Coordinate coor=new Coordinate(5);
coor.add(new Coordinate(5));
System.out.print(coor);
System.out.print("   ");

coor.substrct(new Coordinate(3));
System.out.print(coor);

Point2D p2=new Point2D();
double d=p2.Distance(new Point2D(new Coordinate(2),new Coordinate(4)));
System.out.print("   "+d);

Point3D p3=new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3));
p3.subtract(new Point3D(new Coordinate(2),new Coordinate(5),new Coordinate(1)));
System.out.print("   "+p3);

Vector v=new Vector(new Point3D(new Coordinate(2),new Coordinate(5),new Coordinate(1)));
	Vector v2=v.crossProduct(new Vector (p3));
	System.out.print("   "+v2);

	}

}
