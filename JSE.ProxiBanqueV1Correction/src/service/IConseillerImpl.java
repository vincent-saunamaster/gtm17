package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import metier.*;

/**
 * Cette classe regroupe l'ensemble des methodes liees � la gestion des clients et des operations clients. Ce service permet de creer des clients, 
 * @author Stagiaire
 *
 */
public class IConseillerImpl implements IConseiller {
	
	/**
	 * La methode creerClient permet de creer un nouveau Client et de l'ajouter � la liste des clients d'un conseiller (s'il y a moins de dix clients affecte � ce conseiller). 
	 * @param conseiller L'objet conseiller qui souhaite ajouter un client
	 * @param nom Le nom du client
	 * @param prenom Le prenom du Client
	 * @param civilite La civilite du Client
	 * @param numeroClient Le numero affecte au client
	 * @param estSociete Le client est-il le representant d'une societe?
	 * @param nomSociete  Si le client represente une societe, nom de la societe
	 * @return Retourne true si le client a ete cree et retourne false s'il n'a pas ete cree
	 */
	public boolean creerClient (Conseiller conseiller, String nom, String prenom, String civilite, String numeroClient, boolean estSociete, String nomSociete){
		Client nouveauClient = new Client( nom, prenom, civilite, numeroClient, estSociete, nomSociete );
		
		if (conseiller.getListeClients().size() >= 10){
			System.out.println("Le conseiller " + conseiller.getNom() + " " + conseiller.getPrenom() + " poss�de d�j� 10 clients. Cr�ation de nouveau client pour ce conseiller impossible" );
			return false;
		}
		else{
			conseiller.getListeClients().add(nouveauClient);
			return true;
		}
	}

	/**
	 * @param conseiller L'objet conseiller qui souhaite ajouter un client
	 * @param nom Le nom du client
	 * @param prenom Le prenom du Client
	 * @param civilite La civilite du Client
	 * @param numeroClient Le numero affecte au client
	 * @return Retourne true si le client a ete cree et retourne false s'il n'a pas ete cree
	 */
	public boolean creerClient (Conseiller conseiller, String nom, String prenom, String civilite, String numeroClient){
		Client nouveauClient = new Client( nom, prenom, civilite, numeroClient, false, "" );
		
		if (conseiller.getListeClients().size() >= 10){
			System.out.println("Le conseiller " + conseiller.getNom() + " " + conseiller.getPrenom() + " poss�de d�j� 10 clients. Cr�ation de nouveau client pour ce conseiller impossible" );
		    return false;
		}
		else {
			conseiller.getListeClients().add(nouveauClient);
			return true;
		}
			
	}
	
	/**
	 * Methode qui retourne les informations client en lui fournissant un conseiller et un numero ID client
	 * @param conseiller Le conseiller qui a la charge du client recherche
	 * @param noClient Le numero ID du client
	 * @return Retourne l'objet Client demande s'il existe sinon retourne null.
	 */
	public Client lireClient (Conseiller conseiller, String noClient){
		
		for(Client client:conseiller.getListeClients()) {
			if(noClient.equals(client.getNoClient())) {
				return client;
			}
		}
		return null;
	}
	
	/**
	 * Cette modification permet d'obtenir un client d'une liste de client d'un conseiller, d'y apporter des modifications puis de reenregistrer  le client dans la liste. 
	 * @param conseiller Conseiller responsable du client � modifier
	 * @param clientAModifier Client dont il est necessaire de modifier les informations
	 * @param nom Le Nom du Client
	 * @param prenom Le Prenom du client
	 * @param numeroClient Le Numero du CLient
	 * @param estFortune INformation relative a la fortune du client: true le client est considere comme fortune sinon false
	 * @param estSociete True si le client est une societe
	 * @param nomSociete Chaine de caractere conteant le nom de la societe (eventuellement utilise si estSociete est true).
	 */
	public void modificationCLient (Conseiller conseiller, Client clientAModifier,  String nom, String prenom, String numeroClient, boolean estFortune, boolean estSociete, String nomSociete){
		
		if(conseiller.getListeClients().contains(clientAModifier))
		{	
			conseiller.getListeClients().remove(clientAModifier);
//			conseiller.getListeClients().add(new Client();
			System.out.println("Client modifi�");
		}
		
		else
			System.out.println("Le client n'a pas pu �tre modifi� car il ne faisait pas pas partie des clients associ�s �");
	}
	
	/**
	 * Cette methode permet au conseiller de supprimer un client de sa base de donnee
	 * @param conseiller L'objet conseiller concerne par l'ajout
	 * @param clientASupprimer L'objet client a supprimer
	 */
	public boolean supprimerClient(Conseiller conseiller, Client clientASupprimer){
		if(conseiller.getListeClients().contains(clientASupprimer))
		{
			conseiller.getListeClients().remove(clientASupprimer);
			System.out.println(clientASupprimer + " supprim�.");
			return true;
		}
		
		else
			System.out.println("Le client n'a pas pu �tre supprim� car il ne faisait pas pas partie des clients associ�s  au conseiller.");	
			return false;

	}	
	
