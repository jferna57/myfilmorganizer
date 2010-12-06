package net.juancarlosfernandez.apps.myFilmsOrganizer.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

	public static void createConnection() throws SQLException {
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		String dbName = "./src/main/resources/DerbyDB/pelisDB";
		String connectionURL = "jdbc:derby:" + dbName + ";create=true";
		Connection conn = null;

		try {
			Class.forName(driver);
		} catch (java.lang.ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(connectionURL);

			Statement st = conn.createStatement();

			st.execute("CREATE TABLE USERS ( "
					+ "FIRST_NAME VARCHAR(30) NOT NULL,"
					+ "LAST_NAME VARCHAR(30) NOT NULL,"
					+ "EMP_NO INTEGER NOT NULL CONSTRAINT EMP_NO_PK PRIMARY KEY)");

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
}
