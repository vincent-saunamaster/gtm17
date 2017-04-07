package metier;

import java.util.Collection;

public class ClientParticulier extends Client {

	public ClientParticulier(Collection<Compte> comptes, Patrimoine patrimoine, Collection<Credit> placements,
			Conseiller conseiller) {
		super(comptes, patrimoine, placements, conseiller);
		// TODO Auto-generated constructor stub
	}

	public ClientParticulier() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ClientParticulier ";
	}



}
