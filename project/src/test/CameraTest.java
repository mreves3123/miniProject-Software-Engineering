package test;

import static org.junit.Assert.*;

import org.junit.Test;

import elements.Camera;
import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class CameraTest {

	@Test
	public void testRaysConstruction() {
		Camera cam=new Camera(new Point3D(),new Vector(new Point3D(new Coordinate(1),new Coordinate(3),new Coordinate(2))),new Vector(new Point3D(new Coordinate(2),new Coordinate(0),new Coordinate(4))),new Vector(new Point3D(new Coordinate(2),new Coordinate(2),new Coordinate(1))));
		Ray r=cam.constructRayThroughPixel(5, 5, 2, 2, 10, 20, 20);
		Vector v=new Vector(new Point3D(new Coordinate(20),new Coordinate(20),new Coordinate(10)));
		v.normalize();
		Ray ray=new Ray(new Point3D(),v);
		assertEquals(r,ray);
	}

}
