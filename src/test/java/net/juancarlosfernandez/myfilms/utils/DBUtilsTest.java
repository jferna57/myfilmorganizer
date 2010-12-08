package net.juancarlosfernandez.myfilms.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DBUtilsTest {

	private final String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private final String DB_URL = "jdbc:derby:./target/DerbyDB/samplePelisDB;create=true";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createConnection() {

		try {

			Connection conn = DBUtils.getConnection(DB_DRIVER, DB_URL);

			Statement st = conn.createStatement();

			st.execute("CREATE TABLE USERS ( "
					+ "FIRST_NAME VARCHAR(30) NOT NULL,"
					+ "LAST_NAME VARCHAR(30) NOT NULL,"
					+ "EMP_NO INTEGER NOT NULL CONSTRAINT EMP_NO_PK PRIMARY KEY)");

			st.execute("DROP TABLE USERS");

			conn.close();

			assertTrue(true);

		} catch (SQLException e) {
			assertFalse(e.getMessage(), false);
		}
	}
}
