package service.tests;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

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

public class ServicesTest {
	// pour 2 clients particuliers :
	// 2 comptes courants(numéroCompte, solde, dateCreation, Client,
	// CarteBancaire, decouvert)
	public Compte referenceCompteCourantUn = new CompteCourant(1, 1000, 10000, null, null, 1000);
	public Compte referenceCompteCourantDeux = new CompteCourant(2, 1000000, 10000, null, null, 1000);
	// 2 comptes épargne(numéroCompte, solde, dateCreation, Client,
	// CarteBancaire, TauxEpargne)
	public Compte referenceCompteEpargneUn = new CompteEpargne(3, 1000, 10000, null, null, 0.03d);
	public Compte referenceCompteEpargneDeux = new CompteEpargne(4, 1000, 10000, null, null, 0.03d);
	// 2 cartes bancaires comptes 1 pour client 1
	public CarteBancaire referenceCarteBancaireUn = new VisaElectron(referenceCompteCourantUn);

	public CarteBancaire referenceCarteBancaireDeux = new VisaPremier(referenceCompteEpargneUn);

	// 2 cartes bancaires comptes 2 pour client 2
	public CarteBancaire referenceCarteBancaireTrois = new VisaElectron(referenceCompteCourantDeux);

	public CarteBancaire referenceCarteBancaireQuatre = new VisaPremier(referenceCompteEpargneDeux);

	// 2 clients particuliers
	public Client referenceClientParticulierUn = new ClientParticulier();

	public Client referenceClientParticulierDeux = new ClientParticulier();

	// 2 collections de comptes pour les 2 clients
	public Collection<Compte> referenceCollectionComptesUn = new ArrayList<Compte>();

	public Collection<Compte> referenceCollectionComptesDeux = new ArrayList<Compte>();

	// 1 patrimoine pour client 2
	public Patrimoine referencePatrimoineUn = new Patrimoine();
	public Collection<Placement> referenceCollectionPlacementsUn = new ArrayList<>();
	public Patrimoine referencePatrimoineDeux = new Patrimoine();
	public Placement referencePlacementUn = new Paris(referencePatrimoineDeux);
	public Placement referencePlacementDeux = new Tokyo(referencePatrimoineDeux);
	public Collection<Placement> referenceCollectionPlacementsDeux = new ArrayList<>();

	// 2 Credits pour client 1
	public Credit referenceCreditUn = new CreditConso(referenceClientParticulierUn);
	public Credit referenceCreditDeux = new CreditImmo(referenceClientParticulierUn);
	public Collection<Credit> referenceCollectionCreditUn = new ArrayList<Credit>();
	public Collection<Credit> referenceCollectionCreditDeux = new ArrayList<Credit>();

	// 2 conseillers (1 avec 2 clients, 1 avec 0 clients)
	public Conseiller referenceConseillerUn = new Conseiller();
	public Collection<Client> referenceCollectionClient = new ArrayList<Client>();

	public Conseiller referenceConseillerDeux = new Conseiller();

	// 1 Gerant
	public Gerant referenceGerant = new Gerant();

	public Collection<Conseiller> referenceCollectionConseillers = new ArrayList<Conseiller>();

	// 1 Agence
	public Agence referenceAgence = new Agence();

	@Before
	public void testBefore() {
		System.out.println("> avant chaque test");

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
		// CarteBancaire referenceCarteBancaireUn = new
		// VisaElectron(referenceCompteCourantUn);
		referenceCompteCourantUn.setCarteBancaire(referenceCarteBancaireUn);
		// CarteBancaire referenceCarteBancaireDeux = new
		// VisaPremier(referenceCompteEpargneUn);
		referenceCompteEpargneUn.setCarteBancaire(referenceCarteBancaireDeux);

		// 2 cartes bancaires comptes 2 pour client 2
		// CarteBancaire referenceCarteBancaireTrois = new
		// VisaElectron(referenceCompteCourantDeux);
		referenceCompteCourantDeux.setCarteBancaire(referenceCarteBancaireTrois);
		// CarteBancaire referenceCarteBancaireQuatre = new
		// VisaPremier(referenceCompteEpargneDeux);
		referenceCompteEpargneDeux.setCarteBancaire(referenceCarteBancaireQuatre);

		// 2 clients particuliers
		// Client referenceClientParticulierUn = new ClientParticulier();
		referenceCompteCourantUn.setClient(referenceClientParticulierUn);
		referenceCompteEpargneUn.setClient(referenceClientParticulierUn);
		// Client referenceClientParticulierDeux = new ClientParticulier();
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
		// Patrimoine referencePatrimoineUn = new Patrimoine();
		Collection<Placement> referenceCollectionPlacementsUn = new ArrayList<>();
		referencePatrimoineUn.setPlacements(referenceCollectionPlacementsUn);
		referencePatrimoineUn.setClient(referenceClientParticulierUn);
		referenceClientParticulierUn.setPatrimoine(referencePatrimoineUn);
		// Patrimoine referencePatrimoineDeux = new Patrimoine();
		// Placement referencePlacementUn = new Paris(referencePatrimoineDeux);
		// Placement referencePlacementDeux = new
		// Tokyo(referencePatrimoineDeux);
		Collection<Placement> referenceCollectionPlacementsDeux = new ArrayList<>();
		referenceCollectionPlacementsDeux.add(referencePlacementUn);
		referenceCollectionPlacementsDeux.add(referencePlacementDeux);
		referencePatrimoineDeux.setPlacements(referenceCollectionPlacementsDeux);
		referencePatrimoineDeux.setClient(referenceClientParticulierDeux);
		referenceClientParticulierDeux.setPatrimoine(referencePatrimoineDeux);

		// 2 Credits pour client 1, o pour client 2
		// Credit referenceCreditUn = new
		// CreditConso(referenceClientParticulierUn);
		// Credit referenceCreditDeux = new
		// CreditImmo(referenceClientParticulierUn);
		Collection<Credit> referenceCollectionCreditUn = new ArrayList<Credit>();
		referenceCollectionCreditUn.add(referenceCreditUn);
		referenceCollectionCreditUn.add(referenceCreditDeux);
		referenceClientParticulierUn.setcredits(referenceCollectionCreditUn);
		Collection<Credit> referenceCollectionCreditDeux = new ArrayList<Credit>();
		referenceClientParticulierDeux.setcredits(referenceCollectionCreditDeux);

		// 2 conseillers (1 avec 2 clients, 1 avec 0 clients)
		// Conseiller referenceConseillerUn = new Conseiller();
		Collection<Client> referenceCollectionClient = new ArrayList<Client>();
		referenceCollectionClient.add(referenceClientParticulierUn);
		referenceCollectionClient.add(referenceClientParticulierDeux);
		referenceConseillerUn.setClients(referenceCollectionClient);
		// Conseiller referenceConseillerDeux = new Conseiller();
		referenceConseillerDeux.setClients(null);
		referenceClientParticulierUn.setConseiller(referenceConseillerUn);
		referenceClientParticulierDeux.setConseiller(referenceConseillerUn);

		// 1 Gerant
		// Gerant referenceGerant = new Gerant();
		referenceConseillerUn.setGerant(referenceGerant);
		referenceConseillerDeux.setGerant(referenceGerant);
		Collection<Conseiller> referenceCollectionConseillers = new ArrayList<Conseiller>();
		referenceCollectionConseillers.add(referenceConseillerUn);
		referenceCollectionConseillers.add(referenceConseillerDeux);
		referenceGerant.setConseillers(referenceCollectionConseillers);

		// 1 Agence
		// Agence referenceAgence = new Agence();
		referenceGerant.setAgence(referenceAgence);
		referenceAgence.setIdAgence("AAAAA");
		referenceAgence.setDateCreation(10000);
		referenceAgence.setGerant(referenceGerant);
	}

