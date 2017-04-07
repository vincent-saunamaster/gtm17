/**
 * 
 */
package metier;

/**
 * Metier Compte Courant
 * Classe fille de Compte.
 * @author ME VLG
 *
 */
public class CompteCourant extends Compte {

	
	private final static int decouvert=1000;

	
	public static int getDecouvert() {
		return decouvert;
	}
	
	
	

	//Affichage compte
	@Override
	public String toString() {
		return "CompteCourant [getNumCompte()=" + getNumCompte() + ", getSolde()=" + getSolde()
				+ ", getDateOuverture()=" + getDateOuverture() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
}
