package metier.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import metier.CompteSimple;

public class CompteSimpleTests {

	@Test
	public void testRetirer() {
		CompteSimple c = new CompteSimple(1, "testCompteSimple", 10000f, 1000f);
		float res = c.retirer(100f);
		Assert.assertEquals(9900f, res, 0);
	}

	@Test
	public void testRetirer2() {
		CompteSimple c = new CompteSimple(1, "testCompteSimple", 10000f, 1000f);
		float res = c.retirer(-12f);
		Assert.assertEquals(10000f, res, 0);
	}

	@Test
	public void testRetirer3() {
		CompteSimple c = new CompteSimple(1, "testCompteSimple", 10000f, 1000f);
		float res = c.retirer(10100f);
		Assert.assertEquals(-100f, res, 0);
	}

	@Test
	public void testRetirer4() {
		CompteSimple c = new CompteSimple(1, "testCompteSimple", -100f, 1000f);
		float res = c.retirer(900f);
		Assert.assertEquals(-1000f, res, 0);
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
