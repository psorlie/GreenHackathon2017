package greenHackaton2017.java.bo;

import java.sql.SQLException;

import greenHackaton2017.java.dao.UserDAO;
import greenHackaton2017.java.model.User;

public class UserBO {
	
	private UserDAO dao;
	
	private UserBO(UserDAO dao) {
		this.dao = dao;
	}
	
	public void addUser(String login, String password) throws SQLException {
		dao.createUser(new User(login, password));
	}
	
	public User getUser(String login, String password) throws SQLException {
		User possibleUser = dao.getUser(login);
		if(possibleUser.getPassword().equals(password)) {
			return possibleUser;
		} else {
			return null;
		}
	}
	
}
