package metier;

public class Ellipse extends Forme {
	protected int grandAxe, petitAxe;

	public int getGrandAxe() {
		return grandAxe;
	}

	public void setGrandAxe(int grandAxe) {
		this.grandAxe = grandAxe;
	}

	public int getPetitAxe() {
		return petitAxe;
	}

	public void setPetitAxe(int petitAxe) {
		this.petitAxe = petitAxe;
	}

	public Ellipse() {
		super();
	}

	public Ellipse(int grandAxe, int petitAxe) {
		super();
		this.grandAxe = grandAxe;
		this.petitAxe = petitAxe;
	}

	@Override
	public float perimetre() {
		// TODO Auto-generated method stub
		float res = 0;
		float pcarre = petitAxe * petitAxe;
		float gcarre = grandAxe * grandAxe;
		float sinus, cosinus;

		for (int i = 0; i < 1000; i++) {
			sinus = (float) Math.sin(i * Math.PI / 2000);
			cosinus = (float) Math.cos(i * Math.PI / 2000);
			res += Math.sqrt(pcarre * sinus * sinus * gcarre * cosinus * cosinus);

		}
		res *= 4 * Math.PI / 2000;
		return res;
	}

	@Override
	public float surface() {
		// TODO Auto-generated method stub
		return (float) Math.PI * petitAxe * grandAxe;
	}

	@Override
	public String toString() {
		return "Ellipse [grandAxe=" + grandAxe + ", petitAxe=" + petitAxe + ", toString()=" + super.toString() + "]";
	}

}
