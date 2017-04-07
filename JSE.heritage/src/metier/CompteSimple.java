package metier;

public class CompteSimple extends Compte {
	private float decouvert;

	/**
	 * définit le rérentiel compte simple
	 * 
	 * @param decouvert
	 */
	public CompteSimple(float decouvert) {
		super();
		this.decouvert = decouvert;
	}

	public CompteSimple(int id, String nom, float solde, float decouvert) {
		super(id, nom, solde);
		this.decouvert = decouvert;
	}

	@Override
	public String toString() {
		return "CompteSimple " + super.toString() + " [decouvert=" + decouvert + "]";
	}

	public float getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(float decouvert) {
		this.decouvert = decouvert;
	}

	@Override
	public float retirer(float montant) {
		// TODO Auto-generated method stub
		if (montant >= 0) {
			if ((this.getSolde() + this.getDecouvert()) >= montant) {
				this.setSolde(this.getSolde() - montant);
			}
		}
		return this.getSolde();
	}

}
