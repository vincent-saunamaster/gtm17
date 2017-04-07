package presentation;


import java.util.Scanner;

import metier.Employe;
/**
 * La classe Launcher sert � d�marrer le programme
 * @author Stagiaire
 */
public class Launcher {
	/**
	 * La m�thode main est charg�e en m�moire au d�marrage d l'application et peut donc �tre utilis� avant la cr�ation de tout objet.
	 * @param args arguments de la m�thode main
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("ajout de nouveau employ�s");
		
		//ajout statique
		Employe numeroUn = new Employe("uno", "primo");
		System.out.println(numeroUn);
		
		Scanner clavier = new Scanner(System.in);
		System.out.println("ajouter un nouvel employ� ? o/n");
		String i;
		i = clavier.next();
		
		while (i.equals("o")){ 
			System.out.println("nom du nouvel employ� ?");
			String nom = clavier.next();
		
			System.out.println("prenom du nouvel employ� ?");
			String prenom = clavier.next();
		
			Employe x = new Employe(nom, prenom);
			System.out.println("nouvel employ� ajout�");
			System.out.println(x);
			
			System.out.println("ajouter un nouvel employ� ? o/n");
		i = clavier.next();
		}
			
		clavier.close();
		
		
		
		
		System.out.println("fin du programme");
	

	}

}
