/**
 * 
 */
package metier;

/**
 * Metier Placement
 * Classe pour la simulation Boursière.
 * La simulation d'un placement est réalisée par un conseiller.
 * Un placement est lié à la classe Localisation.
 * @author ME VLG
 *
 */
public class Placement {

	private Conseiller conseillerPlacement;
	private Localisation localisationPlacement;
	
	
	
	public Conseiller getConseillerPlacement() {
		return conseillerPlacement;
	}
	
	public void setConseillerPlacement(Conseiller conseillerPlacement) {
		this.conseillerPlacement = conseillerPlacement;
	}
	
	public Localisation getLocalisationPlacement() {
		return localisationPlacement;
	}
	
	public void setLocalisationPlacement(Localisation localisationPlacement) {
		this.localisationPlacement = localisationPlacement;
	}
	
	
	
	
	
}
