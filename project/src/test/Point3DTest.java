package test;

import static org.junit.Assert.*;

import org.junit.Test;

import primitives.Coordinate;
import primitives.Point3D;

public class Point3DTest {

	@Test
	public void testAdd() {
		Point3D p1=new Point3D(new Coordinate(2),new Coordinate(4),new Coordinate(1));
	p1.add(new Point3D(new Coordinate(3),new Coordinate(5),new Coordinate(2)));
		Point3D p2=new Point3D(new Coordinate(5),new Coordinate(9),new Coordinate(3));
	//assertNotSame(p1,p2);
	assertEquals(p1,p2);
	}
	@Test
	public void testSubtract() {
		Point3D p3=new Point3D(new Coordinate(5),new Coordinate(1),new Coordinate(2));
	p3.subtract(new Point3D(new Coordinate(2),new Coordinate(4),new Coordinate(2)));

	assertEquals(new Point3D(new Coordinate(3),new Coordinate(-3),new Coordinate(0)),p3);
	}

}
