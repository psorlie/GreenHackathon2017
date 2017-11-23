package greenHackaton2017.java.bo;

import java.util.ArrayList;

import greenHackaton2017.java.dao.DentisteDAO;
import greenHackaton2017.java.model.Dentiste;;

public class DentisteBO {
	
	private DentisteDAO dentisteDAO = new DentisteDAO();
	
	
	public ArrayList<Dentiste> getListDentiste(Dentiste fakeDentiste) {
		ArrayList<Dentiste> array = DentisteDAO.trouverDentistes(fakeDentiste);
		return array;
	}
}
