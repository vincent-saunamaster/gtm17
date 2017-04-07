package service;

import java.util.Collection;

import metier.Personne;
import metier.Voiture;

public interface Iservice {

	public void ajouterVoiture(Personne p, Voiture v);

	public Collection<Voiture> afficherVoiture(Personne p);

}
