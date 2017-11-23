package greenHackaton2017.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdd.ConnexionBDD;

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
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher;
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String login = (String) request.getAttribute("login");
		String password = (String) request.getAttribute("password");

		ResultSet resultat;
		try {
			resultat = ConnexionBDD.getConnexion().requestFromDataBase("SELECT password, id FROM Users WHERE login='" + login + "'");

			if (resultat.getString("password").equals(password)) {
				int id = resultat.getInt("id");
				session.setAttribute("id", id);
				dispatcher = request.getRequestDispatcher("accueil.jsp");
			} else {
				dispatcher = request.getRequestDispatcher("login.jsp");
			}

			dispatcher.forward(request, response);
		} catch (SQLException e) {
		}

	}
}
