package metier;

/**
 * défiinit le reférentiel compte payant
 * 
 * @author Stagiaire
 *
 */
public class ComptePayant extends Compte {
	private float pourcentage;

	public float getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage(float pourcentage) {
		this.pourcentage = pourcentage;
	}

	public ComptePayant(float pourcentage) {
		super();
		this.pourcentage = pourcentage;
	}

	public ComptePayant(int id, String nom, float solde, float pourcentage) {
		super(id, nom, solde);
		this.pourcentage = pourcentage;
	}

	@Override
	public String toString() {
		return "ComptePayant " + super.toString() + " [pourcentage=" + pourcentage + "]";
	}

	@Override
	public float verser(float montant) {
		super.verser(montant - (montant * this.getPourcentage()));
		return this.getSolde();
	}

	@Override
	public float retirer(float montant) {
		if (montant >= 0) {
			if (this.getSolde() >= (montant + (montant * this.getPourcentage()))) {
				this.setSolde(this.getSolde() - (montant + (montant * this.getPourcentage())));
			}
		}
		return this.getSolde();
	}

}
