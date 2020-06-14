package elements;

import java.awt.Color;

import primitives.*;

public abstract class Light {
	Color color;
	
	
	
	// ***************** Constructors ********************** //

	public Light(Color color) {
		super();
		this.color = color;
	}

	public Light() {
		super();
		this.color = new Color(255,255,255);
		// TODO Auto-generated constructor stub
	}
	public Light(Light l) {
		super();
		this.color = l.color;
	}
	// ***************** Getters/Setters ********************** // 

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	// ***************** Administration  ******************** // 
	public abstract Color getIntensity (Point3D point);
	public abstract Vector getL(Point3D point);
}
