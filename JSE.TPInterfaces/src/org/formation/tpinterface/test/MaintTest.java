package org.formation.tpinterface.test;

import org.formation.tpinterface.AreaCalculator;
import org.formation.tpinterface.Circle;
import org.formation.tpinterface.Rectangle;
import org.formation.tpinterface.Square;
import org.formation.tpinterface.Surface;

public class MaintTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle CircleTest = new Circle(10);
		Square squareTest = new Square(10);
		Rectangle rectangleTest = new Rectangle(10,20);
		Surface[] tableauTest = {CircleTest,squareTest,rectangleTest};
		AreaCalculator AreaCalculatorTest = new AreaCalculator();
		System.out.println("Somme des aires = " + AreaCalculatorTest.sumArea(tableauTest));
		// CircleTest.printMe(CircleTest);
	}

}
