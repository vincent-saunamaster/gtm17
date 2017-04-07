package metier;

/**
 * définit le rérentiel compte
 * 
 * @author Stagiaire
 *
 */
public abstract class Compte {

	private int id;
	private String nom;
	private float solde;
	private static int nbComptes;

	/**
	 * getter nb comptes
	 * 
	 * @return nb de comptes total
	 */
	public static int getnbComptes() {
		return nbComptes;
	}

	/**
	 * getter id
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * setter id
	 * 
	 * @param id
	 *            int
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * getter nom
	 * 
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * setter nom
	 * 
	 * @param nom
	 *            String
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * getter solde
	 * 
	 * @return solde
	 */
	public float getSolde() {
		return solde;
	}

	/**
	 * setter solde
	 * 
	 * @param solde
	 *            float
	 */
	public void setSolde(float solde) {
		this.solde = solde;
	}

	/**
	 * Constructeur vide
	 */
	public Compte() {
		super();
		nbComptes++;
	}

	/**
	 * constructeur plein
	 * 
	 * @param id
	 *            int
	 * @param nom
	 *            String
	 * @param solde
	 *            float
	 */
	public Compte(int id, String nom, float solde) {
		super();
		this.id = id;
		this.nom = nom;
		this.solde = solde;
		nbComptes++;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", nom=" + nom + ", solde=" + solde + "]";
	}

	/**
	 * verse de l'argent au compte courant
	 * 
	 * @param montant
	 *            float
	 * @return solde
	 */
	public float verser(float montant) {
		if (montant >= 0) {
			this.setSolde(this.getSolde() + montant);
		}
		return this.getSolde();
	}

	/**
	 * retire de l'argent au compte courant
	 * 
	 * @param montant
	 *            float
	 * @return solde
	 */
	public abstract float retirer(float montant); /*{
		if (montant >= 0) {
			if (this.getSolde() >= montant) {
				this.setSolde(this.getSolde() - montant);
			}
		}
		return this.getSolde();

	}*/

}
