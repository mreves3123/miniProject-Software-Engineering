package test;

import java.awt.Color;

import org.junit.Test;

import Geometries.Sphere;
import Scene.Scene;
import elements.SpotLight;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;

public class Improve {
	@Test
	public void ImprovespotLightTest(){
		
		Scene scene = new Scene();
		
		Sphere sphere = new Sphere(250., new Point3D(0.0, 0.0, -200),new Color(255, 255, 255));
		Material m=new Material();
//		m.setN(20);
//		sphere.setMaterial(m);
		scene.addGeometry(sphere);
		//scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100), 
			//	new Vector(new Point3D(2, 2, -3)),	    0, 0.00001 ,0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Improve Spot test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		imageWriter.writeToimage();
	}

}
