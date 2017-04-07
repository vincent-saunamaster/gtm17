package org.formation.tpinterface;

public class AreaCalculator {

	public AreaCalculator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double sumArea(Surface[] surfaces) {
		double res = 0;
		for (int j = 0; j < surfaces.length; j++) {
			res += surfaces[j].getArea();
		}
		return res;
	}
}
