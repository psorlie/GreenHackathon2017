package greenHackaton2017.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import bdd.ConnexionBDD;
import greenHackaton2017.java.model.Day;
import greenHackaton2017.java.model.Dentiste;

public class DentisteDAO {

	public Dentiste[] trouverDentistes(Dentiste dentiste) throws SQLException {
		Dentiste[] dentistes;
		String firstName = dentiste.getFirstName();
		String lastName = dentiste.getSurname();
		String email = dentiste.getEmail();
		boolean gender = dentiste.isFemale();
		String speciality = dentiste.getSpeciality();
		String adress = dentiste.getAddress();
		String city = dentiste.getCity();
		String phone = dentiste.getPhoto();
		Integer lundiOuverture = dentiste.getOpeningHours()[0].getOpening();
		Integer lundiFermeture = dentiste.getOpeningHours()[0].getClosing();
		Integer mardiOuverture = dentiste.getOpeningHours()[1].getOpening();
		Integer mardiFermeture = dentiste.getOpeningHours()[1].getClosing();
		Integer mercrediOuverture = dentiste.getOpeningHours()[2].getOpening();
		Integer mercrediFermeture = dentiste.getOpeningHours()[2].getClosing();
		Integer jeudiOuverture = dentiste.getOpeningHours()[3].getOpening();
		Integer jeudiFermeture = dentiste.getOpeningHours()[3].getClosing();
		Integer vendrediOuverture = dentiste.getOpeningHours()[4].getOpening();
		Integer vendrediFermeture = dentiste.getOpeningHours()[4].getClosing();

		String clauseWhere = (lastName != "" ? " AND '" + lastName + "'=first_name" : "")
				+ (speciality != "" ? " AND '" + speciality + "'=speciality" : "")
				+ (city != "" ? " AND '" + city + "'=city" : "") 
				+ (lundiOuverture != null ? " AND " + lundiOuverture + ">=MondayOpening" : "") 
				+ (lundiFermeture != null ? " AND " + lundiFermeture + "<=MondayClosing" : "") 
				
				+ (mardiOuverture != null ? " AND " + mardiOuverture + ">=TuesdayOpening" : "") 
				+ (mardiFermeture != null ? " AND " + mardiFermeture + "<=TuesdayClosing" : "")
				
				+ (mercrediOuverture != null ? " AND " + mercrediOuverture + ">=WednesdayOpening" : "") 
				+ (mercrediFermeture != null ? " AND " + mercrediFermeture + "<=WednesdayClosing" : "") 
				
				+ (jeudiOuverture != null ? " AND " + jeudiOuverture + ">=ThursdayOpening" : "") 
				+ (jeudiFermeture != null ? " AND " + jeudiFermeture + "<=ThursdayClosing" : "")
				
				+ (vendrediOuverture != null ? " AND " + vendrediOuverture + ">=FridayOpening" : "") 
				+ (vendrediFermeture != null ? " AND " + vendrediFermeture + "<=FridayClosing" : "") ;

		String request = "SELECT d.id, first_name, last_name, email, gender, speciality, address, city, phone, image, "
				+ "MondayOpening, MondayClosing, TuesdayOpening, TuesdayClosing, WednesdayOpening, "
				+ "WednesdayClosing, ThursdayOpening, ThursdayClosing, FridayOpening, FridayClosing "
				+ "FROM dentist d, openings o " + "WHERE d.id = o.id_dentist" + clauseWhere;

		
		ResultSet result = ConnexionBDD.getConnexion().requestFromDataBase(request);
				
		System.out.println(request);
		
		result.last();
		int nbDentist = result.getRow();
		result.beforeFirst();
		dentistes = new Dentiste[nbDentist];
		int i = 0;

		while (result.next()) {
			dentistes[i] = map(result);
			++i;
		}
		System.out.println(i);
		return dentistes;
	}

	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des utilisateurs (un
	 * ResultSet) et un bean Utilisateur.
	 */
	private static Dentiste map(ResultSet result) throws SQLException {
		
		Day[] days = { new Day(result.getInt("MondayOpening"), result.getInt("MondayClosing")),
				new Day(result.getInt("TuesdayOpening"), result.getInt("TuesdayClosing")),
				new Day(result.getInt("WednesdayOpening"), result.getInt("WednesdayClosing")),
				new Day(result.getInt("ThursdayOpening"), result.getInt("ThursdayClosing")),
				new Day(result.getInt("FridayOpening"), result.getInt("FridayClosing")) };
		
		return new Dentiste(
				result.getInt("id"),
				result.getString("first_name"), result.getString("last_name"),
				result.getString("speciality"), days,
				result.getString("image"), result.getString("city"), 
				result.getString("address"), result.getBoolean("gender"),
				result.getString("email"), result.getLong("phone"));
	}
}
