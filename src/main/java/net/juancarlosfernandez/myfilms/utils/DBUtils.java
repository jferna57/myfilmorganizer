package net.juancarlosfernandez.myfilms.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	public static final String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String DB_URL= "jdbc:derby:./target/DerbyDB/pelisDB;create=true";
	
	public static Connection getConnection(String driver, String url) throws SQLException {
		Connection conn = null;

		try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			
		} catch (java.lang.ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}

		
		return conn;
	}
}
