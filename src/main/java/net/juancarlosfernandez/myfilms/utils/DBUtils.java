package net.juancarlosfernandez.myfilms.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	private static final String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String DB_NAME= "./src/main/resources/DerbyDB/pelisDB";
	private static final String DB_URL = "jdbc:derby:" + DB_NAME + ";create=true";
	
	public static Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_URL);
			
		} catch (java.lang.ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}

		
		return conn;
	}
}
