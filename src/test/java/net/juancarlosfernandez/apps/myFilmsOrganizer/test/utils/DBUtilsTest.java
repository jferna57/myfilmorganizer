package net.juancarlosfernandez.apps.myFilmsOrganizer.test.utils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


import java.sql.SQLException;

import net.juancarlosfernandez.apps.myFilmsOrganizer.service.DBUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DBUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void createConnection(){
		
		try {
			DBUtils.createConnection();
			assertTrue(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			assertFalse(e.getMessage(),false);
		}
		
	}
}
