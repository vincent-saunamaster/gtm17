package service;

import metier.Personne;
/**
 * Classe effectuant les services d'une personne
 * @author Stagiaire
 *
 */
public class PersonneService {

	/**
	 * Personne marche
	 * @param p objet Personne
	 * @return p + " marche"
	 */
	public String marcher(Personne p){
		return p + " marche";
	}
	/**
	 * Personne s'arrête
	 * @param p objet Personne
	 */
	public void arreter(Personne p){
		System.out.println(p + " s'arrête");
	}
	
}
