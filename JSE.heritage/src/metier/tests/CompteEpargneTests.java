package metier.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import metier.CompteEpargne;

public class CompteEpargneTests {

	@Test
	public void testCalculInteret() {
		CompteEpargne c = new CompteEpargne(1, "testCompte", 10000f, 0.1f);
		float res = c.calculInteret();
		Assert.assertEquals(1000f, res, 0);
	}

	@Test
	public void testCalculInteret2() {
		CompteEpargne c = new CompteEpargne(1, "testCompte", 0f, 0.1f);
		float res = c.calculInteret();
		Assert.assertEquals(0f, res, 0);
	}

	@Test
	public void testCalculInteret3() {
		CompteEpargne c = new CompteEpargne(1, "testCompte", 10000f, 0.0f);
		float res = c.calculInteret();
		Assert.assertEquals(0f, res, 0);
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
