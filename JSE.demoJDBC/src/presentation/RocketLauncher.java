package presentation;

import java.util.ArrayList;
import java.util.Collection;

import metier.Client;
import service.ClientService;
import service.IClientService;
import service.IClientVipService;

public class RocketLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Client c = new Client();
		Collection<Client> col = new ArrayList<>();

		// décla Interface
		IClientService s = new ClientService();
		IClientVipService vs = new ClientService();

		// décla classe
		ClientService cs = new ClientService();

		// utilisation de l' interface non VIP
		s.direBonjour();
		s.direAuRevoir();
		// s.direJeSuisVip();

		// utilisation de l' interface VIP
		vs.direBonjour();
		vs.direAuRevoir();
		vs.direJeSuisVip();

		// utilisation de la classe qui l'interface VIP
		cs.direBonjour();
		cs.direAuRevoir();
		cs.direJeSuisVip();

		System.out.println("ajouter client en bdd");
		c.setNom("tutu");
		c.setPrenom("titi");
		c.setCouleurYeux("marron");
		// s.ajouterClient(c);
		// s.supprimerClient(c);
		System.out.println("lister client en bdd");
		col = s.listerClient();
		for (Client cli : col) {
			System.out.println(cli);
		}
		System.out.println("modifier client en bdd");
		s.modifierClient(1, "hoho", "haha", "vert");
		s.modifierClient(5, "hihi", "huhu", "bleu");
		System.out.println("lister client en bdd");
		col = s.listerClient();
		for (Client cli : col) {
			System.out.println(cli);
		}
		System.out.println("chercher client en bdd");
		c = s.chercherClient(2);
		System.out.println(c);
		System.out.println("supprimer client en bdd");
		s.supprimerClient(6);
		System.out.println("lister client en bdd");
		col = s.listerClient();
		for (Client cli : col) {
			System.out.println(cli);
		}
		System.out.println("chercher client par mot clé en bdd");
		col = s.chercherParcMC("h");
		for (Client client : col) {
			System.out.println(client);
		}
	}

}
