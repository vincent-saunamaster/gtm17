/**
 * 
 */
package metier;

/**
 * Metier Crédit
 * Classe associé au conseiller.
 * Classe mère de Crédit Immobilier et Crédit Consommation
 * @author ME VLG
 *
 */
public class Credit {

	private Conseiller conseillerCredit;

	
	public Conseiller getConseillerCredit() {
		return conseillerCredit;
	}

	
	public void setConseillerCredit(Conseiller conseillerCredit) {
		this.conseillerCredit = conseillerCredit;
	}
	
	
	
}
