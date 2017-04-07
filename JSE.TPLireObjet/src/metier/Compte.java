package metier;

import java.io.Serializable;

/**
 * Cette classe sert à définir un objet compte bancaire
 * 
 * @author Stagiaire
 * @version 0
 *
 */
public class Compte implements Serializable {
	/**
	 * Attribut du numéro d'identification du compte
	 */
	protected int idCompte;
	/**
	 * Attribut du nom du compte
	 */
	protected String nomCompte;
	/**
	 * Attribut du solde du compte
	 */
	protected long solde;

	/**
	 * getter du numéro d'identification du compte
	 * 
	 * @return le numéro d'identification du compte
	 */
	public int getIdCompte() {
		return idCompte;
	}

	/**
	 * setter du numéro d'identification du compte
	 * 
	 * @param idCompte
	 *            int
	 */
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	/**
	 * getter du nom du compte
	 * 
	 * @return nom du compte
	 */
	public String getNomCompte() {
		return nomCompte;
	}

	/**
	 * setter du nom du compte
	 * 
	 * @param nomCompte
	 *            String
	 */
	public void setNomCompte(String nomCompte) {
		this.nomCompte = nomCompte;
	}

	/**
	 * getter du solde du compte
	 * 
	 * @return solde du compte
	 */
	public long getSolde() {
		return solde;
	}

	/**
	 * setter du solde du compte
	 * 
	 * @param solde
	 *            long
	 */
	public void setSolde(long solde) {
		this.solde = solde;
	}

	/**
	 * Constructeur de l'objet compte avec aucun Attribut défini
	 */
	public Compte() {
		super();
	}

	/**
	 * Constructeur de l'objet compte avec tout ses Attributs définis
	 * 
	 * @param idCompte
	 *            int
	 * @param nomCompte
	 *            String
	 * @param solde
	 *            long
	 */
	public Compte(int idCompte, String nomCompte, long solde) {
		super();
		this.idCompte = idCompte;
		this.nomCompte = nomCompte;
		this.solde = solde;
	}

	/**
	 * méthode retournant un affichage de l'objet Compte
	 * 
	 * @return affichage de l'objet Compte
	 */
	@Override
	public String toString() {
		return "Compte [idCompte=" + idCompte + ", nomCompte=" + nomCompte + ", solde=" + solde + "]";
	}

}
