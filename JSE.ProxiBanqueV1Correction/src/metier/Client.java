package metier;

import java.util.*;

/**
 * Classe domaine metier Client. Cette classe herite de la classe personne. Le
 * client est caracterise par: un nom, un prenom, des coordonnes, et des
 * informations relative au statu du client.
 * 
 * @author Konrad THOMAS et Vincent PANOUILLERES
 *
 */
public class Client extends Personne {
	
	private String noClient;
	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;
	private Coordonnees coordonnesClient;
	//private boolean estFortune = false;
	private boolean estSociete = false;
	private String nomSociete;
	private List<Placement> listePlacement;
	//TODO ajouter liste carte bancaire
	//TODO ajouter credit


	// Constructeur
	/**
	 * Constructeur de la classe
	 * 
	 * @param nom
	 *            Le Nom du CLoent
	 * @param prenom
	 *            Le prenom du client
	 * @param civilite
	 *            La civilite du client
	 * @param noClient
	 *            L'identifiant associe au client
	 * @param estSociete
	 *            Boleen: true si le client represente une societe false sinon
	 * @param nomSociete
	 *            Nom de societe que le client represente (s'il y en a une)
	 */
	public Client(String nom, String prenom, String civilite, String noClient, boolean estSociete, String nomSociete) {
		super(nom, prenom, civilite);
		this.noClient = noClient;
		this.compteCourant = null;
		this.compteEpargne = null;
		this.listePlacement = new ArrayList<Placement>();
		this.estSociete = estSociete;
		this.nomSociete = nomSociete;
	}
	
	
	/**
	 * @param nom Le nom du client
	 * @param prenom Le prenom du client
	 * @param civilite La civilite du client
	 * @param noClient L'identifiant associe au client
	 */
	public Client(String nom, String prenom, String civilite, String noClient) {
		super(nom, prenom, civilite);
		this.noClient = noClient;
		this.compteCourant = null;
		this.compteEpargne = null;
		this.listePlacement = new ArrayList<Placement>();
	}

	// Getters et Setter
	/**
	 * @return the noClient
	 */
	public String getNoClient() {
		return noClient;
	}

	/**
	 * @param noClient the noClient to set
	 */
	public void setNoClient(String noClient) {
		this.noClient = noClient;
	}
	

	/**
	 * @return the compteCourantClient
	 */
	public CompteCourant getCompteCourantClient() {
		return compteCourant;
	}

	/**
	 * @param compteCourantClient
	 *            the compteCourantClient to set
	 */
	public void setCompteCourantClient(CompteCourant compteCourantClient) {
		this.compteCourant = compteCourantClient;
	}

	/**
	 * @return the compteEpargneClient
	 */
	public CompteEpargne getCompteEpargneClient() {
		return compteEpargne;
	}

	/**
	 * @param compteEpargneClient
	 *            the compteEpargneClient to set
	 */
	public void setCompteEpargneClient(CompteEpargne compteEpargneClient) {
		this.compteEpargne = compteEpargneClient;
	}

	/**
	 * @return the coordonnesClient
	 */
	public Coordonnees getCoordonnesClient() {
		return coordonnesClient;
	}

	/**
	 * @param coordonnesClient
	 *            the coordonnesClient to set
	 */
	public void setCoordonnesClient(Coordonnees coordonnesClient) {
		this.coordonnesClient = coordonnesClient;
	}

	/**
	 * @return the estSociete
	 */
	public boolean estSociete() {
		return estSociete;
	}

	/**
	 * @param estSociete the estSociete to set
	 */
	public void setEstSociete(boolean estSociete) {
		this.estSociete = estSociete;
	}

	/**
	 * @return the nomSociete
	 */
	public String getNomSociete() {
		return nomSociete;
	}

	/**
	 * @param nomSociete the nomSociete to set
	 */
	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}

	/**
	 * @return Si ou ou non le client a plus aue 500.000 Euros dans l'ensemble de ses comptes
	 */
	public boolean estFortune() {
		
		float fortune = 0f;
		
		if (this.compteCourant != null) {
			fortune += this.compteCourant.getSolde();
		}
		if (this.compteEpargne != null) {
			fortune += this.compteEpargne.getSolde();
		}
		
		return (fortune > 500000f);
		//return (this.compteCourant.getSolde() + this.compteEpargne.getSolde() > 500000f);
	}
	
	public List<Placement> getListePlacement() {
		return listePlacement;
	}

	public void setListePlacement(List<Placement> listePlacement) {
		this.listePlacement = listePlacement;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (estSociete) {
			return "Client no. " + noClient + ": " + getCivilite() + " " + getPrenom() + " " + getNom() + "; Société " + nomSociete;
		} else {
			return "Client no. " + noClient + ": " + getCivilite() + " " + getPrenom() + " " + getNom();
		}
	}
	
	
	
	
	
	
	
	
	

}
