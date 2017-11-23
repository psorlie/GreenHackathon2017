
package bdd;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionBDD {

	private static Connection conn;

	private ConnexionBDD() {
	}

	public static Connection getConnection() {
		if (conn == null) {
			conn = ConnexionBDD.ouvrir();
			System.out.println("coucou");
		}
		return conn;
	}

	/**
	 * Ouverture de la connexion Ã  la base de donnÃ©es
	 * 
	 * @return Connection connexion Ã  la base de donnÃ©es
	 */
	private static Connection ouvrir() {
		Connection conn = null;
		try {
			// TODO remettre cette version simplifier pour la BDD
			// String address = "localhost";
			// String database = "dentist";
			// String user = "userDentist";
			// String password = "networkDentist";

			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("properties");
			java.util.Properties properties = new java.util.Properties();

			properties.load(is);

			String address = properties.getProperty("host_bdd");
			String database = properties.getProperty("database");
			String user = properties.getProperty("user");
			String password = properties.getProperty("pass");

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection("jdbc:mysql://" + address + "/" + database + "?user=" + user + "&password="
							+ password + "&useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=false");

			// conn = DriverManager.getConnection(URL, user, password);

		} catch (SQLException|ClassNotFoundException|IOException e) {
		}

		return conn;
	}

	public static ResultSet requestFromDataBase(String sqlQuery) throws SQLException {
		Statement stmt;
		ResultSet rset = null;
		ConnexionBDD.getConnection();
		stmt = conn.createStatement();
		if (stmt.execute(sqlQuery)) {
			rset = stmt.getResultSet();
		}
		return rset;
	}

	public static void insertIntoDataBase(String insert) throws SQLException {
		ConnexionBDD.getConnection();
		conn.createStatement().execute(insert);
	}

	public static void closeRequestToDataBase() throws SQLException {

		if (conn != null) {
			conn.close();
			conn = null;
		}
	}

}
