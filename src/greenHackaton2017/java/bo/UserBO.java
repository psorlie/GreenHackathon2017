package greenHackaton2017.java.bo;

import java.sql.SQLException;

import greenHackaton2017.java.dao.UserDAO;
import greenHackaton2017.java.model.User;

public class UserBO {
	
	private UserDAO userDAO = new UserDAO();
	
	private UserBO() {
		
	}
	
	public void addUser(String login, String password) throws SQLException {
		userDAO.createUser(new User(login, password));
	}
	
	public User getUser(String login, String password) throws SQLException {
		
		User possibleUser = userDAO.getUser(login);
		
		if(!(possibleUser.getPassword().equals(password))) {
			possibleUser = null;
		}
		return possibleUser;
	}
	
}
