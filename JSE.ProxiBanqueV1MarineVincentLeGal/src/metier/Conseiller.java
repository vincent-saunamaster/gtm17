/**
 * 
 */
package metier;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Metier Conseiller
 * Le Conseiller est identifié par la classe Personne
 * Il est associé à un Client, Placement et Crédit.
 * @author ME VLG
 *
 */
public class Conseiller extends Personne {

	
	
	private Gerant monGerant;
	private Collection <Client> mesClientsParticuliers = new ArrayList();
	private Collection <Client> mesClientsEntreprises = new ArrayList();
	private Collection <Placement> mesPlacements  = new ArrayList();
	private Collection <Credit> mesCredits  = new ArrayList();
	private static Collection <Client> tousMesClients = new ArrayList();
	
	
	
	
	
	
	
	/**
	 * @return the tousMesClients
	 */
	public Collection<Client> getTousMesClients() {
		return tousMesClients;
	}

	/**
	 * @param tousMesClients the tousMesClients to set
	 */
	public void setTousMesClients(Collection<Client> tousMesClients) {
		this.tousMesClients = tousMesClients;
	}

	public Collection<Placement> getMesPlacements() {
		return mesPlacements;
	}
	
	public void setMesPlacements(Collection<Placement> mesPlacements) {
		this.mesPlacements = mesPlacements;
	}
	
	public Collection<Credit> getMesCredits() {
		return mesCredits;
	}
	
	public void setMesCredits(Collection<Credit> mesCredits) {
		this.mesCredits = mesCredits;
	}
	
	public Gerant getMonGerant() {
		return monGerant;
	}
	
	public void setMonGerant(Gerant monGerant) {
		this.monGerant = monGerant;
	}
	
	public Collection<Client> getMesClientsParticuliers() {
		return mesClientsParticuliers;
	}
	public void setMesClientsParticuliers(Collection<Client> mesClientsParticuliers) {
		this.mesClientsParticuliers = mesClientsParticuliers;
	}
	public Collection<Client> getMesClientsEntreprises() {
		return mesClientsEntreprises;
	}
	public void setMesClientsEntreprises(Collection<Client> mesClientsEntreprises) {
		this.mesClientsEntreprises = mesClientsEntreprises;
	}
	/**
	 * Constructeur Conseiller sans argument
	 */
	public Conseiller() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructeur Conseiller avec 5 arguments
	 * @param nom Nom du conseiller
	 * @param prenom Prenom du conseiller
	 * @param telephone Téléphone du conseiller
	 * @param id Numéro d'identification du conseiller
	 * @param sonAdresse Adresse du conseiller (rue, code postale, ville) de la classe Adresse
	 */
	public Conseiller(String nom, String prenom, int telephone, int id, Adresse sonAdresse) {
		super(nom, prenom, telephone, id, sonAdresse);
		// TODO Auto-generated constructor stub
	}
	//Afficher Conseiller
	@Override
	public String toString() {
		return "Conseiller [getId()=" + getId() + ", getSonAdresse()=" + getSonAdresse() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getTelephone()=" + getTelephone() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + "]";
	}

	
	
	
	
}
