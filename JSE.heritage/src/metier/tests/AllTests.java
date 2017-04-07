package metier.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CompteEpargneTests.class, ComptePayantTests.class, CompteSimpleTests.class, CompteTests.class })
public class AllTests {

}
