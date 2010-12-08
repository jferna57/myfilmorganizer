package net.juancarlosfernandez.myfilms;

import junit.framework.Test;
import junit.framework.TestSuite;
import net.juancarlosfernandez.myfilms.services.impl.FileServiceTest;
import net.juancarlosfernandez.myfilms.services.impl.FilmServiceTest;
import net.juancarlosfernandez.myfilms.utils.DBUtilsTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { FileServiceTest.class, FilmServiceTest.class, DBUtilsTest.class })

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		// $JUnit-BEGIN$

		// $JUnit-END$
		return suite;
	}

}
