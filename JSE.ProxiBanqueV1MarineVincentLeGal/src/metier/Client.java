/**
 * 
 */
package metier;

/**
 * M�tier Client
 * Client de la banque. Est associ� � un conseill�, un compte courant et un compte �pargne
 * Est li� � Personne (id, nom, prenom et � une adresse)
 * @author ME VLG
 *
 */
public class Client extends Personne {

	
	
	private Conseiller monConseillerClient;
	private Compte monCompteEpargne;
	private Compte monCompteCourant;
	private int typeClient; //1 si client Particulier et 2 si client Entreprise


	/**
	 * @return the typeClient
	 */
	public int getTypeClient() {
		return typeClient;
	}


	/**
	 * @param typeClient the typeClient to set
	 */
	public void setTypeClient(int typeClient) {
		this.typeClient = typeClient;
	}


	public Client(int typeClient) {
		super();
		this.typeClient = typeClient;
	}

	
	public Conseiller getMonConseillerClient() {
		return monConseillerClient;
	}

	public void setMonConseillerClient(Conseiller monConseillerClient) {
		this.monConseillerClient = monConseillerClient;
	}

	public Compte getMonCompteEpargne() {
		return monCompteEpargne;
	}

	
	public void setMonCompteEpargne(Compte monCompteEpargne) {
		this.monCompteEpargne = monCompteEpargne;
	}

	
	public Compte getMonCompteCourant() {
		return monCompteCourant;
	}

	
	public void setMonCompteCourant(Compte monCompteCourant) {
		this.monCompteCourant = monCompteCourant;
	}

	

	/**
	 * Constructeur de Client sans argument
	 */
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructeur de Client auquel est associ� � la classe Personne et son adresse
	 * @param nom 	Correspond au nom du client
	 * @param prenom 	Correspond au prenom du client
	 * @param telephone Correspond au t�l�phone de la client
	 * @param id	Correspond au num�ro d'identification du client
	 * @param sonAdresse Correspond � l'adresse du client
	 */
	public Client(String nom, String prenom, int telephone, int id, Adresse sonAdresse) {
		super(nom, prenom, telephone, id, sonAdresse);
		// TODO Auto-generated constructor stub
	}
	
	

	public Client(String nom, String prenom, int telephone, int id, Adresse sonAdresse, int typeClient) {
		super(nom, prenom, telephone, id, sonAdresse);
		this.typeClient = typeClient;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [getId()=" + getId() + ", getSonAdresse()=" + getSonAdresse() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getTelephone()=" + getTelephone() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	

	



	

	


	
	
	
}
