package greenHackaton2017.java.bo;

import greenHackaton2017.java.dao.UserDAO;
import greenHackaton2017.java.model.User;

public class UserBO {
	
	private UserDAO userDAO = new UserDAO();
	
	private UserBO() {
		
	}
	
	public void addUser(String login, String password) {
		userDAO.createUser(new User(login, password));
	}
	
	public User getUser(String login, String password) {
		User possibleUser = userDAO.getUser(login);
		if(possibleUser.getPassword().equals(password)) {
			return possibleUser;
		} else {
			return null;
		}
	}
	
}