	@Ignore
	@Test
	public void testEffectuerAudit() {
		fail("Not yet implemented");
	}

	// test nominal
	@Test
	public void testCreerClientParticulier() {
		Services test = new Services();
		Assert.assertEquals(referenceClientParticulierUn.toString(), test.creerClient(referenceCollectionComptesUn,
				referencePatrimoineUn, referenceCollectionCreditUn, referenceConseillerUn, 1).toString());
	}

	@Ignore
	@Test
	public void testModifierClient() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testSupprimerClient() {
		fail("Not yet implemented");
	}

	// cas nominal
	@Test
	public void testEffectuerVirement() {
		Services test = new Services();
		double ref = referenceCompteCourantUn.getSolde() + 100d;
		double ref2 = referenceCompteCourantDeux.getSolde() - 100d;
		test.effectuerVirement(100, referenceCompteCourantUn, referenceCompteCourantDeux);
		Assert.assertEquals(ref, referenceCompteCourantUn.getSolde(), 0);
		Assert.assertEquals(ref2, referenceCompteCourantDeux.getSolde(), 0);
	}
	
	// cas montant négatif
	@Test
	public void testEffectuerVirementNegatif() {
		Services test = new Services();
		double ref = referenceCompteCourantUn.getSolde();
		double ref2 = referenceCompteCourantDeux.getSolde();
		test.effectuerVirement(-100d, referenceCompteCourantUn, referenceCompteCourantDeux);
		Assert.assertEquals(ref, referenceCompteCourantUn.getSolde(), 0);
		Assert.assertEquals(ref2, referenceCompteCourantDeux.getSolde(), 0);
	}
	
	// cas montant supérieur à solde + découvert
	@Test
	public void testEffectuerVirementDecouvert() {
		Services test = new Services();
		double ref = referenceCompteCourantUn.getSolde();
		double ref2 = referenceCompteCourantDeux.getSolde();
		test.effectuerVirement(10000d, referenceCompteCourantDeux, referenceCompteCourantUn);
		Assert.assertEquals(ref, referenceCompteCourantUn.getSolde(), 0);
		Assert.assertEquals(ref2, referenceCompteCourantDeux.getSolde(), 0);
	}

	@Ignore
	@Test
	public void testSimuCreditConso() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testSimuCreditImmo() {
		fail("Not yet implemented");
	}

	// test nominal
	@Test
	public void testCreerPlacementNominal() {
		Services test = new Services();
		Assert.assertEquals("NewYork []",test.creerPlacement(referencePatrimoineDeux, 3).toString());
	}

	@Ignore
	@Test
	public void testModifierPlacement() {
		fail("Not yet implemented");
	}

	// supprime un placement "non fonctionnel"
	@Ignore
	@Test
	public void testSupprimerPlacement() {
		Services test = new Services();
		Patrimoine ref = new Patrimoine();
		ref = referencePatrimoineDeux;
		test.creerPlacement(referencePatrimoineDeux, 3);
		test.supprimerPlacement(referencePlacementDeux);
		Assert.assertNotEquals(ref.toString(),referencePatrimoineDeux.toString());
	}

	@After
	public void testAfter() {
		System.out.println("> après chaque test");
	}

	@BeforeClass
	public static void testBeforeClass() {
		System.out.println("#############################");
		System.out.println(">> avant chaque suite de test");
		System.out.println("#############################");
	}

	@AfterClass
	public static void testAfterClass() {
		System.out.println("#############################");
		System.out.println(">> après chaque suite de test");
		System.out.println("#############################");
	}

}
