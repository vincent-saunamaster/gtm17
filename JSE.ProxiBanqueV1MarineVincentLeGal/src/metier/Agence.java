/**
 * 
 */
package metier;

import java.util.Arrays;

/**
 * Métier Agence
 * Classe présentant l'Agence avec un numéro d'identifiant, une date de création, une adresse et un Gérant
 * @author ME VLG
 *
 */
public class Agence {

	
	private String idAgence[];
	private String dateCreation;
	private Adresse adresseAgence;
	private Gerant leGerant;
	
	
	
	public String[] getIdAgence() {
		return idAgence;
	}
	public void setIdAgence(String[] idAgence) {
		this.idAgence = idAgence;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Adresse getAdresseAgence() {
		return adresseAgence;
	}
	
	public void setAdresseAgence(Adresse adresseAgence) {
		this.adresseAgence = adresseAgence;
	}
	
	public Gerant getLeGerant() {
		return leGerant;
	}
	
	public void setLeGerant(Gerant leGerant) {
		this.leGerant = leGerant;
	}
	
	
	@Override
	public String toString() {
		return "Agence [idAgence=" + Arrays.toString(idAgence) + ", dateCreation=" + dateCreation + "]";
	}
	
	
	
	
	/**
	 * Constructeur de l'Agence à 2 arguments
	 * @param idAgence Correspond au numéro d'identification de l'Agence
	 * @param dateCreation Correspond à la date de création de l'Agence
	 */
	public Agence(String[] idAgence, String dateCreation) {
		super();
		this.idAgence = idAgence;
		this.dateCreation = dateCreation;
	}
	
	
	/**
	 * Constructeur de l'Agence sans argument
	 */
	public Agence() {
		super();
	}
	
	
	
	
	
	
}
