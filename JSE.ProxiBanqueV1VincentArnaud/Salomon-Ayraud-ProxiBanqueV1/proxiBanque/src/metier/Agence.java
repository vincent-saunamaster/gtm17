package metier;

public class Agence {

	private String idAgence;
	private long dateCreation;
	private Gerant gerant;
	
	

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	public Agence(String idAgence, long dateCreation, Gerant gerant) {
		super();
		this.idAgence = idAgence;
		this.dateCreation = dateCreation;
		this.gerant = gerant;
	}

	public Agence(String idAgence, long dateCreation) {
		super();
		this.idAgence = idAgence;
		this.dateCreation = dateCreation;
	}
	public Agence() {
		super();
	}

	public Gerant getGerant() {
		return gerant;
	}

	public String getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(String idAgence) {
		this.idAgence = idAgence;
	}

	public long getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(long dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Agence [idAgence=" + idAgence + ", dateCreation=" + dateCreation + ", gerant=" + gerant + "]";
	}

}
