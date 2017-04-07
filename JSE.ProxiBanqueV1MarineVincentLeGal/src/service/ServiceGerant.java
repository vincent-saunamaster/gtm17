package service;

import java.util.Collection;
import java.util.Iterator;

import metier.Adresse;
import metier.Client;
import metier.Conseiller;
import metier.Gerant;
import service.exception.AuditNegatifException;

/**
 *  La Classe ServiceGérant regroupe l'ensemble des opérations effectuable par un gérant
 * @author ME VLG
 *
 */
public class ServiceGerant implements IGerant {

/**
 * Ajout d'un conseiller par un gérant
 */
	@Override
	public void AjouterConseiller(Gerant g, Conseiller co) {
		
		Collection<Conseiller> col = g.getMesConseillers(); // Récupère la liste des conseillers du gérant
		col.add(co); //Ajoute le Conseiller co à la liste col
		g.setMesConseillers(col); // Associe la nouvelle liste des conseillers au gérant
		co.setMonGerant(g); // Associe le nouveau conseiller à son gérant
		
	}

/**
 * Modification d'un conseiller par un gérant
 */
	@Override
	public void ModifierConseiller(Conseiller c, Adresse a, int telephone) {
		
		c.setSonAdresse(a);
		c.setTelephone(telephone);
		
	}

/**
 * Suppression d'un conseiller par un gérant
 */
	@Override
	public void SupprimerConseiller(Conseiller c, Gerant g) {

	
		Collection<Conseiller> col1 = g.getMesConseillers(); //Récupère la liste des conseillers du gérant
		col1.remove(c); //supprimer le conseiller c
		g.setMesConseillers(col1); //Associe la nouvelle liste au gérant
	
		
	}
/**
 * Affichage d'un conseiller par un gérant
 */

	@Override
	public void AfficherConseiller(Conseiller c) {
		System.out.println(c);
	}
/**
 * Audit des comptes d'une agence
 * @throws AuditNegatifException 
 */

	@Override
	public boolean AuditerAgence(Collection<Client> tousLesClientsConseillers) throws AuditNegatifException {
		boolean x=true;
		
		
		
			for(Client c : tousLesClientsConseillers)
				{
				System.out.println(c.getTypeClient());
				System.out.println(c.getMonCompteCourant().getSolde());
				//System.out.println(c.getMonCompteEpargne().getSolde());
				
			if(c.getTypeClient()==1) //Test si client est un particulier
					{
						if(c.getMonCompteCourant().getSolde()!=0) //Vérification si le solde du client est différent de 0
						{
							if(c.getMonCompteCourant().getSolde()<-5000) //Vérification si le solde du compte courant est inférieur à -5000
							{
								x=false;
								throw new AuditNegatifException(x + " : L'Audit du compte est négatif");
							}	
							else
							{
								System.out.println("Audit du Compte Courant Particulier " + c + " a un résultat positif à l'audit.");
							}
						}
						else
						{
							if(c.getMonCompteEpargne().getSolde()!=0)
							{
								if(c.getMonCompteEpargne().getSolde()<-5000)
								{
									x=false;
									throw new AuditNegatifException(x + " : L'Audit du compte est négatif");
								}
								else
								{
									System.out.println("Audit du Compte Epargne Particulier  " + c + " a un résultat positif à l'audit.");
								}
							}
						}
					}
			else
				{
				if(c.getTypeClient()==2) //Test si le client est une entreprise
				{
					if(c.getMonCompteCourant().getSolde()!=0)
					{
						if(c.getMonCompteCourant().getSolde()<-50000)
						{
							x=false;
							throw new AuditNegatifException(x + " : L'Audit du compte est négatif");
						}	
						else
						{
							System.out.println("Audit du Compte Courant Entreprise  " + c + " a un résultat positif à l'audit.");
						}
					}
					
					else
					{
						if(c.getMonCompteEpargne().getSolde()!=0)
						{
							if(c.getMonCompteEpargne().getSolde()<-50000)
							{
								x=false;
								throw new AuditNegatifException(x + " : L'Audit du compte est négatif");
							}
							else
							{
								System.out.println("Audit du Compte Epargne Entreprise " + c + " a un résultat positif à l'audit.");
							}
						}
					}
				}
				}
				}
		
		return x;
		
		}
}

			


	

	
