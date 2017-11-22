package greenHackaton2017.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String login = (String) request.getAttribute("login");
		String password = (String) request.getAttribute("password");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			/* Gérer les éventuelles erreurs ici. */
			System.out.println(e.toString());
		}

		String url = "jdbc:mysql://localhost:3306/criticalpfe";
		String utilisateur = "Critical";
		String motDePasse = "Lco950921";

		Connection connexion = null;
		RequestDispatcher dispatcher;

		try {
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
			Statement statement = connexion.createStatement();

			HttpSession session = request.getSession();

			ResultSet resultat = statement.executeQuery("SELECT password, id FROM Users WHERE login='" + login + "'");

			if (resultat.getString("password") == password) {
				int id = resultat.getInt("id");
				session.setAttribute("id", id);
				dispatcher = request.getRequestDispatcher("accueil.jsp");
			} else {
				dispatcher = request.getRequestDispatcher("login.jsp");
			}

			dispatcher.forward(request, response);

		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			if (connexion != null)
				try {
					connexion.close();
				} catch (SQLException ignore) {
					//TODO
				}
		}
	}
}
