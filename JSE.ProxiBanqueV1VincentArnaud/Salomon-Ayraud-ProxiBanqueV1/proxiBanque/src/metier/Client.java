package metier;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Client extends Personne {
	private Collection<Compte> comptes = new ArrayList<Compte>();
	private Patrimoine patrimoine;
	private Collection<Credit> credits = new ArrayList<Credit>();
	private Conseiller conseiller;

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	public Patrimoine getPatrimoine() {
		return patrimoine;
	}

	public void setPatrimoine(Patrimoine patrimoine) {
		this.patrimoine = patrimoine;
	}

	public Collection<Credit> getcredits() {
		return credits;
	}

	public void setcredits(Collection<Credit> credits) {
		this.credits = credits;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public Client(Collection<Compte> comptes, Patrimoine patrimoine, Collection<Credit> credits,
			Conseiller conseiller) {
		super();
		this.comptes = comptes;
		this.patrimoine = patrimoine;
		this.credits = credits;
		this.conseiller = conseiller;
	}

	public Client() {
		super();
	}

	@Override
	public String toString() {
		return "Client [comptes=" + comptes + ", patrimoine=" + patrimoine + ", credits=" + credits + ", conseiller=" + conseiller + "]";
	}

}
