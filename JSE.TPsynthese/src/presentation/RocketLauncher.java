package presentation;

import java.util.Scanner;

import metier.Compte;
import service.CompteService;

/**
 * Cette Classe sert � lancer le programme
 * 
 * @author Stagiaire
 * @version 0
 *
 */
public class RocketLauncher {

	protected static Scanner clavier = new Scanner(System.in);
	/**
	 * La classe Main est le point de d�part du programme
	 * 
	 * @param args
	 *            les arguments pass�s en param�tres
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Programme de gestion de compte");

		// iniatialisation objets et variables
		Compte x = new Compte();
		CompteService y = new CompteService();
		long somme;
		boolean reload = true;
		int i;
		//static Scanner clavier = new Scanner(System.in);

		while (reload == true) {
			System.out.println("que souhaitez-vous faire ?");
			System.out.println("1 : ajouter compte");
			System.out.println("2 : ajouter argent");
			System.out.println("3 : retirer argent");
			System.out.println("4 : quitter l'application");
			i = clavier.nextInt();
			clavier.nextLine();
			switch (i) {
			case 1:
				creationCompte(x);

				break;
			case 2:
				if (x.getNomCompte() == null) {
					creationCompte(x);
				} else {
					System.out.println("Combien souhaitez-vous ajouter d'argent au compte " + x.getNomCompte() + " ?");
					somme = clavier.nextLong();
					clavier.nextLine();
					System.out.println("solde du compte " + x.getNomCompte() + " = " + y.ajouter(x, somme));
				}

				break;
			case 3:
				if (x.getNomCompte() == null) {
					creationCompte(x);
				} else {
					System.out.println("Combien souhaitez-vous retirer d'argent au compte " + x.getNomCompte() + " ?");
					somme = clavier.nextLong();
					clavier.nextLine();
					System.out.println("solde du compte " + x.getNomCompte() + " = " + y.retirer(x, somme));
				}

				break;
			case 4:
				reload = false;

				break;

			default:

				break;
			}
		}
		/*
		 * // boucle qui cree les infos du compte while (i.equals("o")) { Compte
		 * x = new Compte(); System.out.println("ID du nouveau compte ?");
		 * x.setIdCompte(clavier.nextInt()); clavier.nextLine();
		 * System.out.println("nom du nouveau compte ?");
		 * x.setNomCompte(clavier.next()); clavier.nextLine();
		 * System.out.println("solde du nouveau compte ?");
		 * x.setSolde(clavier.nextLong()); clavier.nextLine();
		 * System.out.println("---------------------------------");
		 * System.out.println("Nouveau compte ajout�");
		 * System.out.println(x.toString());
		 * System.out.println("---------------------------------");
		 * 
		 * // utilisation de la classe CompteService System.out.
		 * println("Souhaitez-vous effectuer une op�ration sur ce compte ? o/n"
		 * ); i = clavier.next().toLowerCase(); clavier.nextLine(); if
		 * (i.equals("o")) { CompteService y = new CompteService(); long somme;
		 * 
		 * while (i.equals("o")) {
		 * 
		 * System.out.
		 * println("Combien souhaitez-vous ajouter d'argent au compte " +
		 * x.getNomCompte() + " ?"); somme = clavier.nextLong();
		 * clavier.nextLine(); System.out.println("solde du compte " +
		 * x.getNomCompte() + " = " + y.ajouter(x, somme));
		 * 
		 * System.out.
		 * println("Combien souhaitez-vous retirer d'argent au compte " +
		 * x.getNomCompte() + " ?"); somme = clavier.nextLong();
		 * clavier.nextLine(); System.out.println("solde du compte " +
		 * x.getNomCompte() + " = " + y.retirer(x, somme));
		 * 
		 * System.out.println("Souhaitez-vous revoir le solde du compte o/n"); i
		 * = clavier.next().toLowerCase(); clavier.nextLine(); if
		 * (i.equals("o")) { System.out.println("solde du compte " +
		 * x.getNomCompte() + " = " + y.soldeCompte(x)); }
		 * 
		 * System.out.
		 * println("Souhaitez-vous refaire une op�ration sur ce compte ? o/n");
		 * i = clavier.next().toLowerCase(); clavier.nextLine(); } }
		 * 
		 * System.out.println("Souhaitez-vous ajouter un compte ? o/n"); i =
		 * clavier.next().toLowerCase(); clavier.nextLine();
		 * 
		 * }
		 */
		clavier.close();
		System.out.println("Fin du Programme de gestion de compte");

	}

	/**
	 * M�thode cr�ant un nouveau compte
	 * @param x objet Compte
	 * @param clavier entr�e clavier
	 */
	public static void creationCompte(Compte x) {
		System.out.println("ID du nouveau compte ?");
		x.setIdCompte(clavier.nextInt());
		clavier.nextLine();
		System.out.println("nom du nouveau compte ?");
		x.setNomCompte(clavier.next());
		clavier.nextLine();
		System.out.println("solde du nouveau compte ?");
		x.setSolde(clavier.nextLong());
		clavier.nextLine();
		System.out.println("---------------------------------");
		System.out.println("Nouveau compte ajout�");
		System.out.println(x.toString());
		System.out.println("---------------------------------");
		
	}

}
