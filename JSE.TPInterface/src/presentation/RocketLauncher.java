package presentation;

import service.ClientService;
import service.IClientService;
import service.IClientVipService;

public class RocketLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	}

}
