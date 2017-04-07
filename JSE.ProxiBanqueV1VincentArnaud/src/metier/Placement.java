package metier;

import java.util.Collection;

public abstract class Placement {

	private Patrimoine patrimoine;
	private  int idPlacement;

	public Placement(Patrimoine patrimoine) {
		super();
		this.patrimoine = patrimoine;
		Collection<Placement> col = patrimoine.getPlacements();
		idPlacement=col.size()+1;
	
	}
	
	public Placement() {
		super();
		Collection<Placement> col = patrimoine.getPlacements();
		idPlacement=col.size()+1;
		
	}

		
	public int getIdPlacement() {
		return idPlacement;
	}

	

	public Patrimoine getPatrimoine() {
		return patrimoine;
	}

	public void setPatrimoine(Patrimoine patrimoine) {
		this.patrimoine = patrimoine;
	}

	@Override
	public String toString() {
		return "Placement [patrimoine=" + patrimoine + ", idPlacement=" + idPlacement + "]";
	}

	
	
	
}
