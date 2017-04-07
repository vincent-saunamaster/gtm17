package presentation;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import metier.Personne;

public class RocketLauncher {

	public static void main(String[] args) {

		// déclaration de la collection

		// on définit le Comparator de notre TreeSet dans lequel on redéfinit la
		// méthode compare()
		SortedSet<Personne> set = new TreeSet<Personne>(new Comparator<Personne>() {

			@Override
			public int compare(Personne o1, Personne o2) {
				// TODO Auto-generated method stub
				if (o1.getNom().equals(o2.getNom())) {
					return o1.getPrenom().compareTo(o2.getPrenom());
				} else {
					return o1.getNom().compareTo(o2.getNom());
				}
			}
		});

		// ici, on fait la même chose avec un tri inverse
		SortedSet<Personne> setInverse = new TreeSet<Personne>(new Comparator<Personne>() {

			@Override
			public int compare(Personne o1, Personne o2) {
				// TODO Auto-generated method stub
				if (o1.getNom().equals(o2.getNom())) {
					return -o1.getPrenom().compareTo(o2.getPrenom());
				} else {
					return -o1.getNom().compareTo(o2.getNom());
				}
			}
		});
		// et avec un tri par id
		SortedSet<Personne> setID = new TreeSet<Personne>(new Comparator<Personne>() {

			@Override
			public int compare(Personne o1, Personne o2) {
				// TODO Auto-generated method stub
				// compareTo gère des (Integer), pas des (int)
				return ((Integer) o1.getId()).compareTo((Integer) o2.getId());
			}
		});

		// création des objets
		Personne p1 = new Personne(1, "un", "uno");
		Personne p2 = new Personne(2, "un", "unouno");
		Personne p3 = new Personne(3, "deux", "deuxio");
		Personne p4 = new Personne(4, "trois", "troisio");

		// ajouter les personnes à la collection
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
		setInverse.add(p1);
		setInverse.add(p2);
		setInverse.add(p3);
		setInverse.add(p4);
		setID.add(p1);
		setID.add(p4);
		setID.add(p3);
		setID.add(p2);

		// parcourir et afficher la collection
		System.out.println("tri alphabétique");
		for (Personne p : set) {
			System.out.println(p);
		}
		System.out.println("tri inverse");
		for (Personne p : setInverse) {
			System.out.println(p);
		}
		System.out.println("tri ID");
		for (Personne p : setID) {
			System.out.println(p);
		}

	}
}
