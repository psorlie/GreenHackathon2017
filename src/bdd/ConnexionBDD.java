
package bdd;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionBDD {

	private static ConnexionBDD conn;
	private Connection connection;

	private ConnexionBDD() {
		this.connection = this.ouvrir();
	}

	public static ConnexionBDD getConnexion() {
		if (conn == null) {
			conn = new ConnexionBDD();
		}
		return conn;
	}

	/**
	 * Ouverture de la connexion Ã  la base de donnÃ©es
	 * 
	 * @return Connection connexion Ã  la base de donnÃ©es
	 */
	private Connection ouvrir() {
		Connection connection = null;
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

			connection = DriverManager.getConnection(
					"jdbc:mysql://" + address + "/" + database + "?user=" + user + "&password=" + password);

			// conn = DriverManager.getConnection(URL, user, password);

		} catch (SQLException | IOException | ClassNotFoundException e) {
		}

		return connection;
	}

	public ResultSet requestFromDataBase(String sqlQuery) throws SQLException {
		Statement stmt = this.connection.createStatement();
		// stmt = conn.createStatement();
		ResultSet rset = null;
		if (stmt.execute(sqlQuery)) {
			rset = stmt.getResultSet();
		}
		return rset;
	}

	public void insertIntoDataBase(String insert) throws SQLException {
		this.connection.createStatement().execute(insert);
	}

	public void closeRequestToDataBase() throws SQLException {

		if (this.connection != null) {
			this.connection.close();
			this.connection = null;
		}
	}

}
