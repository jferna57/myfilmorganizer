package net.juancarlosfernandez.myfilms.test.utils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import net.juancarlosfernandez.myfilms.utils.DBUtils;

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
				
			Connection conn = DBUtils.getConnection();
			
			Statement st = conn.createStatement();

			st.execute("CREATE TABLE USERS ( "
							+ "FIRST_NAME VARCHAR(30) NOT NULL,"
							+ "LAST_NAME VARCHAR(30) NOT NULL,"
							+ "EMP_NO INTEGER NOT NULL CONSTRAINT EMP_NO_PK PRIMARY KEY)");

			st.execute("DROP TABLE USERS");
			
			conn.close();
			
			assertTrue(true);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			assertFalse(e.getMessage(),false);
		}
		
	}
}
