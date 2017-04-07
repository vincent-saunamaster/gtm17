package service.tests;

import org.junit.Assert;
import org.junit.Test;

import metier.CarteVisa;
import metier.Compte;
import service.IConseiller;
import service.ServiceConseiller;

public class ServiceConseillerCarteVisaTest {

	//Test d'Activation d'une carte visa. Association d'une carte � un compte
	@Test
	public void testActivationCarteVisa() {
		IConseiller sc = new ServiceConseiller(); // Initiation d'un service
		
		Compte cc1 = new Compte();	//Cr�ation et instanciation d'un compte
		cc1.setNumCompte(123);		
		cc1.setDateOuverture("01 janvier 2011");
		cc1.setSolde(10000);
		
		CarteVisa cv1 = new CarteVisa(789, "typeDeCarte"); // Cr�ation d'une carte visa
		
		cc1.setMaCarteVisa(cv1); //Association d'une carte � un compte
		
		Compte cc2 = new Compte();	//Cr�ation d'un deuxi�me compte identique au premier
		cc2.setNumCompte(123);
		cc2.setDateOuverture("01 janvier 2011");
		cc2.setSolde(10000);
	
		sc.ActivationCarteVisa(cc2,cv1);		//Appel de la m�thode Activation carte
		
		Assert.assertEquals(true, (cc2.getMaCarteVisa()==cc1.getMaCarteVisa())); //V�rifie si la carte associ�e au compte2 est identique au compte1
	}

	
	//Test de d�sactivation d'une carte
	@Test
	public void testDesactivationCarteVisa() {
		
		IConseiller sc = new ServiceConseiller();
		Compte ce1 = new Compte();	//Cr�ation d'un compte 1
		ce1.setNumCompte(123);
		ce1.setDateOuverture("01 janvier 2011");
		ce1.setSolde(10000);
		
		
		Compte ce2 = new Compte();	//Cr�ation d'un compte 2
		
		CarteVisa cv = new CarteVisa(753,"type de carte"); //Cr�ation d'une carte
		
		
		ce2.setNumCompte(123);	
		ce2.setDateOuverture("01 janvier 2011");
		ce2.setSolde(10000);
		ce2.setMaCarteVisa(cv);	//Association de la carte avec le compte2
		
		sc.DesactivationCarteVisa(ce2,cv); //Appel de la m�thode Desactivation carte: desassociation de la carte au compte2
					
		Assert.assertEquals(true, (ce1.getMaCarteVisa() == ce2.getMaCarteVisa())); // V�rifie si l
	}

}
