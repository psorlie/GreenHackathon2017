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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = (String) request.getParameter("login");
		String password = (String) request.getParameter("password");
		String confirmPassword = (String) request.getParameter("confirmPassword");
		HttpSession session = request.getSession();

		RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		ResultSet resultat;

		try {
			resultat = ConnexionBDD.getConnexion().requestFromDataBase("SELECT id FROM Users WHERE login='" + login + "'");
			if (!resultat.next() && password.equals(confirmPassword) && !password.equals("")) {
				ConnexionBDD.getConnexion().insertIntoDataBase(
						"insert into Users(login, password) VALUES('" + login + "','" + password + "')");
				
				session.setAttribute("login", login);
				dispatcher = request.getRequestDispatcher("accueil.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dispatcher.forward(request, response);

	}
}