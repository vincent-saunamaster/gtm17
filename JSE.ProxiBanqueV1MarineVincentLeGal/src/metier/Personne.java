/**
 * 
 */
package metier;

/**
 * Metier Personne
 * Classe mère identifiant les clients, les gérants et les conseillers par un nom, prenom, telephone et un identificant
 * La classe Personne est associée à la classe Adresse.
 * @author ME VLG
 *
 */
public abstract class Personne {

	
	private String nom;
	private String prenom;
	private int telephone;
	private int id;
	
	private Adresse sonAdresse;
	
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Adresse getSonAdresse() {
		return sonAdresse;
	}
	
	public void setSonAdresse(Adresse sonAdresse) {
		this.sonAdresse = sonAdresse;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	/**
	 * Constructeur de Personne sans argument
	 */
	public Personne() {
		super();
	}
	/**
	 * Constructeur de Personne avec 5 arguments
	 * @param nom Nom de la personne
	 * @param prenom Prenom de la personne
	 * @param telephone Telephone de la personne
	 * @param id Numéro d'identifiant de la personne
	 * @param sonAdresse Adresse de la personne
	 */
	public Personne(String nom, String prenom, int telephone, int id, Adresse sonAdresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.id = id;
		this.sonAdresse = sonAdresse;
	}
	// Affichage Personne
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", id=" + id
				+ ", sonAdresse=" + sonAdresse + "]";
	}
	
	
	
}
