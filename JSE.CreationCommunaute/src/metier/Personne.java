package metier;

public class Personne {
	
	private String nom;
	private String prenom;
	private int age;
	
	
	/**
	 * getter nom
	 * @return nom String
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * setter nom
	 * @param nom String
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * getter prenom
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * setter prenom
	 * @param prenom String
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * getter age
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * setter age
	 * @param age int
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * constructeur complet
	 * @param nom String
	 * @param prenom String
	 * @param age int
	 */
	public Personne(String nom, String prenom, int age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	/**
	 * Constructeur vide
	 */
	public Personne() {
		super();
	}
	/**
	 * Constructeur sans age
	 * @param nom String
	 * @param prenom String
	 */
	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	/**
	 * méthode toString standard
	 */
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}
	

	
	
	
}
