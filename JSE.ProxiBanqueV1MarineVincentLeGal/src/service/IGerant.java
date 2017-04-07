/**
 * 
 */
package service;

import java.util.Collection;

import metier.Adresse;
import metier.Client;
import metier.Conseiller;
import metier.Gerant;
import service.exception.AuditNegatifException;

/**
 * Interface GerantConseiller permettant au Gérant de :Ajouter/Modifier/Supprimer/Afficher un conseiller de son agence
 * @author ME VLG
 *
 */
public interface IGerant {

	public void AjouterConseiller(Gerant g, Conseiller co);
	public void ModifierConseiller(Conseiller c, Adresse a, int telephone);
	public void SupprimerConseiller(Conseiller c, Gerant g);
	public void AfficherConseiller(Conseiller c);
	public boolean AuditerAgence(Collection <Client> tousLesClients) throws AuditNegatifException;
	
}
