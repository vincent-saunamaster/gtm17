package presentation;

import metier.Paire;
import metier.PaireGenerique;

public class Lanceur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Exemple sans généricité
		Paire p = new Paire("abc", "xyz");
		String x = (String) p.getPremier();
		// Double y = (Double) p.getSecond();

		System.out.println("x = " + x);
		// System.out.println("y = " + y);

		/*
		 * Eclipse ne reconnait pas l'erreur "ClassCastException" lors de la
		 * compilation, l'erreur s'affiche lors de l'exécution
		 */

		// Exemple avec généricité
		PaireGenerique<String> p2 = new PaireGenerique<String>("xyz", "abc");
		String a = p2.getPremier();
		// Double b = p2.getSecond();
		String b = p2.getSecond();
		System.out.println(p2);

		PaireGenerique<Integer> p3 = new PaireGenerique<Integer>(12, 30);
		System.out.println(p3);
	}

}
