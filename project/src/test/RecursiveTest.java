package test;

import java.awt.Color;

import org.junit.Test;

import elements.SpotLight;
import Geometries.Sphere;
import Geometries.Triangle;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import Scene.Scene;

public class RecursiveTest {

	
	@Test
	public void recursiveTest(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(300);
		
		Sphere sphere = new Sphere(500., new Point3D(0.0, 0.0, -1000),new Color(0, 0, 100));
		Material m=new Material();
		m.setN(20);
		m.setKt(0.5);
		sphere.setMaterial(m);
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(250., new Point3D(0.0, 0.0, -1000),new Color(100, 20, 20));
		Material m2=new Material();
		m2.setN(20);
		m2.setKt(0);
		sphere2.setMaterial(m2);
		scene.addGeometry(sphere2);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
					   new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		
	}
	
	
	@Test
	public void recursiveTest2(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(300);
		
		Sphere sphere = new Sphere(300., new Point3D(-550, -500, -1000),new Color(0, 0, 100));
		Material m=new Material();
		m.setN(20);
		m.setKt(0.5);
		sphere.setMaterial(m);
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(150., new Point3D(-550, -500, -1000),new Color(100, 20, 20));
		Material m2=new Material();
		m2.setN(20);
		m2.setKt(0);
		sphere2.setMaterial(m2);
		scene.addGeometry(sphere2);
		
		Triangle triangle = new Triangle(new Point3D(  1500, -1500, -1500),
				 						 new Point3D( -1500,  1500, -1500),
				 						 new Point3D(  200,  200, -375),
				 						new Color(20, 20, 20));
		
		Triangle triangle2 = new Triangle(new Point3D(  1500, -1500, -1500),
										  new Point3D( -1500,  1500, -1500),
										  new Point3D( -1500, -1500, -1500),
										  new Color(20, 20, 20));
		
		Material m3=new Material();
		Material m4=new Material();
		m3.setKr(1);
		m4.setKr(0.5);
		triangle.setMaterial(m3);
		triangle2.setMaterial(m4);
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150), 
				   new Vector(-2, -2, -3), 0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test 2", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		
	}
	
	@Test
	public void recursiveTest3(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(300);
		
		Sphere sphere = new Sphere(300., new Point3D(0, 0, -1000),new Color(0, 0, 100));
		Material m=new Material();
		m.setN(20);
		m.setKt(0.5);
		sphere.setMaterial(m);
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(150., new Point3D(0, 0, -1000),new Color(100, 20, 20));
		Material m1=new Material();
		m1.setN(20);
		m1.setKt(0);
		sphere2.setMaterial(m1);
		scene.addGeometry(sphere2);
		
		Triangle triangle = new Triangle(new Point3D(  2000, -1000, -1500),
				 						 new Point3D( -1000,  2000, -1500),
				 						 new Point3D(  700,  700, -375),
				 						new Color(20, 20, 20));
		
		Triangle triangle2 = new Triangle(new Point3D(  2000, -1000, -1500),
										  new Point3D( -1000,  2000, -1500),
										  new Point3D( -1000, -1000, -1500),
										  new Color(20, 20, 20));
		
		Material m2=new Material();
		m2.setKr(1);
		triangle.setMaterial(m2);

		Material m3=new Material();
		m3.setKr(0.5);
		triangle2.setMaterial(m3);
		
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150), 
				   new Vector(-2, -2, -3), 0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test 3", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		
	}
	@Test
	public void RecursiveTest4(){
		
		Scene scene = new Scene();
		
//		Sphere sphere = new Sphere(300., new Point3D(200, 0, -500),new Color(0, 0, 100));
//		Material m=new Material();
//		m.setN(20);
//		m.setKt(0.5);
//		sphere.setMaterial(m);
//		scene.addGeometry(sphere);
//		Sphere sphere2 = new Sphere(150., new Point3D(0, 0, -1000),new Color(100, 20, 20));
//		Material m1=new Material();
//		m1.setN(20);
//		m1.setKt(0);
//		m1.setKr(0.5);
//		sphere2.setMaterial(m1);
//		scene.addGeometry(sphere2);
		
		 Sphere sphere = new Sphere(500., new Point3D(500.0, -500.0, -1000), new Color(100, 50, 0), new Material(1, 1, 2,0.8,0));
		  scene.addGeometry(sphere);
		  Sphere sphere2 = new Sphere(500., new Point3D(-1000.0, -2000.0, -1000), new Color(0, 50, 100), new Material(1, 1, 20,0,0));
          scene.addGeometry(sphere2);
          Sphere sphere3 = new Sphere(200., new Point3D(-500.0, 500.0, -1000), new Color(100, 0, 0), new Material(1, 1, 2,0.8,0));
          
              scene.addGeometry(sphere3);
              Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
						 new Point3D( -3500, -3500, -1000),
						 new Point3D(  3500, -3500, -2000),
						 new Color(0,0,0),new Material(1,1,1,0,1));

Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
						  new Point3D( -3500,  3500, -1000),
						  new Point3D( -3500, -3500, -1000),
	 						 new Color(0,0,0),new Material(1,1,1,0,1));

scene.addGeometry(triangle);
scene.addGeometry(triangle2);

scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
	   new Vector(new Point3D(-2, -2, -3)), 0, 0.000001, 0.0000005));


		ImageWriter imageWriter = new ImageWriter("Recursive test 4", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		
	}
	}
