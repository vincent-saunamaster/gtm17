package org.formation.tpinterface;

import java.io.Serializable;

public class Rectangle implements Surface, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double width;
	private double height;

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Rectangle() {
		super();
	}

	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return this.width * this.height;
	}

}
