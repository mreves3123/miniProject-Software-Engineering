package test;


import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Geometries.*;

import Scene.Scene;

import primitives.*;
import renderer.ImageWriter;
import renderer.Render;

public class RenderTest {

	@Test
	public void basicRendering(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(145);
		scene.addGeometry(new Sphere(50., new Point3D(0.0, 0.0, -150), Color.GRAY, new Material(3 ,5,6)));
		
	Triangle triangle = new Triangle(new Point3D( 103, 0, -150),
		 						 new Point3D(  0, 103, -150),
									 new Point3D( 103, 103, -150), Color.GRAY,  new Material(3 ,1,2));
		
	Triangle triangle2 = new Triangle(new Point3D(103, 0, -150), new Point3D(0, -103, -150), new Point3D(103, -103, -150), Color.blue,  new Material(1 ,2,5));
	
		Triangle triangle3 = new Triangle(new Point3D(-103, 0, -150),
			 						  new Point3D(  0, 103, -150),
		 						  new Point3D(-103, 103, -150), Color.green,  new Material(4 ,3,9));
		
		Triangle triangle4 = new Triangle(new Point3D(-103, 0, -150),
		 			 			  new Point3D(  0,  -103, -150),
			 			  new Point3D(-103, -103, -150), Color.red,  new Material(2 ,4,2));
		

		
		scene.addGeometry(triangle);
scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
	scene.addGeometry(triangle4);
	
	
		ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);
		
		Render render = new Render( imageWriter,new Scene(scene));
		
		render.renderImage();
		render.printGrid(50);
		imageWriter.writeToimage();
		/////////////////////////////////////////////////////////////////////
	}
	

}
