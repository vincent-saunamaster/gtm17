/**
 * 
 */
package service;

import java.util.Collection;

import metier.Adresse;
import metier.CarteVisa;
import metier.Client;
import metier.Compte;
import metier.Conseiller;
import service.exception.AbsenceDeCompteCourantException;
import service.exception.AbsenceDeCompteEpargneException;
import service.exception.CompteCourantExistantException;
import service.exception.CompteEpargneExistantException;
import service.exception.DecouvertNonAutorise;
import service.exception.LeConseillerADeja10Clients;
import service.exception.MontantNegatifException;
import service.exception.MontantSuperieurAuSoldeException;

/**
 * La Classe ServiceConseiller regroupe l'ensemble des op�rations effectuable par un conseiller
 * @author ME VLG
 *
 */
public class ServiceConseiller implements  IConseiller  {

	/**
	 * Virement d'un montant d'un compte A � un compte B 
	 * @throws MontantSuperieurAuSoldeException 
	 * @throws DecouvertNonAutorise 
	 */
	
	@Override
	public void EffectuerVirement(Compte c1, Compte c2, int montant) throws MontantNegatifException, MontantSuperieurAuSoldeException, DecouvertNonAutorise {
		
		if (montant<0) //Test si le montant entr� est inf�rieur � 0
		{
			throw new MontantNegatifException("montant inf�rieur � zero");
		}
		else 
		{
			if(c1.getTypeCompte()==3) //Test si le compte est un compte Epargne
			{
				if(montant<c1.getSolde()) // Test si le montant est inferieur au solde du compte
				{
					c1.setSolde(c1.getSolde()-montant);
					c2.setSolde(c2.getSolde()+montant);
				}
				else
				{
					throw new MontantSuperieurAuSoldeException("montant supperieur au solde");
				}
			}
			else
			{
				if(c1.getTypeCompte()==1000) //Test si le compte est un compte Courant
				{
					if((c1.getSolde()-montant)>-1000) //Test si le solde du compte vir� est au dessus du d�couvert autoris�
					{
						c1.setSolde(c1.getSolde()-montant);
						c2.setSolde(c2.getSolde()+montant);
					}
					else
					{
						throw new DecouvertNonAutorise("le decouvert n'autorise pas ce virement");
					}
				}
			
			}
		}
			
	}

/**
 * Realisation d'une simulation de cr�dit avec un montant, un taux et une dur�e de remboursement
 * @throws MontantNegatifException 
 */
	@Override
	public double EffectuerSimulationCredit(double montant, int taux, int duree) throws MontantNegatifException {
		double montantARembourserParMois;
		if (montant<=0) //Test si le montant entr� est inf�rieur � 0
		{
			montantARembourserParMois = 0;
			throw new MontantNegatifException("montant de remboursement negatif");
		}
		else
		{
		double montantARembourser = montant*(1+(taux/100)); //Calcul de la somme totale � rembours� (montant avec les interets)
		montantARembourserParMois = montantARembourser/duree; //Calcul des mensualit�s � rembourser par le client
		}
		return montantARembourserParMois;
	}


	@Override
	public void GestionPatrimoine(Client c) {

	}


	/**
	 * Ajout d'un compte Epargne ou un Compte Courant � un client
	 * @throws CompteEpargneExistantException 
	 * @throws CompteCourantExistantException 
	 */
		@Override
		public void AjouterCompteClient(Client c, Compte co) throws CompteEpargneExistantException, CompteCourantExistantException {

			if(co.getTypeCompte() == 3){ //Test si le compte � ajouter est un Compte Epargne
				if(c.getMonCompteEpargne() == null){ // Test pour savoir si le client a d�j� un compte epargne
				
					c.setMonCompteEpargne(co);
					System.out.println("Le compte Epargne a �t� ajout�.");
				}else{
					throw new CompteEpargneExistantException("Le client a d�j� un Compte Epargne.");
				}				
			
			}
			else{
				if(co.getTypeCompte() == 1000){	// Dans le cas d'un ajout de Compte Courant
					if(c.getMonCompteCourant() == null){ // Test pour savoir si le client a d�j� un compte courant
					
						c.setMonCompteCourant(co);
						System.out.println("Le compte courant a �t� ajout�.");
											
					}
					else{
						throw new CompteCourantExistantException("Le client a d�j� un Compte Courant.");
					}
				
				}
				
							
			}			
		}

	/**
	 * Suppression d'un compte Epargne ou compte courant
	 * @throws AbsenceDeCompteEpargneException 
	 * @throws AbsenceDeCompteCourantException 
	 */

