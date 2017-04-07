package service.tests;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import metier.Adresse;
import metier.Client;
import metier.Compte;
import service.IConseiller;
import service.ServiceConseiller;
import service.exception.AbsenceDeCompteCourantException;
import service.exception.AbsenceDeCompteEpargneException;
import service.exception.CompteCourantExistantException;
import service.exception.CompteEpargneExistantException;

public class ServiceConseillerCompteTest {

		//Test d'ajout d'un compte � un client
	
	@Test
	public void testAjouterCompteEpargneClient() {
		IConseiller sc = new ServiceConseiller(); //Cr�ation d'un service
		Compte ce1 = new Compte(123,10000,"01 janvier 2011",3);	//Cr�ation d'un compte et instanciation
		Adresse a1 = new Adresse("rue A",69000,"Lyon");
		
		Client c1 = new Client("Toto","Titi",0606060606,001, a1); //Cr�ation d'un client avec instanciation
		
		c1.setMonCompteEpargne(ce1);	//Association d'un compte1 au client1
					
		Client c2 = new Client("Toto","Titi",0606060606,001, a1); // Cr�ation d'un client 2 identique au client 1
		try {
			sc.AjouterCompteClient(c2,ce1);
		} catch (CompteEpargneExistantException | CompteCourantExistantException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//Appel de la m�thode ajouterCompteClient pour associer le compte1 au client2
				
		//V�rifier que le client1 a le m�me compte que client 2
		Assert.assertEquals(true, (c1.getMonCompteEpargne()==c2.getMonCompteEpargne()));
	}
	
	//Test Ajouter Compte Epargne dans le cas o� le client � d�j� un compte Epargne
	
	@Test
	public void testAjouterCompteEpargneClient2() {
		IConseiller sc = new ServiceConseiller(); //Cr�ation d'un service
		
		Compte ce1 = new Compte(123,10000,"01 janvier 2011",3);	//Cr�ation d'un compte Epargne + instanciation
		Adresse a1 = new Adresse("rue A",69000,"Lyon");
		Client c1 = new Client("Toto","Titi",0606060606,001, a1);	//Cr�ation et instanciation d'un client
		c1.setMonCompteEpargne(ce1);	//Association du compte au client 
		
		Compte ce2 = new Compte(456,1000,"10 janvier 2011",3); //Cr�ation d'un compte 2 diff�rent du compte1
		
		Client c2 = new Client("Toto","Titi",0606060606,001, a1); // Cr�ation d'un client2 identique au client 1
		c2.setMonCompteEpargne(ce1); //Association du Compte1 au client2
		
		try {
			sc.AjouterCompteClient(c2, ce2);
		} catch (CompteEpargneExistantException | CompteCourantExistantException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Appel de la m�thode AjouterCompteClient pour essayer d'ajouter le compte 2 au client2
				
			
		//V�rifie que le compte2 du client2 n'a pas �t� ajout�
		Assert.assertEquals(true, (c1.getMonCompteEpargne()==c2.getMonCompteEpargne()));
	}
	
	
	
	// Test identique au testAjouterCompteEpargneClient avec un Compte Courant
	
	@Test
	public void testAjouterCompteCourantClient() {
		IConseiller sc = new ServiceConseiller();
		
		Compte ce1 = new Compte(123,10000,"01 janvier 2011",1000); //Cr�ation d'un compte1
		Adresse a1 = new Adresse("rue A",69000,"Lyon");
		
		Client c1 = new Client("Toto","Titi",0606060606,001, a1); //Cr�ation d'un client
		
		c1.setMonCompteCourant(ce1); //Assigner le compte au client
					
		
		Client c2 = new Client("Toto","Titi",0606060606,001, a1); //Cr�ation d'un client2
		try {
			sc.AjouterCompteClient(c2,ce1);
		} catch (CompteEpargneExistantException | CompteCourantExistantException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Assignation du compte1 au client2 avec la fonction AjouterClient
		
		Assert.assertEquals(true, (c1.getMonCompteCourant()==c2.getMonCompteCourant()));
	}
	
	//Test Ajouter Compte Courant dans le cas o� le client � d�j� un compte Courant
	
	@Test
	public void testAjouterCompteCourantClient2() {
		IConseiller sc = new ServiceConseiller();
		
		Compte ce1 = new Compte(123,10000,"01 janvier 2011",1000); // Cr�ation d'un Compte 1
		Adresse a1 = new Adresse("rue A",69000,"Lyon");
		Client c1 = new Client("Toto","Titi",0606060606,001, a1); //Cr�ation d'un client 1
		
		c1.setMonCompteCourant(ce1); //Assignation du compte1 au client1
		
		Compte ce2 = new Compte(456,1000,"10 janvier 2011",1000); //Cr�ation d'un compte 2
		Client c2 = new Client("Toto","Titi",0606060606,001, a1); // Cr�ation d'un client2 identique au client1
		c2.setMonCompteCourant(ce1); //Assignation du compte1 au client 2
		
		try {
			sc.AjouterCompteClient(c2, ce2);
		} catch (CompteEpargneExistantException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CompteCourantExistantException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Appel de AjouterCompteClient pour assigner le compte2 au client2
		
		Assert.assertEquals(true, (c1.getMonCompteCourant()==c2.getMonCompteCourant())); //Test pour verifier que la modification n'a pas �t� possible
	
	}
	
	//Test de la suppression de l'association d'un compte Epargne � un client	
	@Test
	public void testSupprimerCompteEpargneClient() {
		
		IConseiller sc = new ServiceConseiller(); //Cr�ation d'un service
		
		
		Compte ce1 = new Compte(123,10000,"01 janvier 2011",3);	//Cr�ation compte
		
		Adresse a1 = new Adresse("rue A",69000,"Lyon");
		Client c1 = new Client("Toto","Titi",0606060606,001, a1); //Cr�ation client
		
		
		Client c2 = new Client("Toto","Titi",0606060606,001, a1); //Cr�ation Client2
		c2.setMonCompteEpargne(ce1);
		try {
			sc.SupprimerCompteClient(ce1,c2);
		} catch (AbsenceDeCompteEpargneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AbsenceDeCompteCourantException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(true, ((c1.getMonCompteEpargne()==c2.getMonCompteEpargne())));
	}
	
	//Test de la suppression de l'association d'un compte courant � un client	
	@Test
	public void testSupprimerCompteCourantClient() {
		
		IConseiller sc = new ServiceConseiller(); //Cr�ation d'un service
		
		
		Compte ce1 = new Compte(123,10000,"01 janvier 2011",1000);	//Cr�ation compte
		
		Adresse a1 = new Adresse("rue A",69000,"Lyon");
		Client c1 = new Client("Toto","Titi",0606060606,001, a1); //Cr�ation client
		
		
		Client c2 = new Client("Toto","Titi",0606060606,001, a1); //Cr�ation Client2
		c2.setMonCompteCourant(ce1); //Assignation du compte courant au client
		try {
			sc.SupprimerCompteClient(ce1,c2);
		} catch (AbsenceDeCompteEpargneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AbsenceDeCompteCourantException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Appel de la fonction pour supprimer le compte
		
		Assert.assertEquals(true, (c1.getMonCompteCourant()==c2.getMonCompteCourant()));
	}
	
	
	
	
	@Ignore
	@Test
	public void testAfficherCompteClient() {
		fail("Not yet implemented");
	}

}
