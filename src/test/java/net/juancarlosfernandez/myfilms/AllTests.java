package net.juancarlosfernandez.myfilms;

import net.juancarlosfernandez.myfilms.services.impl.FileServiceTest;
import net.juancarlosfernandez.myfilms.services.impl.FilmServiceTest;
import net.juancarlosfernandez.myfilms.utils.DBUtilsTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { DBUtilsTest.class, FileServiceTest.class, FilmServiceTest.class })

public class AllTests {
		
	
}
