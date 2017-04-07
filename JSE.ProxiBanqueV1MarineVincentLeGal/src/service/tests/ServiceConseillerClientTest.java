package service.tests;

import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import metier.Adresse;
import metier.Client;
import metier.Conseiller;
import service.IConseiller;
import service.ServiceConseiller;
import service.exception.LeConseillerADeja10Clients;

public class ServiceConseillerClientTest {

	
	// Test d'ajout d'un client particulier : association d'un client à un conseiller
	@Test
	public void testAjouterClient() {
		
		IConseiller sc = new ServiceConseiller();	//Créer un service
		
		Conseiller conseiller1 = new Conseiller();	//Créer un conseiller
		Adresse a1 = new Adresse("rue A",69000,"Lyon");		// Création et instanciation d'un client
		Client client1 = new Client("Toto","Titi",0606060606,001,a1,1); //Création d'un client particulier (type 1)
		
		Collection<Client> col1 = conseiller1.getMesClientsParticuliers(); //Collection de clients particulier pour un conseiller
		col1.add(client1);	//Ajout du client 1 à la collection
		conseiller1.setMesClientsParticuliers(col1);
		client1.setMonConseillerClient(conseiller1);
		
		Conseiller conseiller2 = new Conseiller(); //Créer un 2eme conseiller
		Client client2 = new Client("Toto","Titi",0606060606,001,a1,1); //Création d'un client particulier 2 identique au client 1
		try {
			sc.AjouterClient(conseiller2, client2);
		} catch (LeConseillerADeja10Clients e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Appel à la méthode AjouterClient:Association client 2 au conseiller 2
		
		Assert.assertEquals(true, (conseiller1.getMesClientsParticuliers().size()==conseiller2.getMesClientsParticuliers().size())); //Compare la tailler de la collection du conseiller 2 avec le conseiller 1 (Client Particulier) 
		
	}
	
	// Test identique au testAjouterClient pour Client Entreprise
	public void testAjouterClient2() {
		IConseiller sc = new ServiceConseiller();
		
		Conseiller conseiller1 = new Conseiller();
		Adresse a1 = new Adresse("rue A",69000,"Lyon");
		Client client1 = new Client("Toto","Titi",0606060606,001,a1,2);
		
		Collection<Client> col1 = conseiller1.getMesClientsEntreprises();
		col1.add(client1);
		conseiller1.setMesClientsEntreprises(col1);
		client1.setMonConseillerClient(conseiller1);
		
		Conseiller conseiller2 = new Conseiller();
		Client client2 = new Client("Toto","Titi",0606060606,001,a1,2);
		try {
			sc.AjouterClient(conseiller2, client2);
		} catch (LeConseillerADeja10Clients e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		Assert.assertEquals(true, (conseiller1.getMesClientsEntreprises().size()==conseiller2.getMesClientsEntreprises().size()));
	}
	
	//cas ou le conseiller a deja 10 clients Particuliers et ajout d'un 11ème
	@Test
	public void testAjouterClient3() {
		
		IConseiller sc = new ServiceConseiller();
		
		Conseiller conseiller1 = new Conseiller();
		Adresse a1 = new Adresse("rue A",69000,"Lyon");
		Adresse a2 = new Adresse("rue B",69001,"Lyon");
		Adresse a3 = new Adresse("rue C",69002,"Lyon");
		Adresse a4 = new Adresse("rue D",69003,"Lyon");
		Adresse a5 = new Adresse("rue E",69004,"Lyon");
		Adresse a6 = new Adresse("rue F",69005,"Lyon");
		Adresse a7 = new Adresse("rue G",69006,"Lyon");
		Adresse a8 = new Adresse("rue H",69007,"Lyon");
		Adresse a9 = new Adresse("rue I",69008,"Lyon");
		Adresse a10 = new Adresse("rue J",69009,"Lyon");
		Client client1 = new Client("Toto","Titi",0606060606,001,a1,1);
		Client c2 = new Client ("Toto","Tit",0606060606,010, a2,1);
		Client c3 = new Client ("Erer","Titi",0606060606,002, a3,1);
		Client c4 = new Client ("Fdfd","Tito",0606060606,003, a4,1);
		Client c5 = new Client ("Dsds","Titu",0606060606,004, a5,1);
		Client c6 = new Client ("Vddv","Tite",0606060606,005, a6,1);
		Client c7 = new Client ("Gdgd","Tita",0606060606,006, a7,1);
		Client c8 = new Client ("Titi","Titui",0606060606,007, a8,1);
		Client c9 = new Client ("Tatat","Titoi",0606060606,01, a9,1);
		Client c10 = new Client ("roro","Titert",0606060606,05, a10,1);
		
		Collection<Client> col1 = conseiller1.getMesClientsParticuliers();
		col1.add(client1);
		col1.add(c2);
		col1.add(c3);
		col1.add(c4);
		col1.add(c5);
		col1.add(c6);
		col1.add(c7);
		col1.add(c8);
		col1.add(c9);
		col1.add(c10);
		conseiller1.setMesClientsParticuliers(col1);
		client1.setMonConseillerClient(conseiller1);
		c2.setMonConseillerClient(conseiller1);
		c3.setMonConseillerClient(conseiller1);
		c4.setMonConseillerClient(conseiller1);
		c5.setMonConseillerClient(conseiller1);
		c6.setMonConseillerClient(conseiller1);
		c7.setMonConseillerClient(conseiller1);
		c8.setMonConseillerClient(conseiller1);
		c9.setMonConseillerClient(conseiller1);
		c10.setMonConseillerClient(conseiller1);
		
		Conseiller conseiller2 = new Conseiller();
		Collection<Client> col2 = conseiller2.getMesClientsParticuliers();
		col2.add(client1);
		col2.add(c2);
		col2.add(c3);
		col2.add(c4);
		col2.add(c5);
		col2.add(c6);
		col2.add(c7);
		col2.add(c8);
		col2.add(c9);
		col2.add(c10);
		conseiller2.setMesClientsParticuliers(col2);
		client1.setMonConseillerClient(conseiller2);
		c2.setMonConseillerClient(conseiller2);
		c3.setMonConseillerClient(conseiller2);
		c4.setMonConseillerClient(conseiller2);
		c5.setMonConseillerClient(conseiller2);
		c6.setMonConseillerClient(conseiller2);
		c7.setMonConseillerClient(conseiller2);
		c8.setMonConseillerClient(conseiller2);
		c9.setMonConseillerClient(conseiller2);
		c10.setMonConseillerClient(conseiller2);
		
		Adresse a11 = new Adresse("rue K",69010,"Lyon");
		
		Client c11 = new Client ("POPO","popo",0606050505,657,a11,1);
	
		try {
			sc.AjouterClient(conseiller2, c11);
		} catch (LeConseillerADeja10Clients e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		Assert.assertEquals(true, (conseiller1.getMesClientsParticuliers().size()==conseiller2.getMesClientsParticuliers().size() && conseiller1.getMesClientsEntreprises().size()==conseiller2.getMesClientsEntreprises().size()));
		
		}
		
		//cas ou le conseiller a deja 10 client entreprises. On veut en rajouter un 11ème.
				@Test
				public void testAjouterClientEntreprise3() {
					IConseiller sc = new ServiceConseiller();
					
					Conseiller conseiller1 = new Conseiller();
					Adresse a1 = new Adresse("rue A",69000,"Lyon");
					Adresse a2 = new Adresse("rue B",69001,"Lyon");
					Adresse a3 = new Adresse("rue C",69002,"Lyon");
					Adresse a4 = new Adresse("rue D",69003,"Lyon");
					Adresse a5 = new Adresse("rue E",69004,"Lyon");
					Adresse a6 = new Adresse("rue F",69005,"Lyon");
					Adresse a7 = new Adresse("rue G",69006,"Lyon");
					Adresse a8 = new Adresse("rue H",69007,"Lyon");
					Adresse a9 = new Adresse("rue I",69008,"Lyon");
					Adresse a10 = new Adresse("rue J",69009,"Lyon");
					Client client1 = new Client("Toto","Titi",0606060606,001,a1,2);
					Client c2 = new Client ("Toto","Tit",0606060606,010, a2,2);
					Client c3 = new Client ("Erer","Titi",0606060606,002, a3,2);
					Client c4 = new Client ("Fdfd","Tito",0606060606,003, a4,2);
					Client c5 = new Client ("Dsds","Titu",0606060606,004, a5,2);
					Client c6 = new Client ("Vddv","Tite",0606060606,005, a6,2);
					Client c7 = new Client ("Gdgd","Tita",0606060606,006, a7,2);
					Client c8 = new Client ("Titi","Titui",0606060606,007, a8,2);
					Client c9 = new Client ("Tatat","Titoi",0606060606,01, a9,2);
					Client c10 = new Client ("roro","Titert",0606060606,05, a10,2);
					
					Collection<Client> col1 = conseiller1.getMesClientsEntreprises();
					col1.add(client1);
					col1.add(c2);
					col1.add(c3);
					col1.add(c4);
					col1.add(c5);
					col1.add(c6);
					col1.add(c7);
					col1.add(c8);
					col1.add(c9);
					col1.add(c10);
					conseiller1.setMesClientsParticuliers(col1);
					client1.setMonConseillerClient(conseiller1);
					c2.setMonConseillerClient(conseiller1);
					c3.setMonConseillerClient(conseiller1);
					c4.setMonConseillerClient(conseiller1);
					c5.setMonConseillerClient(conseiller1);
					c6.setMonConseillerClient(conseiller1);
					c7.setMonConseillerClient(conseiller1);
					c8.setMonConseillerClient(conseiller1);
					c9.setMonConseillerClient(conseiller1);
					c10.setMonConseillerClient(conseiller1);
					
					Conseiller conseiller2 = new Conseiller();
					Collection<Client> col2 = conseiller2.getMesClientsEntreprises();
					col2.add(client1);
					col2.add(c2);
					col2.add(c3);
					col2.add(c4);
					col2.add(c5);
					col2.add(c6);
					col2.add(c7);
					col2.add(c8);
					col2.add(c9);
					col2.add(c10);
					conseiller2.setMesClientsParticuliers(col2);
					client1.setMonConseillerClient(conseiller2);
					c2.setMonConseillerClient(conseiller2);
					c3.setMonConseillerClient(conseiller2);
					c4.setMonConseillerClient(conseiller2);
					c5.setMonConseillerClient(conseiller2);
					c6.setMonConseillerClient(conseiller2);
					c7.setMonConseillerClient(conseiller2);
					c8.setMonConseillerClient(conseiller2);
					c9.setMonConseillerClient(conseiller2);
					c10.setMonConseillerClient(conseiller2);
					
					Adresse a11 = new Adresse("rue K",69010,"Lyon"); //Ajout d'un 11 client Entreprise
					
					Client c11 = new Client ("POPO","popo",0606050505,657,a11,2);
				
					try {
						sc.AjouterClient(conseiller2, c11);
					} catch (LeConseillerADeja10Clients e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					
					Assert.assertEquals(true, (conseiller1.getMesClientsParticuliers().size()==conseiller2.getMesClientsParticuliers().size() && conseiller1.getMesClientsEntreprises().size()==conseiller2.getMesClientsEntreprises().size()));
					
				}
	

				//cas ou le conseiller a deja 5 clients Entreprises - 5 clients Particuliers
				@Test
				public void testAjouterClient4() {
					IConseiller sc = new ServiceConseiller();
					
					Conseiller conseiller1 = new Conseiller();
					Adresse a1 = new Adresse("rue A",69000,"Lyon");
					Adresse a2 = new Adresse("rue B",69001,"Lyon");
					Adresse a3 = new Adresse("rue C",69002,"Lyon");
					Adresse a4 = new Adresse("rue D",69003,"Lyon");
					Adresse a5 = new Adresse("rue E",69004,"Lyon");
					Adresse a6 = new Adresse("rue F",69005,"Lyon");
					Adresse a7 = new Adresse("rue G",69006,"Lyon");
					Adresse a8 = new Adresse("rue H",69007,"Lyon");
					Adresse a9 = new Adresse("rue I",69008,"Lyon");
					Adresse a10 = new Adresse("rue J",69009,"Lyon");
					Client client1 = new Client("Toto","Titi",0606060606,001,a1,1);
					Client c2 = new Client ("Toto","Tit",0606060606,010, a2,1);
					Client c3 = new Client ("Erer","Titi",0606060606,002, a3,1);
					Client c4 = new Client ("Fdfd","Tito",0606060606,003, a4,1);
					Client c5 = new Client ("Dsds","Titu",0606060606,004, a5,1);
					Client c6 = new Client ("Vddv","Tite",0606060606,005, a6,2);
					Client c7 = new Client ("Gdgd","Tita",0606060606,006, a7,2);
					Client c8 = new Client ("Titi","Titui",0606060606,007, a8,2);
					Client c9 = new Client ("Tatat","Titoi",0606060606,01, a9,2);
					Client c10 = new Client ("roro","Titert",0606060606,05, a10,2);
					
					Collection<Client> col1 = conseiller1.getMesClientsParticuliers();
					Collection<Client> cole1 = conseiller1.getMesClientsEntreprises();
					col1.add(client1);
					col1.add(c2);
					col1.add(c3);
					col1.add(c4);
					col1.add(c5);
					cole1.add(c6);
					cole1.add(c7);
					cole1.add(c8);
					cole1.add(c9);
					cole1.add(c10);
					conseiller1.setMesClientsParticuliers(col1);
					conseiller1.setMesClientsEntreprises(cole1);
					client1.setMonConseillerClient(conseiller1);
					c2.setMonConseillerClient(conseiller1);
					c3.setMonConseillerClient(conseiller1);
					c4.setMonConseillerClient(conseiller1);
					c5.setMonConseillerClient(conseiller1);
					c6.setMonConseillerClient(conseiller1);
					c7.setMonConseillerClient(conseiller1);
					c8.setMonConseillerClient(conseiller1);
					c9.setMonConseillerClient(conseiller1);
					c10.setMonConseillerClient(conseiller1);
					
					Conseiller conseiller2 = new Conseiller();
					Collection<Client> col2 = conseiller2.getMesClientsParticuliers();
					Collection<Client> cole2 = conseiller2.getMesClientsEntreprises();
					col2.add(client1);
					col2.add(c2);
					col2.add(c3);
					col2.add(c4);
					col2.add(c5);
					cole2.add(c6);
					cole2.add(c7);
					cole2.add(c8);
					cole2.add(c9);
					cole2.add(c10);
					conseiller2.setMesClientsParticuliers(col2);
					conseiller2.setMesClientsEntreprises(cole2);
					client1.setMonConseillerClient(conseiller2);
					c2.setMonConseillerClient(conseiller2);
					c3.setMonConseillerClient(conseiller2);
					c4.setMonConseillerClient(conseiller2);
					c5.setMonConseillerClient(conseiller2);
					c6.setMonConseillerClient(conseiller2);
					c7.setMonConseillerClient(conseiller2);
					c8.setMonConseillerClient(conseiller2);
					c9.setMonConseillerClient(conseiller2);
					c10.setMonConseillerClient(conseiller2);
					
					Adresse a11 = new Adresse("rue K",69010,"Lyon");
					Client c11 = new Client ("POPO","popo",0606050505,657,a11,1);
					try {
						sc.AjouterClient(conseiller2, c11);
					} catch (LeConseillerADeja10Clients e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					
					Assert.assertEquals(true, (conseiller1.getMesClientsParticuliers().size()==conseiller2.getMesClientsParticuliers().size() && conseiller1.getMesClientsEntreprises().size()==conseiller2.getMesClientsEntreprises().size()));
					
				}
	
				
		//Modifier un client: on ne peut modifier que le téléphone et l'adresse		
	@Test
	public void testModifierClient() {
		IConseiller sc = new ServiceConseiller(); //Création d'un service
		Client c1 = new Client();	//Création d'un client et Instanciation
		c1.setNom("Toto");
		c1.setPrenom("Titi");
		c1.setTelephone(0606060606);
		c1.setId(001);
		Adresse a1 = new Adresse("rue A",69000,"Lyon");
		c1.setSonAdresse(a1);
		Adresse a2 = new Adresse("rue B",69001,"Villeurbanne"); //Création d'une nouvelle adresse
		int telephone2 = 0707070707; //Création d'un nouveau téléphone
		Client c2 = new Client("Toto","Titi",telephone2,001,a2);		//Création client 2 qui egale au client 1 avec nouveau téléphone et nouvelle adresse
		sc.ModifierClient(c1,a2,telephone2); //Appel la fonction ModifierClient
		Assert.assertEquals(true, (c1.getSonAdresse()==c2.getSonAdresse() && c1.getTelephone() == c2.getTelephone())); //Vérifier de la modification de l'adresse et le téléphone
	}
	
	// Supprimer un client: Désassociation d'un client à son conseiller
	@Test
	public void testSupprimerClientParticulier() {
		
		IConseiller ge = new ServiceConseiller();	//Création d'un service
		Conseiller conseiller1=new Conseiller();	// Création d'un conseiller
		Adresse a1 = new Adresse("rue A",69000,"Lyon");
		Client c1 = new Client("Toto","Titi",0606060606,001,a1,1);	//Création et instanciation d'un client Particulier
		Collection<Client> col1 = conseiller1.getMesClientsParticuliers();	//Association du client au conseiller
		col1.add(c1);
		conseiller1.setMesClientsParticuliers(col1);
		c1.setMonConseillerClient(conseiller1);
		col1.remove(c1); // désassociation du client à son conseiller
		conseiller1.setMesClientsParticuliers(col1);
		
		
		
		Conseiller conseiller2= new Conseiller();	//Création d'un conseiller 2 identique au conseiller 1
		Client c2 = new Client("Toto","Titi",0606060606,001,a1,1); //Création d'un client 2 identique au client 1
		Collection<Client> col2 = conseiller2.getMesClientsParticuliers(); //Association du client au conseiller
		col2.add(c2);
		conseiller2.setMesClientsParticuliers(col2);
		c2.setMonConseillerClient(conseiller2);
		ge.SupprimerClient(c2,conseiller2);	//Utilisation de la méthode SupprimerClient
		
		//Test d'égalité de la tailler de la collection des client particuliers en conseiller 1 et 2
		Assert.assertEquals(true, (conseiller1.getMesClientsParticuliers().size()==conseiller2.getMesClientsParticuliers().size()));
		

	}
	
	// Identique au test testSupprimerClientParticulier avec un client entreprise
	@Test
	public void testSupprimerClientEntreprise() {
		
		ServiceConseiller ge = new ServiceConseiller();
		Conseiller conseiller1=new Conseiller();
		Adresse a1 = new Adresse("rue A",69000,"Lyon");
		Client c1 = new Client("Toto","Titi",0606060606,001,a1,2);
		Collection<Client> col1 = conseiller1.getMesClientsEntreprises();
		col1.add(c1);
		conseiller1.setMesClientsEntreprises(col1);
		c1.setMonConseillerClient(conseiller1);
		col1.remove(c1);
		conseiller1.setMesClientsEntreprises(col1);
		
		
		
		Conseiller conseiller2= new Conseiller();
		Client c2 = new Client("Toto","Titi",0606060606,001,a1,2);
		Collection<Client> col2 = conseiller2.getMesClientsEntreprises();
		col2.add(c2);
		conseiller2.setMesClientsEntreprises(col2);
		c2.setMonConseillerClient(conseiller2);
		ge.SupprimerClient(c2,conseiller2);
		
		
		Assert.assertEquals(true, (conseiller1.getMesClientsEntreprises().size()==conseiller2.getMesClientsEntreprises().size()));
		

	}
	
	@Ignore
	@Test
	public void testAfficherClient() {
		fail("Not yet implemented");
	}

}
