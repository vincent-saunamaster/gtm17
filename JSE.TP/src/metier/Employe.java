package metier;

/**
 * Classe Employe qui cr�e un objet Employe
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
 * @return Le num�ro id qu'aura le prochain employ� ajout�
 */
	public static long getIdStack() {
		return idStack;
	}
/**
 * 1er Constructeur Employe (facultatif) qui incr�emente le num�ro id d'employ�
 * @param nom nom de l'employ�
 * @param prenom prenom de l'employ�
 */
	public Employe(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.id = idStack;
		idStack++;
	}
	/**
	 * M�thode d'affichage de la classe Employe
	 * @return le nom, le pr�nom et l'id de l'emlpoy�
	 */
	@Override
	public String toString() {
		return "Employe [nom=" + nom + ", prenom=" + prenom + ", id=" + id + "]";
	}
	
	

}
