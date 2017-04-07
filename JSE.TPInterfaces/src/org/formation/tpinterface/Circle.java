package org.formation.tpinterface;

public class Circle implements Surface, IFXDrawable, IPrintable {

	private double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Circle() {
		super();
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public void printMe(String text) {
		// TODO Auto-generated method stub
		System.out.println(text);
	}

	@Override
	public String getShape() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.pow(this.radius, 2) * Math.PI;
	}

}
