package metier;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Metier Gerant.
 * Gerant de l'agence bancaire.
 * Classe associé à une agence et des conseillers.
 * Le gérant est identifié par le classe "Personne"
 * @author ME VLG
 *
 */
public class Gerant extends Personne {

	
	
	private Agence monAgence;
	private Collection <Conseiller> mesConseillers  = new ArrayList();
	
	
	
	
	
	public Agence getMonAgence() {
		return monAgence;
	}
	
	public void setMonAgence(Agence monAgence) {
		this.monAgence = monAgence;
	}
	
	public Collection<Conseiller> getMesConseillers() {
		return mesConseillers;
	}
	
	public void setMesConseillers(Collection<Conseiller> mesConseillers) {
		this.mesConseillers = mesConseillers;
	}
	/**
	 * Constructeur de Gerant sans argument
	 */
	public Gerant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Conctructeur de Gerant avec 5 arguments
	 * @param nom Nom du Gérant
	 * @param prenom Prenom du Gérant
	 * @param telephone Téléphone du Gérant
	 * @param id Numéro d'identification du Gérant
	 * @param sonAdresse Adresse du Gérant
	 */
	public Gerant(String nom, String prenom, int telephone, int id, Adresse sonAdresse) {
		super(nom, prenom, telephone, id, sonAdresse);
		// TODO Auto-generated constructor stub
	}
	
	public Gerant(Collection<Conseiller> mesConseillers) {
		super();
		this.mesConseillers = mesConseillers;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	

	//Affichage de Gérant
	@Override
	public String toString() {
		return "Gerant [mesConseillers=" + mesConseillers + "]";
	}
		
	
	


	
	
	
	
	
	
	
}
