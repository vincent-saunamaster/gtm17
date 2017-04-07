package metier;

import java.util.ArrayList;
import java.util.Collection;

public class Patrimoine {
	private Collection<Placement> placements = new ArrayList<Placement>();
	private Client client;
	
	
	public Patrimoine(Collection<Placement> placements, Client client) {
		super();
		this.placements = placements;
		this.client = client;
	}
	
	public Patrimoine() {
		super();
	}


	public Collection<Placement> getPlacements() {
		return placements;
	}


	public void setPlacements(Collection<Placement> placements) {
		this.placements = placements;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	@Override
	public String toString() {
		return "Patrimoine [placements=" + placements + ", client=" + client + "]";
	}
	
	
	
	
}
