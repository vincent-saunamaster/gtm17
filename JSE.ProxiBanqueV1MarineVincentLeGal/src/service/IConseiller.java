package service;

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
 * 
 * Interface ConseillerClient faisant appelle aux méthodes d'Ajout/Modification/Suppression/Affichage d'un client par un Conseiller
 * @author ME VLG
 *
 *
 */
public interface IConseiller {

	
	public void AjouterClient(Conseiller co, Client c) throws LeConseillerADeja10Clients;
	public void ModifierClient(Client c, Adresse a, int telephone);
	public void SupprimerClient (Client c, Conseiller co);
	public void AfficherClient(Client c);
	public void ActivationCarteVisa(Compte c, CarteVisa cv);
	public void DesactivationCarteVisa(Compte c, CarteVisa cv);
	public void AjouterCompteClient (Client c, Compte co) throws CompteEpargneExistantException, CompteCourantExistantException;
	public void SupprimerCompteClient (Compte compte, Client c) throws AbsenceDeCompteEpargneException, AbsenceDeCompteCourantException;
	public void AfficherCompteClient (Compte compte);
	public void GestionPatrimoine(Client c);
	public void EffectuerVirement(Compte c1, Compte c2, int montant) throws MontantNegatifException, MontantSuperieurAuSoldeException, DecouvertNonAutorise;
	public double EffectuerSimulationCredit(double montant, int taux, int duree) throws MontantNegatifException;
	
	
	
}
