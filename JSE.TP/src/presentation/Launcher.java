package presentation;


import java.util.Scanner;

import metier.Employe;
/**
 * La classe Launcher sert à démarrer le programme
 * @author Stagiaire
 */
public class Launcher {
	/**
	 * La méthode main est chargée en mémoire au démarrage d l'application et peut donc être utilisé avant la création de tout objet.
	 * @param args arguments de la méthode main
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("ajout de nouveau employés");
		
		//ajout statique
		Employe numeroUn = new Employe("uno", "primo");
		System.out.println(numeroUn);
		
		Scanner clavier = new Scanner(System.in);
		System.out.println("ajouter un nouvel employé ? o/n");
		String i;
		i = clavier.next();
		
		while (i.equals("o")){ 
			System.out.println("nom du nouvel employé ?");
			String nom = clavier.next();
		
			System.out.println("prenom du nouvel employé ?");
			String prenom = clavier.next();
		
			Employe x = new Employe(nom, prenom);
			System.out.println("nouvel employé ajouté");
			System.out.println(x);
			
			System.out.println("ajouter un nouvel employé ? o/n");
		i = clavier.next();
		}
			
		clavier.close();
		
		
		
		
		System.out.println("fin du programme");
	

	}

}
