package metier;

public class Rectangle extends Forme {

	protected int longueur, largeur;

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public Rectangle() {
		super();
	}

	public Rectangle(int longueur, int largeur) {
		super();
		this.longueur = longueur;
		this.largeur = largeur;
	}

	@Override
	public float perimetre() {
		// TODO Auto-generated method stub
		return 2 * (longueur + largeur);
	}

	@Override
	public float surface() {
		// TODO Auto-generated method stub
		return longueur * largeur;
	}

	@Override
	public String toString() {
		return "Rectangle [longueur=" + longueur + ", largeur=" + largeur + ", toString()=" + super.toString() + "]";
	}

}
