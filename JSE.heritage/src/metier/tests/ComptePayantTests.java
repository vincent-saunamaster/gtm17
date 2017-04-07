package metier.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import metier.ComptePayant;

public class ComptePayantTests {

	@Test
	public void testVerser() {
		ComptePayant c = new ComptePayant(1, "testComptePayant", 10000f, 0.1f);
		float res = c.verser(100f);
		Assert.assertEquals(10090f, res, 0);
	}

	@Test
	public void testVerser2() {
		ComptePayant c = new ComptePayant(1, "testComptePayant", 10000f, 0.1f);
		float res = c.verser(-12f);
		Assert.assertEquals(10000f, res, 0);
	}

	@Test
	public void testRetirer() {
		ComptePayant c = new ComptePayant(1, "testComptePayant", 10000f, 0.1f);
		float res = c.retirer(100f);
		Assert.assertEquals(9890f, res, 0);
	}

	@Test
	public void testRetirer2() {
		ComptePayant c = new ComptePayant(1, "testComptePayant", 10000f, 0.1f);
		float res = c.retirer(-12f);
		Assert.assertEquals(10000f, res, 0);
	}

	@Test
	public void testRetirer3() {
		ComptePayant c = new ComptePayant(1, "testComptePayant", 10000f, 0.1f);
		float res = c.retirer(9999f);
		Assert.assertEquals(10000f, res, 0);
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
