package metier;

import java.util.ArrayList;
import java.util.Collection;

public class Conseiller {

	private Collection<Client> clients = new ArrayList<Client>();
	private Gerant gerant;

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	public Collection<Client> getClients() {
		return clients;
	}

	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}

	public Conseiller(Collection<Client> clients, Gerant gerant) {
		super();
		this.clients = clients;
		this.gerant = gerant;
	}

	public Conseiller(Collection<Client> clients) {
		super();
		this.clients = clients;
	}

	public Conseiller() {
		super();
	}

	@Override
	public String toString() {
		return "Conseiller [clients=" + clients + "]";
	}

}
