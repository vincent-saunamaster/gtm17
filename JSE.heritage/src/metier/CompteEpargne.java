package metier;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * d�finit le r�rentiel compte epargne
 * 
 * @author Stagiaire
 *
 */
public class CompteEpargne extends Compte {
	private float taux;

	public CompteEpargne(float taux) {
		super();
		this.taux = taux;
	}

	public CompteEpargne(int id, String nom, float solde, float taux) {
		super(id, nom, solde);
		this.taux = taux;
	}

	@Override
	public String toString() {
		return "CompteEpargne " + super.toString() + " [taux=" + taux + "]";
	}

	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}

	/**
	 * calcule les int�r�ts
	 * 
	 * @return
	 */
	public float calculInteret() {
		return this.getSolde() * this.getTaux();
	}

	@Before
	public void testBefore() {
		System.out.println("> avant chaque test");
	}

	@After
	public void testAfter() {
		System.out.println("> apr�s chaque test");
	}

	@BeforeClass
	public static void testBeforeClass() {
		System.out.println("#############################");
		System.out.println(">> avant chaque suite de test");
		System.out.println("#############################");
	}

	@AfterClass
	public static void testAfterClass() {
		System.out.println("#############################");
		System.out.println(">> apr�s chaque suite de test");
		System.out.println("#############################");
	}

}
