package metier;

public class Client {
	private int id;
	private String nom;
	private String prenom;
	private String couleurYeux;
	private int Age;

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		this.Age = age;
	}

	public String getCouleurYeux() {
		return couleurYeux;
	}

	public void setCouleurYeux(String couleurYeux) {
		this.couleurYeux = couleurYeux;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Client() {
		super();
	}

	public Client(String nom, String prenom, String couleurYeux, int age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.couleurYeux = couleurYeux;
		this.Age = age;
	}

	public Client(int id, String nom, String prenom, String couleurYeux, int age) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.couleurYeux = couleurYeux;
		this.Age = age;
	}

}
