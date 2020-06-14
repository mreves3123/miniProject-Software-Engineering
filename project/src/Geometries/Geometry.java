package Geometries;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import primitives.Vector;
import primitives.*;
public abstract class Geometry {
	
	Color emmission;
	Material material;
	ArrayList<Point3D> intersections = new ArrayList<Point3D>();


	// ***************** Constructors ********************** //
	
	public Geometry(Color color, Material m) {
		super();
		this.emmission = new Color(color.getRGB());
		this.material=new Material(m);

	}

	public Geometry() {
		super();
		emmission= new Color(0,0,0);
		material=new Material();
	}
	
	public Geometry(Geometry g) 
	{
		this.emmission = new Color(g.emmission.getRGB());
		this.material=new Material(g.material);

	}
public Geometry(Color emmision)
{
	this.emmission=new Color(emmision.getRGB());
	this.material=new Material();
}
	
	// ***************** Getters/Setters ********************** // 
	public Color getEmmission() {
		return new Color(emmission.getRGB());
	}

	public void setEmmission(Color color) {
		this.emmission = new Color(color.getRGB());
	}
	public Material getMaterial() {
		return new Material(this.material);
	}

	public void setMaterial(Material material) {
		this.material = new Material(material);
	}
	
	// ***************** Administration  ******************** // 
	

	public abstract   Vector getNormal (Point3D point);
	public abstract   ArrayList<Point3D> findIntersections (Ray ray) ;

}