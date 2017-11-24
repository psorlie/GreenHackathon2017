package greenHackaton2017.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import greenHackaton2017.java.dao.DentisteDAO;
import greenHackaton2017.java.model.Day;
import greenHackaton2017.java.model.Dentiste;
import greenHackaton2017.java.model.User;

/**
 * Servlet implementation class ResultatsRecherche
 */
@WebServlet("/RechercheContacte")
public class RechercheContacte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheContacte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("utilisateur") == null) {
			response.sendRedirect("index.jsp?connexion=false");
		} else {
			
			User user = (User)session.getAttribute("utilisateur");
			
			
			List<Dentiste> dentistes = new ArrayList<Dentiste>();

			try {
				dentistes = DentisteDAO.dentistesContactes(user.getLogin());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Collections.shuffle(dentistes);
			
			user.setDentistesConsultes(dentistes);
			session.setAttribute("utilisateur", user);

			RequestDispatcher dispat = request.getRequestDispatcher("resultatsRecherche.jsp");
			dispat.forward(request, response);
		}
	}


}
