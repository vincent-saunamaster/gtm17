/**
 * 
 */
package metier;

/**
 * Métier CarteVisa
 * Carte bancaire proposée aux Client.
 * Est associé un numéro d'identifiant de la carte et un compte
 * @author ME VLG
 *
 */
public class CarteVisa {

	
	private int idCarte;
	private Compte compteCarte;
	private String typeCarte; // CarteVisa soit Elctron soit Premier
	
	
	


	public Compte getCompteCarte() {
		return compteCarte;
	}
	public void setCompteCarte(Compte compteCarte) {
		this.compteCarte = compteCarte;
	}

	// Afficher carte visa
	@Override
	public String toString() {
		return "CarteVisa [idCarte=" + idCarte + "]";
	}

	/**
	 * Constructeur de la CarteVisa
	 * @param idCarte Retour de numéro d'identifiant de la carte
	 */
	public CarteVisa(int idCarte) {
		super();
		this.idCarte = idCarte;
	}

	
	public int getIdCarte() {
		return idCarte;
	}


	public void setIdCarte(int idCarte) {
		this.idCarte = idCarte;
	}
	public String getTypeCarte() {
		return typeCarte;
	}
	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}
	
	/**
	 * Constructeur à 2 arguments
	 * @param idCarte Identifiant de la Carte
	 * @param typeCarte Type de carte visa (Electron ou Premier)
	 */
	public CarteVisa(int idCarte, String typeCarte) {
		super();
		this.idCarte = idCarte;
		this.typeCarte = typeCarte;
	}
	
	
	
}
