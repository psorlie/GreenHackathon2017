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

import greenHackaton2017.java.dao.DentisteDAO;
import greenHackaton2017.java.model.Day;
import greenHackaton2017.java.model.Dentiste;
import greenHackaton2017.java.model.User;

/**
 * Servlet implementation class ResultatsRecherche
 */
@WebServlet("/ResultatsRecherche")
public class ResultatsRecherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultatsRecherche() {
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
			
			User user = (User)session.getAttribute("user");
			
			Day[] semaine = new Day[5];
			int horaireDebut = Integer.parseInt( request.getParameter("horaire_debut") );
			int horaireFin = Integer.parseInt( request.getParameter("horaire_fin") );
			if (request.getParameter("lundi") != null) {
				semaine[0].setOpening(horaireDebut);
				semaine[0].setClosing(horaireFin);
			} else {
				semaine[0] = null;
			}
			if (request.getParameter("mardi") != null) {
				semaine[1].setOpening(horaireDebut);
				semaine[1].setClosing(horaireFin);
			} else {
				semaine[1] = null;
			}
			if (request.getParameter("mercredi") != null) {
				semaine[2].setOpening(horaireDebut);
				semaine[2].setClosing(horaireFin);
			} else {
				semaine[2] = null;
			}
			if (request.getParameter("jeudi") != null) {
				semaine[3].setOpening(horaireDebut);
				semaine[3].setClosing(horaireFin);
			} else {
				semaine[3] = null;
			}
			if (request.getParameter("vendredi") != null) {
				semaine[4].setOpening(horaireDebut);
				semaine[4].setClosing(horaireFin);
			} else {
				semaine[4] = null;
			}
			
			
			Dentiste dentiste = new Dentiste();
			dentiste.setSurname(request.getParameter("nom"));
			dentiste.setCity(request.getParameter("ville"));
			dentiste.setOpeningHours(semaine);
			dentiste.setSpeciality(request.getParameter("speciality"));
			Dentiste[] dentistes = null;
			try {
				dentistes = ( new DentisteDAO() ).trouverDentistes(dentiste);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("resultats", dentistes);
			
			RequestDispatcher dispat = request.getRequestDispatcher("resultatsRecherche.jsp");
			dispat.forward(request, response);
		}
	}


}
