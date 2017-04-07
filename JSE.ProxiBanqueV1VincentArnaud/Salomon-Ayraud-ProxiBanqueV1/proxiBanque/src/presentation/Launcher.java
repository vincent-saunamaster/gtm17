package presentation;

import java.util.ArrayList;
import java.util.Collection;

import metier.Agence;
import metier.CarteBancaire;
import metier.Client;
import metier.ClientParticulier;
import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import metier.Conseiller;
import metier.Credit;
import metier.CreditConso;
import metier.CreditImmo;
import metier.Gerant;
import metier.Paris;
import metier.Patrimoine;
import metier.Placement;
import metier.Tokyo;
import metier.VisaElectron;
import metier.VisaPremier;
import service.Services;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// pour 2 clients particuliers :

		// 2 comptes courants(numéroCompte, solde, dateCreation, Client,
		// CarteBancaire, decouvert)
		Compte referenceCompteCourantUn = new CompteCourant(1, 1000, 10000, null, null, 1000);
		Compte referenceCompteCourantDeux = new CompteCourant(2, 1000000, 10000, null, null, 1000);

		// 2 comptes épargne(numéroCompte, solde, dateCreation, Client,
		// CarteBancaire, TauxEpargne)
		Compte referenceCompteEpargneUn = new CompteEpargne(3, 1000, 10000, null, null, 0.03d);
		Compte referenceCompteEpargneDeux = new CompteEpargne(4, 1000, 10000, null, null, 0.03d);

		// 2 cartes bancaires comptes 1 pour client 1
		CarteBancaire referenceCarteBancaireUn = new VisaElectron(referenceCompteCourantUn);
		referenceCompteCourantUn.setCarteBancaire(referenceCarteBancaireUn);
		CarteBancaire referenceCarteBancaireDeux = new VisaPremier(referenceCompteEpargneUn);
		referenceCompteEpargneUn.setCarteBancaire(referenceCarteBancaireDeux);

		// 2 cartes bancaires comptes 2 pour client 2
		CarteBancaire referenceCarteBancaireTrois = new VisaElectron(referenceCompteCourantDeux);
		referenceCompteCourantDeux.setCarteBancaire(referenceCarteBancaireTrois);
		CarteBancaire referenceCarteBancaireQuatre = new VisaPremier(referenceCompteEpargneDeux);
		referenceCompteEpargneDeux.setCarteBancaire(referenceCarteBancaireQuatre);

		// 2 clients particuliers
		Client referenceClientParticulierUn = new ClientParticulier();
		referenceCompteCourantUn.setClient(referenceClientParticulierUn);
		referenceCompteEpargneUn.setClient(referenceClientParticulierUn);
		Client referenceClientParticulierDeux = new ClientParticulier();
		referenceCompteCourantDeux.setClient(referenceClientParticulierDeux);
		referenceCompteEpargneDeux.setClient(referenceClientParticulierDeux);

		// 2 collections de comptes pour les 2 clients
		Collection<Compte> referenceCollectionComptesUn = new ArrayList<Compte>();
		referenceCollectionComptesUn.add(referenceCompteCourantUn);
		referenceCollectionComptesUn.add(referenceCompteEpargneUn);
		referenceClientParticulierUn.setComptes(referenceCollectionComptesUn);
		Collection<Compte> referenceCollectionComptesDeux = new ArrayList<Compte>();
		referenceCollectionComptesDeux.add(referenceCompteCourantDeux);
		referenceCollectionComptesDeux.add(referenceCompteEpargneDeux);
		referenceClientParticulierDeux.setComptes(referenceCollectionComptesDeux);

		// patrimoine : 2 placement pour client 2, 0 pour client 1
		Patrimoine referencePatrimoineUn = new Patrimoine();
		Collection<Placement> referenceCollectionPlacementsUn = new ArrayList<>();
		referencePatrimoineUn.setPlacements(referenceCollectionPlacementsUn);
		referencePatrimoineUn.setClient(referenceClientParticulierUn);
		referenceClientParticulierUn.setPatrimoine(referencePatrimoineUn);
		Patrimoine referencePatrimoineDeux = new Patrimoine();
		Placement referencePlacementUn = new Paris(referencePatrimoineDeux);
		Placement referencePlacementDeux = new Tokyo(referencePatrimoineDeux);
		Collection<Placement> referenceCollectionPlacementsDeux = new ArrayList<>();
		referenceCollectionPlacementsDeux.add(referencePlacementUn);
		referenceCollectionPlacementsDeux.add(referencePlacementDeux);
		referencePatrimoineDeux.setPlacements(referenceCollectionPlacementsDeux);
		referencePatrimoineDeux.setClient(referenceClientParticulierDeux);
		referenceClientParticulierDeux.setPatrimoine(referencePatrimoineDeux);

		// 2 Credits pour client 1, o pour client 2
		Credit referenceCreditUn = new CreditConso(referenceClientParticulierUn);
		Credit referenceCreditDeux = new CreditImmo(referenceClientParticulierUn);
		Collection<Credit> referenceCollectionCreditUn = new ArrayList<Credit>();
		referenceCollectionCreditUn.add(referenceCreditUn);
		referenceCollectionCreditUn.add(referenceCreditDeux);
		referenceClientParticulierUn.setcredits(referenceCollectionCreditUn);
		Collection<Credit> referenceCollectionCreditDeux = new ArrayList<Credit>();
		referenceClientParticulierDeux.setcredits(referenceCollectionCreditDeux);

		// 2 conseillers (1 avec 2 clients, 1 avec 0 clients)
		Conseiller referenceConseillerUn = new Conseiller();
		Collection<Client> referenceCollectionClient = new ArrayList<Client>();
		referenceCollectionClient.add(referenceClientParticulierUn);
		referenceCollectionClient.add(referenceClientParticulierDeux);
		referenceConseillerUn.setClients(referenceCollectionClient);
		Conseiller referenceConseillerDeux = new Conseiller();
		Collection<Client> referenceCollectionClientDeux = new ArrayList<Client>();
		referenceConseillerDeux.setClients(referenceCollectionClientDeux);
		referenceClientParticulierUn.setConseiller(referenceConseillerUn);
		referenceClientParticulierDeux.setConseiller(referenceConseillerUn);

		// 1 Gerant
		Gerant referenceGerant = new Gerant();
		referenceConseillerUn.setGerant(referenceGerant);
		referenceConseillerDeux.setGerant(referenceGerant);
		Collection<Conseiller> referenceCollectionConseillers = new ArrayList<Conseiller>();
		referenceCollectionConseillers.add(referenceConseillerUn);
		referenceCollectionConseillers.add(referenceConseillerDeux);
		referenceGerant.setConseillers(referenceCollectionConseillers);

		// 1 Agence
		Agence referenceAgence = new Agence();
		referenceGerant.setAgence(referenceAgence);
		referenceAgence.setIdAgence("AAAAA");
		referenceAgence.setDateCreation(10000);
		referenceAgence.setGerant(referenceGerant);

		// Démonstraion

		// creationCompte
		Services test = new Services();
		System.out.println("DEMONSTRATION");
		System.out.println("\nCREATION COMPTE");
		Client testClient = test.creerClient(referenceCollectionComptesUn, referencePatrimoineUn,
				referenceCollectionCreditUn, referenceConseillerUn, 1);
		System.out.println(testClient.getConseiller());
		System.out.println(testClient.getComptes());
		System.out.println(testClient.getcredits());
		System.out.println(testClient.getPatrimoine());
		// virement
		System.out.println("\nVIREMENT DE COMPTE A COMPTE");
		System.out.println("AVANT VIREMENT :");
		System.out.println(referenceCompteCourantUn.getSolde());
		System.out.println(referenceCompteCourantDeux.getSolde());
		test.effectuerVirement(100, referenceCompteCourantUn, referenceCompteCourantDeux);
		System.out.println("APRES VIREMENT :");
		System.out.println(referenceCompteCourantUn.getSolde());
		System.out.println(referenceCompteCourantDeux.getSolde());
		// création Placement
		System.out.println("\nCréation Placement");
		System.out.println("AVANT PLACEMENT :");
		System.out.println(referencePatrimoineDeux.toString());
		test.creerPlacement(referencePatrimoineDeux, 3);
		System.out.println("APRES PLACEMENT :");
		System.out.println(referencePatrimoineDeux.toString());
		System.out.println("\nValeurs des objets de la démonstration :");
		System.out.println(referenceAgence.toString());
		System.out.println(referenceGerant.toString());
		System.out.println(referenceConseillerUn.toString());
		System.out.println(referenceClientParticulierUn);
		System.out.println(referenceCompteCourantUn.toString());

	}

}
