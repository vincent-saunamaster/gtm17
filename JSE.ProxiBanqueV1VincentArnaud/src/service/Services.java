package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import metier.Agence;
import metier.Client;
import metier.ClientEntreprise;
import metier.ClientParticulier;
import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import metier.Conseiller;
import metier.Credit;
import metier.NewYork;
import metier.Paris;
import metier.Patrimoine;
import metier.Placement;
import metier.Tokyo;

public class Services implements IConseiller, IGerant {

	public Services() {
		super();
	}

	public String effectuerAudit(Agence agence) {
		String res = "Audit de l'Agence " + agence.getIdAgence();
		Iterator<Conseiller> itCons = agence.getGerant().getConseillers().iterator();
		while (itCons.hasNext()) {
			Iterator<Client> itClient = itCons.next().getClients().iterator();
			while (itClient.hasNext()) {
				Iterator<Compte> itCompte = itClient.next().getComptes().iterator();
				while (itCompte.hasNext()) {
					Compte eval = itCompte.next();
					if (eval.getClient() instanceof ClientParticulier) {
						if (eval.getSolde() < 5000) {
							res += "" + eval.getClient().getConseiller() + eval.getClient() + eval + eval.getSolde();
						}
						if (eval.getClient() instanceof ClientEntreprise) {
							if (eval.getSolde() < 50000) {
								res += "" + eval.getClient().getConseiller() + eval.getClient() + eval
										+ eval.getSolde();
							}

						}
					}
				}
			}
		}
		return res;

	}

	// 1
	/**
	 * Methode de creation d'un Client
	 * 
	 * 
	 * @param comptes
	 *            parametre qui donne la liste de compte du client
	 * @param patrimoine
	 *            parametre qui donne le patrimoine du client
	 * @param credits
	 *            paramettre qui donne les credits du client
	 * @param conseiller
	 *            parametre qui donne le conseiller du client
	 * @param typeClient
	 *            parametre qui premet de choisir le type de client
	 * @return retourne l'Objet Client Creer
	 */
	public Client creerClient(Collection<Compte> comptes, Patrimoine patrimoine, Collection<Credit> credits,
			Conseiller conseiller, int typeClient) {

		// pour choisir type de client

		switch (typeClient) {
		case 1: {
			Client p = new ClientParticulier(comptes, patrimoine, credits, conseiller);
			return p;
		}

		case 2: {
			Client e = new ClientEntreprise(comptes, patrimoine, credits, conseiller);
			return e;
		}

		default:
			return null;
		}

	}

	public void modifierClient(Client clientAModifier) {

	}

	public void supprimerClient(Client clientASupprimer) {

	}

	/**
	 * Methode permettant de crediter un compte
	 * 
	 * @param c
	 *            Compte a crediter
	 * @param montant
	 *            Montant a Crediter sur le compte
	 * @return retourne le compte crédité
	 */
	public Compte crediterCompte(Compte c, double montant) {
		if (montant >= 0) {
			double solde = c.getSolde();
			solde = solde + montant;
			c.setSolde(solde);

		}
		return c;
	}

	/**
	 * Methode permetant de debiter un compte
	 * 
	 * @param c
	 *            Compte a debiter
	 * @param montant
	 *            Montant a debiter
	 * @return retourne le compte
	 */
	public Compte debiterCompte(Compte c, double montant) {

		// si compte Courant (avec decouvert)
		if (c instanceof CompteCourant) {
			double solde = c.getSolde();
			double decouvert = ((CompteCourant) c).getDecouvert();
			if (montant >= 0) {
				if (solde + decouvert >= montant) {
					solde = solde - montant;
					c.setSolde(solde); // debite le comptecourant
				}

			}
			return c;

		}
		// si compte Epargne (Sans decouvert)
		if (c instanceof CompteEpargne) {
			double solde = c.getSolde();
			if (montant >= 0) {
				if (solde >= montant) {
					solde = solde - montant;
					c.setSolde(solde); // debite le compte Epargne
				}

			}
			return c;
		}

		return c;
	}

	/**
	 * Methode qui permet de realiser des virement de compte a compte
	 * 
	 * @param montant
	 *            Montant du virement
	 * @param compteCred
	 *            Compte a crediter
	 * @param comptedeb
	 *            Compte a debiter
	 */
	public void effectuerVirement(double montant, Compte compteCred, Compte comptedeb) {
		double s = comptedeb.getSolde();
		debiterCompte(comptedeb, montant); // debite un compte
		// verification que le debit a eu lieu
		if (s != comptedeb.getSolde()) {
			crediterCompte(compteCred, montant); // credite un compte
		}

	}

	public Credit simuCreditConso(double montant, Client client) {
		return null;
	}

	public Credit simuCreditImmo(double montant, Client client) {
		return null;
	}

	/**
	 * la methode créée un placement et l'ajoute au patrimoine du client
	 * 
	 * @param patrimoine
	 *            parametre qui donne lepatrimoine du client
	 * @param typePlacement
	 *            parametre qui permet de choisir le type de placement
	 * @return retourne le placement crée
	 */
	public Placement creerPlacement(Patrimoine patrimoine, int typePlacement) {

		// calcul de la fortune client
		Collection<Compte> col = patrimoine.getClient().getComptes();
		double fortune = 0;

		Iterator<Compte> it = col.iterator();
		while (it.hasNext())
			fortune = fortune + (it.next().getSolde());
		// condition de fortune pour creer un placement
		if (fortune > 500000) {

			Collection<Placement> pl = new ArrayList<Placement>();
			pl = patrimoine.getPlacements();
			// creer le placement en choisissant la bourse
			switch (typePlacement) {
			case 1: {
				Placement p = new Paris(patrimoine);
				pl.add(p);
				patrimoine.setPlacements(pl);
				return p;
			}

			case 2: {
				Placement p = new Tokyo(patrimoine);
				pl.add(p);
				patrimoine.setPlacements(pl);
				return p;
			}
			case 3: {
				Placement p = new NewYork(patrimoine);
				pl.add(p);
				patrimoine.setPlacements(pl);
				return p;
			}
			default:

				return null;
			}

		} else {

			return null;
		}
	}

	/**
	 * Methode pour supprimer un placement
	 * 
	 * @param placement
	 *            parametre qui donne le placement a supprimmer
	 */
	public void supprimerPlacement(Placement placement) {

		Collection<Placement> col = placement.getPatrimoine().getPlacements();
		Collection<Placement> col2 = new ArrayList<Placement>();
		Iterator<Placement> it = col.iterator();
		while (it.hasNext())
			if (it.next().getIdPlacement() == placement.getIdPlacement()) {
				// ne fais rien quand on arrive sur le placement a supprimer
			} else {
				col2.add(it.next()); // ajoute les placements que l'on ne
										// supprimme pas dans une Collection
			}

		placement.getPatrimoine().setPlacements(col2); // met a jour la
														// Collection

	}

}
