package service;

import java.util.Collection;

import metier.Client;
import metier.Compte;
import metier.Conseiller;
import metier.Credit;
import metier.Patrimoine;
import metier.Placement;

public interface IConseiller {
	
	public Client creerClient(Collection<Compte> comptes, Patrimoine patrimoine, Collection<Credit> credits,
			Conseiller conseiller, int typeClient);
	public void modifierClient(Client clientAModifier);
	public void supprimerClient(Client clientASupprimer);
	public void effectuerVirement(double montant, Compte compteCred, Compte comptedeb);
	public Credit simuCreditConso(double montant, Client client);
	public Credit simuCreditImmo(double montant, Client client);
	public Placement creerPlacement(Patrimoine patrimoine, int typePlacement);
	public void supprimerPlacement(Placement placement);
	
	
}
