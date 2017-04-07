/**
 * 
 */
package metier;

/**
 * Metier Placement
 * Classe pour la simulation Boursi�re.
 * La simulation d'un placement est r�alis�e par un conseiller.
 * Un placement est li� � la classe Localisation.
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
