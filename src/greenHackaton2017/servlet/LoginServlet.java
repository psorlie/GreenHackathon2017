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
import greenHackaton2017.java.model.User;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String login = (String) request.getParameter("login");
		String password = (String) request.getParameter("password");

		ResultSet resultat;
		try {
			resultat = ConnexionBDD.getConnexion().requestFromDataBase("SELECT password FROM Users WHERE login='" + login + "'");

			if (resultat.next() && resultat.getString(1).equals(password)) {
				session.setAttribute("login", login);
				dispatcher = request.getRequestDispatcher("accueil.jsp");
			}

			dispatcher.forward(request, response);
		} catch (SQLException e) {
			System.out.println("erf");
		}

		dispatcher.forward(request, response);

	}
}
