/**
 * 
 */
package metier;

/**
 * Métier Compte.
 * Classe mère de CompteCourant et CompteEpargne
 * Compte est identifié par un numéro, un solde, une date d'ouverture.
 * Compte est associé à un client et à une carte Visa 
 * @author ME VLG
 *
 */
public class Compte  {

	private int numCompte;
	private double solde;
	private String dateOuverture;
	
	private Client clientCompte;
	
	private CarteVisa maCarteVisa;
	int typeCompte;//taux =3 soit decouvert=1000
	
	
	
	
	public int getTypeCompte() {
		return typeCompte;
	}


	
	public void setTypeCompte(int typeCompte) {
		this.typeCompte = typeCompte;
	}


	public CarteVisa getMaCarteVisa() {
		return maCarteVisa;
	}

	
	public void setMaCarteVisa(CarteVisa maCarteVisa) {
		this.maCarteVisa = maCarteVisa;
	}
	
	
	public Client getClientCompte() {
		return clientCompte;
	}
	
	public void setClientCompte(Client clientCompte) {
		this.clientCompte = clientCompte;
	}
	
	public int getNumCompte() {
		return numCompte;
	}
	
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	
	public double getSolde() {
		return solde;
	}
	
	public void setSolde(double d) {
		this.solde = d;
	}
	
	public String getDateOuverture() {
		return dateOuverture;
	}
	
	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}


	
	
	
	/**
	 * COnstructeur de Compte avec 3 arguments
	 * @param numCompte Correspond au numéro d'identification du compte
	 * @param solde Correspond au solde du compte
	 * @param dateOuverture Correspond à la date d'ouverture du compte
	 */
	public Compte(int numCompte, double solde, String dateOuverture) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
	}

	/**
	 * COnstructeur de Compte avec 3 arguments
	 * @param numCompte Correspond au numéro d'identification du compte
	 * @param solde Correspond au solde du compte
	 *@param dateOuverture Correspond à la date d'ouverture du compte
	 *@param typeCompte Correspond au type de compte (courant1, epargne2)

	 */
	public Compte(int numCompte, double solde, String dateOuverture, int typeCompte) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.typeCompte = typeCompte;
	}

	/**
	 * Constructeur de Compte sans argument
	 */
	public Compte() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Compte [numCompte=" + numCompte + ", solde=" + solde + ", dateOuverture=" + dateOuverture + "]";
	}
	
	
}
