package metier;

/**
 * Classe Employe qui crée un objet Employe
 * @author Stagiaire
 *
 */
public class Employe {
	
	private static long idStack;
	
	protected String nom;
	protected String prenom;
	protected long id;
	
/**
 * Getter de l'attribut Nom (facultatif)
 * @return Le numéro id qu'aura le prochain employé ajouté
 */
	public static long getIdStack() {
		return idStack;
	}
/**
 * 1er Constructeur Employe (facultatif) qui incréemente le numéro id d'employé
 * @param nom nom de l'employé
 * @param prenom prenom de l'employé
 */
	public Employe(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.id = idStack;
		idStack++;
	}
	/**
	 * Méthode d'affichage de la classe Employe
	 * @return le nom, le prénom et l'id de l'emlpoyé
	 */
	@Override
	public String toString() {
		return "Employe [nom=" + nom + ", prenom=" + prenom + ", id=" + id + "]";
	}
	
	

}