		@Override
		public void SupprimerCompteClient(Compte co, Client c) throws AbsenceDeCompteEpargneException, AbsenceDeCompteCourantException {
				
			if(co.getTypeCompte() == 3){ //Test si le compte � supprimer est un Compte Epargne
				if(c.getMonCompteEpargne() != null){ // Test pour savoir si le client a d�j� un compte epargne
				
				c.setMonCompteEpargne(null);
				System.out.println("Le compte Epargne a �t� supprim�.");
				
				}else{
					throw new AbsenceDeCompteEpargneException("Le Client n'a pas de compte �pargne");
				}				
			
			}
			else{
				if(co.getTypeCompte() == 1000){	// Dans le cas d'une suppression du Compte Courant
					if(c.getMonCompteCourant() != null){ // Test pour savoir si le client a d�j� un compte courant
					
						c.setMonCompteCourant(null);
						System.out.println("Le compte courant a �t� supprim�.");
											
					}
					else{
						throw new AbsenceDeCompteCourantException("Le Client n'a pas de compte courant.");
					}
				}
										
			}			
			
		}

	/**
	 * Affichage d'un compte client
	 */
		@Override
		public void AfficherCompteClient(Compte compte) {
			System.out.println(compte);
		}

	/**
	 * Ajouter un client par un conseiller
	 * @throws LeConseillerADeja10Clients 
	 */
		@Override
		public void AjouterClient(Conseiller co, Client c) throws LeConseillerADeja10Clients {
		
			if((co.getMesClientsEntreprises().size() + co.getMesClientsParticuliers().size()) < 10){ // Addition du nbre de client entreprise et  nbre client particulier devant �tre inf�rieur � 10
			
				if(c.getTypeClient()==1){ //Test si client entreprise ou particulier
			
					//Ajouter client particulier
					Collection<Client> cl1 = co.getMesClientsParticuliers(); //R�cup�ration de la liste des clients du conseiller dans la collection cl1
					cl1.add(c); //Ajout du client c � la collection cl1
					co.setMesClientsParticuliers(cl1); //Association de la nouvelle collection cl1 au conseiller co
					c.setMonConseillerClient(co); //Association du conseiller co au client c
					
					//Ajout Client � la liste de tous les clients
					Collection<Client> col2 = co.getTousMesClients();
					col2.add(c); //Ajout du client � tous les clients cl2
					co.setTousMesClients(col2); //Association de la nouvelle collection cl2 � la liste
											
					
					
				}
				else{
					//Ajouter client entreprise
				
					Collection<Client> cl2 = co.getMesClientsEntreprises();
					cl2.add(c);
					co.setMesClientsEntreprises(cl2);
					c.setMonConseillerClient(co);
					
					
					//Ajout Client � la liste de tous les clients
					Collection<Client> col3 = co.getTousMesClients();
					col3.add(c); //Ajout du client � tous les clients cl2
					co.setTousMesClients(col3); //Association de la nouvelle collection cl2 � la liste
					}
			
			} else{
				throw new LeConseillerADeja10Clients("Vous avez d�j� 10 clients.");
			}	
				
		}

		/**
		 * Modification de l'adresse et du t�l�phone du client
		 */

		@Override
		public void ModifierClient(Client c, Adresse a, int telephone) {
					
			c.setTelephone(telephone);
			c.setSonAdresse(a);
		}
	/**
	 * Supprime un client de la liste d'un conseiller
	 */

		@Override
		public void SupprimerClient(Client c, Conseiller co) {
			
			if(c.getTypeClient()==1){ //Test si client entreprise ou particulier
			
			Collection<Client> col = co.getMesClientsParticuliers(); //R�cup�ration de la liste des clients du conseiller dans la collection col
			col.remove(c);	//Suppression du client de la collection
			co.setMesClientsParticuliers(col);	//Association de la Collection mise � jour au conseiller
			
			//Suppression du Client � la liste de tous les clients
			Collection<Client> cl2 = co.getTousMesClients();
			cl2.remove(c); //Ajout du client � tous les clients cl2
			co.setTousMesClients(cl2); //Association de la nouvelle collection cl2 � la liste
			
			}
			
			Collection<Client> col = co.getMesClientsEntreprises(); //R�cup�ration de la liste des clients du conseiller dans la collection col
			col.remove(c);	//Suppression du client de la collection
			co.setMesClientsEntreprises(col);	//Association de la Collection mise � jour au conseiller
			
			//Suppression du  Client � la liste de tous les clients
			Collection<Client> cl2 = co.getTousMesClients();
			cl2.remove(c); //Ajout du client � tous les clients cl2
			co.setTousMesClients(cl2); //Association de la nouvelle collection cl2 � la liste
				
			}
	/**
	 * Affichage d'un client
	 */

		@Override
		public void AfficherClient(Client c) {
		
			System.out.println(c);
		}
	/**
	 * Ajout d'une carte � un compte
	 */

		@Override
		public void ActivationCarteVisa(Compte c, CarteVisa cv) {
				c.setMaCarteVisa(cv);
				System.out.println("La carte " + cv +" a �t� activ�e pour le compte " + c);
		}

	/**
	 *Supprimer la carte de son compte 
	 */

		@Override
		public void DesactivationCarteVisa(Compte c, CarteVisa cv) {
				c.setMaCarteVisa(null);
				System.out.println("La carte " + cv +" a �t� supprim�e de compte " + c);
		}

	}