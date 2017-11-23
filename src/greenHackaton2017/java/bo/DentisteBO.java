package greenHackaton2017.java.bo;

import java.sql.SQLException;

import greenHackaton2017.java.dao.DentisteDAO;
import greenHackaton2017.java.model.Dentiste;

public class DentisteBO {

	DentisteDAO dao;
	
	public DentisteBO(DentisteDAO dao){
		this.dao = dao;
	}
	
	public Dentiste[] trouverDentistes(Dentiste dentiste) throws SQLException{
		return this.dao.trouverDentistes(dentiste);
	}
}
