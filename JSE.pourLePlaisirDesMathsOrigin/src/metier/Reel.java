package metier;

public class Reel {
	private double reel;

	public double getReel() {
		return reel;
	}

	public void setReel(double reel) {
		this.reel = reel;
	}

	public Reel(double reel) {
		super();
		this.reel = reel;
	}

	@Override
	public String toString() {
		return "Reel [reel=" + reel + "]";
	}

}
