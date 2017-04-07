package metier;

/**
 * définit le rérentiel compte epargne
 * 
 * @author Stagiaire
 *
 */
public class CompteEpargne extends Compte {
	private float taux;

	public CompteEpargne(float taux) {
		super();
		this.taux = taux;
	}

	public CompteEpargne(int id, String nom, float solde, float taux) {
		super(id, nom, solde);
		this.taux = taux;
	}

	@Override
	public String toString() {
		return "CompteEpargne " + super.toString() + " [taux=" + taux + "]";
	}

	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}

	/**
	 * calcule les intérêts
	 * 
	 * @return
	 */
	public float calculInteret() {
		return this.getSolde() * this.getTaux();
	}

	@Override
	public float retirer(float montant) {
		// TODO Auto-generated method stub
		if (montant >= 0) {
			if (this.getSolde() >= montant) {
				this.setSolde(this.getSolde() - montant);
			}
		}
		return this.getSolde();
	}

}
