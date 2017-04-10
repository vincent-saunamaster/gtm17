package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoConnection {

	private static final String PILOTE = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bddclients";
	private static final String USER = "root";
	private static final String PWD = "";
	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn == null) {

			try {
				// 1 - charger pilote
				Class.forName(PILOTE);
				// 2 - cr�er connexion
				Connection conn = DriverManager.getConnection(URL, USER, PWD);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return conn;
		} else {
			return conn;
		}
	}

	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}