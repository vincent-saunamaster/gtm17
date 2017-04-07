package presentation;

import metier.Carre;
import metier.Ellipse;
import metier.Rectangle;

public class RocketLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Carre c = new Carre(10f);
		Ellipse e = new Ellipse(10, 5);
		Rectangle r = new Rectangle(10, 5);
		System.out.println(c);
		System.out.println(e);
		System.out.println(r);

	}

}
