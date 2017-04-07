/**
 * 
 */
package metier;

/**
 * Metier Compte Epargne
 * Classe fille de Compte.
 * @author ME VLG
 *
 */
public class CompteEpargne extends Compte {

	private final static int tauxRemuneration=3;

	/**
	 * @return the tauxremuneration
	 */
	public static int getTauxremuneration() {
		return tauxRemuneration;
	}


	
	//Afficher compte
	
	
	@Override
	public String toString() {
		return "CompteEpargne [getNumCompte()=" + getNumCompte() + ", getSolde()=" + getSolde()
				+ ", getDateOuverture()=" + getDateOuverture() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
}
