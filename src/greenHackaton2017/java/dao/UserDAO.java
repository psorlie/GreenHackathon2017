package greenHackaton2017.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import bdd.ConnexionBDD;
import greenHackaton2017.java.model.User;

public class UserDAO {
	public boolean createUser(User user) throws SQLException {
		ConnexionBDD.insertIntoDataBase("INSERT INTO User (login, password) VALUES ('" + user.getLogin() + "','" + user.getPassword() + "')");
		return true; // in case of the insert request can return something
	}
	
	public User getUser(String login) throws SQLException {
		
		ResultSet res = ConnexionBDD.requestFromDataBase("SELECT login, password FROM User WHERE login = '" + login + "'");
		if(res.next()) {
			return (new User(res.getString(1), res.getString(2)));
		} else {
			return null;
		}
		
	}
}
