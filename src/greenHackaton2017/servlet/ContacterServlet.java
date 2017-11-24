package greenHackaton2017.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import greenHackaton2017.java.dao.UserDAO;
import greenHackaton2017.java.model.User;

/**
 * Servlet implementation class DeconnexionServlet
 */
@WebServlet("/ContacterServlet")
public class ContacterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ContacterServlet() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int idDentiste = Integer.parseInt(request.getParameter("id"));
		User utilisateur = (User) session.getAttribute("utilisateur");
		try {
			(new UserDAO()).setContacter(utilisateur, idDentiste);
		} catch (SQLException e) {
		}
		
		RequestDispatcher dispat = request.getRequestDispatcher("index.jsp?connexion=false");
	    dispat.forward(request, response);
	}
}
