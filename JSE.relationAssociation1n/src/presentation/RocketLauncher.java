package presentation;

import metier.Personne;
import metier.Voiture;
import service.Service;
import service.Iservice;

public class RocketLauncher {

	public static void main(String[] args) {

		Iservice service = new Service();

		Personne p = new Personne();
		p.setIdPersonne(1);
		p.setNomPersonne("toto");
		p.setPrenomPersonne("titi");

		Voiture v = new Voiture();
		v.setIdVoiture(1);
		v.setCouleur("bleue");
		v.setMarque("VW");
		Voiture v2 = new Voiture();
		v2.setIdVoiture(2);
		v2.setCouleur("vert");
		v2.setMarque("Merco");

		System.out.println(p);
		service.ajouterVoiture(p, v);
		System.out.println(p);
		service.ajouterVoiture(p, v2);
		System.out.println(p);

	}

}
