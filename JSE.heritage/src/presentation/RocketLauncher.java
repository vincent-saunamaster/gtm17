package presentation;

import metier.Compte;
import metier.CompteEpargne;
import metier.ComptePayant;
import metier.CompteSimple;

/**
 * classe qui lance tout
 * 
 * @author Stagiaire
 *
 */
public class RocketLauncher {
	/**
	 * methode qui lance tout
	 * 
	 * @param args
	 *            arguments du programme
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Compte c = new Compte(1, "testCompte", 10000);
		CompteSimple cs = new CompteSimple(2, "testCompteSimple", 12000f, 1000f);
		CompteEpargne ce = new CompteEpargne(3, "testCompteEpargne", 12000f, 0.01f);
		ComptePayant cp = new ComptePayant(4, "testComptePayant", 12000f, 0.03F);

		System.out.println(c);
		System.out.println(cs);
		System.out.println(ce);
		System.out.println(cp);

		// test méthodes redéfinies
		System.out.println("----------après operations----------");
		c.verser(8000);
		c.retirer(1);
		cs.retirer(1);
		ce.calculInteret();
		cp.verser(8000);
		cp.retirer(1);

		System.out.println(c);
		System.out.println(cs);
		System.out.println(ce);
		System.out.println(cp);

		// test transtypage
		Compte testTranstypage = (Compte) new CompteSimple(2, "testTranstypage", 12000f, 1000f);
		System.out.println("\ntest transtypage\n" + testTranstypage);
		System.out.println("---------nombre de comptes------");
		System.out.println(Compte.getnbComptes());

	}

}
