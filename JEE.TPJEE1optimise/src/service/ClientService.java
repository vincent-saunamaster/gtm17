package service;

import java.util.Collection;

import dao.Dao;
import dao.IDao;
import metier.Client;

public class ClientService implements IClientVipService {

	// cet attribut permet de solliciter la couche dao
	private IDao idao = new Dao();

	@Override
	public void direBonjour() {
		// TODO Auto-generated method stub
		System.out.println("BONJOUR");
	}

	@Override
	public void direAuRevoir() {
		// TODO Auto-generated method stub
		System.out.println("AU REVOIR");
	}

	@Override
	public void direJeSuisVip() {
		// TODO Auto-generated method stub
		System.out.println("JE SUIS VIP");
	}

	@Override
	public void ajouterClient(Client c) {
		// TODO Auto-generated method stub
		idao.ajouterClient(c);
	}

	@Override
	public void modifierClient(int id, String nom, String prenom, String couleurYeux, int age) {
		// TODO Auto-generated method stub
		idao.modifierClient(id, nom, prenom, couleurYeux, age);

	}

	@Override
	public void supprimerClient(int id) {
		// TODO Auto-generated method stub
		idao.supprimerClient(id);
	}

	@Override
	public Collection<Client> listerClient() {
		// TODO Auto-generated method stub

		return idao.listerClient();
	}

	@Override
	public Collection<Client> chercherParcMC(String motCle) {
		// TODO Auto-generated method stub
		return idao.chercherParcMC(motCle);
	}

	@Override
	public Client chercherClient(int id) {
		// TODO Auto-generated method stub
		return idao.chercherClient(id);
	}

}
