package presentation;

import java.util.Scanner;

import metier.Personne;
import service.PersonneService;
/**
 * classe d'où tout commence
 * @author Stagiaire
 *
 */
public class RocketLauncher {

	/**
	 * méthode d'où tout commence
	 * @param args args du programme
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		// création d'un objet (instance) personne
		Personne p = new Personne();
		Personne p2 = new Personne("crétin", "des Alpes", 46);
		Personne p3 = new Personne("abruti", "fini");
		//valorisation des attributs
		p.setNom("l'idiot");
		p.setPrenom("du village");
		p.setAge(42);
		p3.setAge(49);
		//affichage des attributs
		System.out.println("Bonjour, " + p.getNom() + " " + p.getPrenom() + ", tu as " + p.getAge() + " ans");
		System.out.println("Bonjour, " + p2.getNom() + " " + p2.getPrenom() + ", tu as " + p2.getAge() + " ans");
		System.out.println("Bonjour, " + p3.getNom() + " " + p3.getPrenom() + ", tu as " + p3.getAge() + " ans");
		
		//test scanner
		Scanner clavier = new Scanner(System.in);
		
		System.out.println("Bonjour, ton nom ?");
		String LeNom = clavier.next();
		System.out.println("ton prenom ?");
		String LePrenom = clavier.next();
		System.out.println("Ton âge ?");
		int LAge = clavier.nextInt();
		
		//ferme scanner
		clavier.close();
		
		//créer l'objet
		Personne p4 = new Personne(LeNom, LePrenom, LAge);
		System.out.println("Bonjour, " + p4.getNom() + " " + p4.getPrenom() + ", tu as " + p4.getAge() + " ans");
		
		//avec toString()
		System.out.println(p);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		
		//couche métier
		PersonneService p5 = new PersonneService();
		System.out.println(p5.marcher(p));
		p5.arreter(p);

	}

}
