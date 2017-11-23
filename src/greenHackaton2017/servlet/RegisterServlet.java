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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = (String) request.getAttribute("login");
		String password = (String) request.getAttribute("password");
		String confirmPassword = (String) request.getAttribute("confirmPassword");
		HttpSession session = request.getSession();

		RequestDispatcher dispatcher = null;
		ResultSet resultat;

		try {
			resultat = ConnexionBDD.requestFromDataBase("SELECT COUNT(id) FROM Users WHERE login='" + login + "'");
			if (!resultat.next() && password.equals(confirmPassword)) {
				ConnexionBDD.insertIntoDataBase(
						"CREATE Users(login, password) VALUES('" + login + "','" + password + "')");
				resultat = ConnexionBDD.requestFromDataBase("SELECT id FROM Users WHERE login='" + login + "'");
				int id = resultat.getInt("id");
				session.setAttribute("id", id);
				dispatcher = request.getRequestDispatcher("accueil.jsp");
			} else {
				dispatcher = request.getRequestDispatcher("register.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dispatcher.forward(request, response);

	}
}