	/**
	 * Cette methode permet d'ajouter un compte � un client existant
	 * @param client Objet client auquel le compte va etre ajoute
	 * @param typeCompte Type de compte: "Courant", "Epargne"
	 * @param numero Le Numero de compte
	 * @param solde Le Solde du compte
	 * @param dateOuverture La Date d'ouverture du compte
	 * @return Retourne un booleen: true si le compte est cree et ajoute, false sinon
	 */
	public boolean ajouterCompte(Client client, String typeCompte, String numero, float solde,
			Date dateOuverture) {
 
		switch (typeCompte) {
		case "Courant":
			return this.creerCompteCourant(client, numero, solde, dateOuverture, client.estSociete());

		case "Epargne":
			return this.creerCompteEpargne(client, numero, solde, dateOuverture, client.estSociete());

		default:
			return false;
		}
	}

	/**
	 * Cette methode permet de creer un compte courant � partir des infos clients
	 * @param client Objet client auquel le compte va etre ajoute
	 * @param numero Le Numero de compte
	 * @param solde Le Solde du compte
	 * @param compteEntreprise Est-ce un compte entreprise: si oui true sinon false
	 * @param dateOuverture La Date d'ouverture du compte
	 * @return Retourne un boleen: true: creation reussie sinon false.
	 */
	public boolean creerCompteCourant(Client client, String numero, float solde, Date dateOuverture,
			boolean compteEntreprise) {
		if (client.getCompteCourantClient() == null) {
			client.setCompteCourantClient(new CompteCourant(numero, solde, dateOuverture, compteEntreprise, client));
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Cette methode permet de creer un compte Epargne � partir des infos clients
	 * @param client Objet client auquel le compte va etre ajoute
	 * @param numero Le Numero de compte
	 * @param soldeDepart Le Solde du compte
	 * @param dateOuverture La Date d'ouverture du compte
	 * @param compteEntreprise Est-ce un compte entreprise: si oui true sinon false
	 * @return Retourne un boleen: true: creation reussie sinon false.
	 */
	public boolean creerCompteEpargne(Client client, String numero, float soldeDepart, Date dateOuverture, boolean compteEntreprise) { 
		if (client.getCompteEpargneClient() == null) {
			client.setCompteEpargneClient(new CompteEpargne(numero, soldeDepart, dateOuverture, compteEntreprise, client));
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Cette methode permet de supprimer un compte associe � un client
	 * @param conseiller Objet conseiller responsable de la demande de suppression
	 * @param client Objet Client dont le compte va etre supprime
	 * @param typeCompte Type de compte: "Courant", "Epargne", ou "Courant et Epargne"
	 * @return retourne true si la supression a reussi
	 */
	public boolean supprimerCompte(Conseiller conseiller, Client client, String typeCompte){
		
		switch (typeCompte) {
		case "Courant":
			if (client.getCompteCourantClient() != null) {
				client.setCompteCourantClient(null);
				System.out.println("Le compte courant du client a bien �t� supprim�.");
				return true;
			} else {
				System.out.println("Le client n'a pas de compte courant.");
				return false;
			}

			case "Epargne":
				if (client.getCompteEpargneClient() != null) {
					client.setCompteEpargneClient(null);
					System.out.println("Le compte epargne du client a bien �t� supprim�.");
					return true;
				} else {
					System.out.println("Le client n'a pas de compte epargne.");
					return false;
				}

		default:
			System.out.println("Compte de type " + typeCompte + " inconnu!! Suppression annul�e");
			return false;
		}
	}
	
	/** Cette methode permet de realiser un virement compte � compte au sein de la banque
	 * @param compteADebiter Le compte � debiter
	 * @param compteACrediter Le compte � crediter
	 * @param montant Le montant du virement.
	 */
	public void virementCompteACompte(Compte compteADebiter, Compte compteACrediter, float montant){
		if (compteADebiter instanceof CompteCourant && compteADebiter.getSolde() - montant < ((CompteCourant) compteADebiter).getValeurDecouvert()){
			System.out.println("Le compte a debiter a un decouvert trop important. Virement annule.");
		}
		else {
		compteADebiter.setSolde(compteADebiter.getSolde() - montant);		
		compteACrediter.setSolde(compteACrediter.getSolde() + montant);
		}
	}
	/** Cette methode permet au conseiller de realiser une simulation de Credit � partir des informations Client
	 * @param client Le Client qui souhaite realiser la simulation de credit
	 * @param creditImmo Le credit immobilier a simuler
	 */
	public void simulerCreditImmobilier(Client client, CreditImmobilier creditImmo){
		
		System.out.println("Un credit immobilier pour le client " + client.toString() + " sur " + creditImmo.getMontant() + " Euros a �t� simul� avec succ�s.");
	}
	
	public void simulerCreditConsommation(Client client, CreditConsommation creditConso){
		
		System.out.println("Un credit de consommation pour le client " + client.toString() + " sur " + creditConso.getMontant() + " Euros a �t� simul� avec succ�s.");
	}



	/**
	 * Cette methode permet de creer un nouveau placement pour un client donne
	 * @param client Le client qui souhaite effectuer un placement
	 * @param compte Le compte le montant a placer est enleve
	 * @param montant Le montant du placement
	 * @param placeFinanciere La place financiere dans laquelle le client va investir
	 */
	public boolean creerPlacement(Client client, Compte compte, float montant, String placeFinanciere){
		
		List<Placement> listePlacement = client.getListePlacement();
		
		if (compte.getSolde() > 500000) {
			if (listePlacement == null)
				client.setListePlacement(new ArrayList<Placement>());
			
			listePlacement.add(new Placement(client, montant, placeFinanciere));
			compte.setSolde(compte.getSolde() - montant);
			return true;
		} else {
			System.out.println("Le client n'est pas fortun�.");
			return false;
		}
	}
}
