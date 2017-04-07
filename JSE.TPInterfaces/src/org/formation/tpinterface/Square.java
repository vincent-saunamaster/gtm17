package org.formation.tpinterface;

public class Square extends Rectangle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double size;

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public Square() {
		super();
	}

	public Square(double size) {
		super();
		this.size = size;
	}

}
