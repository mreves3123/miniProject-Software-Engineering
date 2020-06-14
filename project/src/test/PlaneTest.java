package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import Geometries.Plane;
import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class PlaneTest {

	@Test
	public void testGetNormal() {
		 
	        
		Plane p=new Plane(new Point3D(new Coordinate(2),new Coordinate(3),new Coordinate(1)),new Vector(new Point3D(new Coordinate(3),new Coordinate(0),new Coordinate(2))));
	Vector vec=new Vector(new Point3D(new Coordinate(3),new Coordinate(0),new Coordinate(2)));
	vec.normalize();
	assertEquals(p.getNormal(null),vec);
}
	
	public void testFindIntersections() {
		
		
		try {  Plane p=new Plane(new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3)),new Vector(new Point3D(new Coordinate(2),new Coordinate(4),new Coordinate(6))));
	        ArrayList<Point3D> list_ans = new ArrayList<Point3D>();
	        list_ans.add(new Point3D(2, 3, 2));
	        ArrayList<Point3D> list_point = p.findIntersections(new Ray(new Point3D(1, 1, 1), new Vector(new Point3D(new Coordinate(1.5),new Coordinate(3),new Coordinate(1.5)))));
	        System.out.print(list_point.get(0).toString());
	        assertEquals(list_ans.get(0),list_point.get(0));
		
			   Plane p1=new Plane(new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3)),new Vector(new Point3D(new Coordinate(0),new Coordinate(1),new Coordinate(0))));
	        list_ans = new ArrayList<Point3D>();
	        list_ans.add(new Point3D(1.5, 2, 1.5));
	        list_point = p1.findIntersections(new Ray(new Point3D(1, 1, 1), new Vector(new Point3D(new Coordinate(1.5),new Coordinate(3),new Coordinate(1.5)))));
	        assertEquals(list_ans.get(0),list_point.get(0));

	        Plane P2 = new Plane(new Point3D(4, -3, 5), new Vector(new Point3D(new Coordinate(1),new Coordinate(1),new Coordinate(1))));
	        ArrayList<Point3D> result = P2.findIntersections(new Ray(new Point3D(1, 0, 1), new Vector(new Point3D(new Coordinate(4),new Coordinate(-2),new Coordinate(-2)))));
	        ArrayList<Point3D> list_point_ans1 = new ArrayList<Point3D>();
	        list_point_ans1.add(new Point3D(5, -2, 3));
	        System.out.print(result.get(0).toString());
	        assertEquals(list_point_ans1.get(0),result.get(0));
		}
		catch(Exception e)
		{System.out.println(e.getMessage());}
	}
}

