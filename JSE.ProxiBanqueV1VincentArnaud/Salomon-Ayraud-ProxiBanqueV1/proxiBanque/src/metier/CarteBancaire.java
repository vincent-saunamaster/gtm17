package metier;




public abstract class CarteBancaire  {
	
	private Compte compte;

	public CarteBancaire(Compte compte) {
		super();
		this.compte = compte;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "CarteBancaire [compte=" + compte + "]";
	}
	
	

	
}
