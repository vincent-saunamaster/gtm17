package service;

import metier.Compte;

/**
 * Classe regroupant les services de compte
 * 
 * @author Stagiaire
 *
 */
public class CompteService {

	/**
	 * ajoute la somme "plus" au solde "c"
	 * 
	 * @param c
	 *            long
	 * @param plus
	 *            long
	 * @return solde long
	 */
	public long ajouter(Compte c, long plus) {
		if (plus >= 0) {
			c.setSolde(c.getSolde() + plus);
		}
		return c.getSolde();
	}

	/**
	 * retire la somme "moins" au solde "c"
	 * 
	 * @param c
	 *            long
	 * @param moins
	 *            long
	 * @return solde long
	 */
	public long retirer(Compte c, long moins) {
		if (moins >= 0) {
			if (c.getSolde() >= moins) {
				c.setSolde(c.getSolde() - moins);
			}
		}
		return c.getSolde();
	}

	/**
	 * retourne le solde
	 * 
	 * @param c
	 *            objet Compte
	 * @return solde de l'objet en paramètre
	 */
	public long soldeCompte(Compte c) {
		return c.getSolde();
	}
}
