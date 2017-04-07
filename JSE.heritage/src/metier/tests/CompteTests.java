package metier.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import metier.Compte;

public class CompteTests {

	@Test
	public void testVerser() {
		Compte c = new Compte(1, "testCompte", 10000f);
		float res = c.verser(100f);
		Assert.assertEquals(10100f, res, 0);
	}

	@Test
	public void testVerser2() {
		Compte c = new Compte(1, "testCompte", 10000f);
		float res = c.verser(-12f);
		Assert.assertEquals(10000f, res, 0);
	}

	@Test
	public void testRetirer() {
		Compte c = new Compte(1, "testCompte", 10000f);
		float res = c.retirer(100f);
		Assert.assertEquals(9900f, res, 0);
	}

	@Test
	public void testRetirer2() {
		Compte c = new Compte(1, "testCompte", 10000f);
		float res = c.retirer(-12f);
		Assert.assertEquals(10000f, res, 0);
	}

	@Test
	public void testRetirer3() {
		Compte c = new Compte(1, "testCompte", 10000f);
		float res = c.retirer(10100f);
		Assert.assertEquals(10000f, res, 0);
	}

	@Test
	public void testRetirer4() {
		Compte c = new Compte(1, "testCompte", 10000f);
		float res = c.retirer(10000f);
		Assert.assertEquals(0.0f, res, 0);
	}

	@Before
	public void testBefore() {
		System.out.println("> avant chaque test");
	}

	@After
	public void testAfter() {
		System.out.println("> après chaque test");
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
		System.out.println(">> après chaque suite de test");
		System.out.println("#############################");
	}

}
