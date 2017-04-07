package service;

import java.util.Collection;

import metier.Client;

public interface IClientService {
	public void direBonjour();

	public void direAuRevoir();

	//public void direJeSuisVip();
	
	public void ajouterClient(Client c);

	public void modifierClient(int id, String nom, String prenom, String couleurYeux);

	public void supprimerClient(int id);

	public Collection<Client> listerClient();

	public Collection<Client> chercherParcMC(String motCle);
	
	public Client chercherClient(int id);
}
