package metier;

public class Carre extends Forme {

	protected Float largeur;

	public Float getLargeur() {
		return largeur;
	}

	public void setLargeur(Float largeur) {
		this.largeur = largeur;
	}

	public Carre() {
		super();
	}

	public Carre(Float largeur) {
		super();
		this.largeur = largeur;
	}

	@Override
	public float perimetre() {
		// TODO Auto-generated method stub
		return 4 * this.largeur;
	}

	@Override
	public float surface() {
		// TODO Auto-generated method stub
		return this.largeur * this.largeur;
	}

	@Override
	public String toString() {
		return "Carre [largeur=" + largeur + ", toString()=" + super.toString() + "]";
	}

}
