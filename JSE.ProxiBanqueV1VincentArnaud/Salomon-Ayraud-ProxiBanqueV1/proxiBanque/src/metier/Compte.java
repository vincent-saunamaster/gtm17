package metier;

public abstract class Compte {

	private int numeroCompte;
	private double solde;
	private long dateOuverture;
	private Client client;
	private CarteBancaire carteBancaire;

	public int getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public long getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(long dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public CarteBancaire getCarteBancaire() {
		return carteBancaire;
	}

	public void setCarteBancaire(CarteBancaire carteBancaire) {
		this.carteBancaire = carteBancaire;
	}

	public Compte(int numeroCompte, double solde, long dateOuverture, Client client, CarteBancaire carteBancaire) {
		super();
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.client = client;
		this.carteBancaire = carteBancaire;
	}

	public Compte() {
		super();
	}

	@Override
	public String toString() {
		return "Compte [numeroCompte=" + numeroCompte + ", solde=" + solde + ", dateOuverture=" + dateOuverture
				+ ", client=" + client + ", carteBancaire=" + carteBancaire + "]";
	}

}
