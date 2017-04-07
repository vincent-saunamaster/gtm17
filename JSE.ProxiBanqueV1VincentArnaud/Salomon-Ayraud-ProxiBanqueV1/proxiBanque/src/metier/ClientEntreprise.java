package metier;

import java.util.Collection;

public class ClientEntreprise extends Client {

	public ClientEntreprise(Collection<Compte> comptes, Patrimoine patrimoine, Collection<Credit> placements,
			Conseiller conseiller) {
		super(comptes, patrimoine, placements, conseiller);
		// TODO Auto-generated constructor stub
	}

	public ClientEntreprise() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ClientEntreprise ";
	}

}
