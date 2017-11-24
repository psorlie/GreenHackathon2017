package greenHackaton2017.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import bdd.ConnexionBDD;
import greenHackaton2017.java.model.User;

public class UserDAO {
	public boolean createUser(User user) throws SQLException {
		ConnexionBDD.getConnexion().insertIntoDataBase("INSERT INTO users (login, password) VALUES ('" + user.getLogin() + "','" + user.getPassword() + "')");
		return true; // in case of the insert request can return something
	}
	
	public User getUser(String login) throws SQLException {
		
		ResultSet res = ConnexionBDD.getConnexion().requestFromDataBase("SELECT login, password FROM users WHERE login = '" + login + "'");
		if(res.next()) {
			return (new User(res.getString(1), res.getString(2)));
		} else {
			return null;
		}
		
	}
	
	public Boolean isConnecte(User utilisateur, int idDentist) throws SQLException{
		System.out.println("SELECT id FROM relation1 "
				+ "WHERE id='"+idDentist+"' and id_users= (SELECT `id` FROM `users` WHERE `login` = '"+utilisateur.getLogin()+"')");
		ResultSet res = ConnexionBDD.getConnexion().requestFromDataBase("SELECT id FROM relation1 "
				+ "WHERE id='"+idDentist+"' and id_users= (SELECT `id` FROM `users` WHERE `login` = '"+utilisateur.getLogin()+"')");
		return res.next();
	}
	
	public void contacter(User utilisateur, int idDentist) throws SQLException{
		ConnexionBDD.getConnexion().requestFromDataBase("INSERT INTO `relation1`(`id`, `id_users`) VALUES "
				+ "("+idDentist+",(SELECT `id` FROM `users` WHERE `login` = '"+utilisateur.getLogin()+"'))");
	}
}
