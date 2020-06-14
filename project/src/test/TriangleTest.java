package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Geometries.Triangle;
import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class TriangleTest {

	@Test
	public void testGetNormal() {
		Triangle t=new Triangle(new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(1)),new Point3D(new Coordinate(2),new Coordinate(0),new Coordinate(3)),new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3)),null, null); 
	
		Vector vec=t.getNormal(null);
		//assertEquals("(0.0,0.0,1.0)",vec.toString());	
		Vector vec2=new Vector(new Point3D(new Coordinate(-4),new Coordinate(2),new Coordinate(0)));
		vec2.normalize();
	assertEquals(vec,vec2);
	}
	@Test
	public void testFindIntersections()
	{
	//no intesection	
		Triangle t1=new Triangle(new Point3D(-100, 0, -150), new Point3D(0, 100, -150), new Point3D(-100,100, -150), null, null);
		ArrayList<Point3D> intersection1=t1.findIntersections(new Ray(new Point3D(0, 0, 0), new Vector(new Point3D(-80,80,-150))));
	
		assertEquals(intersection1,null);
	//intersection
	Triangle t=new Triangle(new Point3D(new Coordinate(-2),new Coordinate(1),new Coordinate(0)),new Point3D(new Coordinate(-4),new Coordinate(0),new Coordinate(0)),new Point3D(new Coordinate(-1),new Coordinate(-2),new Coordinate(0)), null, null);
		ArrayList<Point3D> intersection=new ArrayList<Point3D>();
		intersection.add(new Point3D());
		assertEquals(intersection,t.findIntersections(new Ray(new Point3D(),new Vector())));

		
		Triangle triangle2 = new Triangle(new Point3D(100, 0, -149), new Point3D(0, 100, 149), new Point3D(100, 100, 149), null, null);
		ArrayList<Point3D> intersection2=new ArrayList<Point3D>();
		intersection2.add(new Point3D(75.25252525252525, 75.25252525252525, 75.25252525252525));
		ArrayList<Point3D> intersection3 = triangle2.findIntersections(new Ray(new Point3D(0, 0, 0), new Vector(new Point3D(0.5, 0.5, 0.5))));
	//	assertEquals(intersection2.get(0),intersection3.get(0));
		/* list_point_ans.clear();
        list_point_ans.add(new Point3D(75.25252525252525, 75.25252525252525, 75.25252525252525));
        List<Point3D> list_point = triangle2.findIntersectionPoints(new Ray(new Point3D(0, 0, 0), new Vector(0.5, 0.5, 0.5)));
        System.out.println(list_point_ans.get(0));
        System.out.println(list_point.get(0));
        assertTrue(list_point_ans.get(0).compareTo(list_point.get(0)) == 0);
*/
	}
}
