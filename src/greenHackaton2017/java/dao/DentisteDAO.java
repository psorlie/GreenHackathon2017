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

		String clauseWhere = (lastName != null ? " AND '" + lastName + "'=first_name" : "")
				+ (speciality != null ? " AND '" + speciality + "'=speciality" : "")
				+ (city != null ? " AND '" + city + "'=city" : "") 
				+ (lundiOuverture != null ? " AND " + lundiOuverture + ">=lundiOuverture" : "") 
				+ (lundiFermeture != null ? " AND " + lundiFermeture + "<=lundiFermeture" : "") 
				+ (mardiOuverture != null ? " AND " + mardiOuverture + ">=mardiOuverture" : "") 
				+ (mardiFermeture != null ? " AND " + mardiFermeture + "<=mardiFermeture" : "") 
				+ (mercrediOuverture != null ? " AND " + mercrediOuverture + ">=mercrediOuverture" : "") 
				+ (mercrediFermeture != null ? " AND " + mercrediFermeture + "<=mercrediFermeture" : "") 
				+ (jeudiOuverture != null ? " AND " + jeudiOuverture + ">=jeudiOuverture" : "") 
				+ (jeudiFermeture != null ? " AND " + jeudiFermeture + "<=jeudiFermeture" : "") 
				+ (vendrediOuverture != null ? " AND " + vendrediOuverture + ">=vendrediOuverture" : "") 
				+ (vendrediFermeture != null ? " AND " + vendrediFermeture + "<=vendrediFermeture" : "") ;

		ResultSet result = ConnexionBDD.getConnexion().requestFromDataBase(
				"SELECT d.first_name, d.last_name, d.email, d.gender, d.speciality, d.adress, d.city, d.phone, d.image, "
						+ "o.lundiOuverture, o.lundiFermeture, o.mardiOuverture, o.mardiFermeture, o.mercrediOuverture, "
						+ "o.mercrediFermeture, o.jeudiOuverture, o.jeudiFermeture, o.vendrediOuverture, o.vendrediFermeture "
						+ "FROM dentiste d, openings o " + "WHERE d.id = o.id_dentiste" + clauseWhere);

		result.last();
		int nbDentist = result.getRow();
		result.beforeFirst();
		dentistes = new Dentiste[nbDentist];
		int i = 0;

		while (result.next()) {
			dentistes[i] = map(result);
			++i;
		}

		return dentistes;
	}

	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des utilisateurs (un
	 * ResultSet) et un bean Utilisateur.
	 */
	private static Dentiste map(ResultSet result) throws SQLException {
		
		Day[] days = { new Day(result.getInt("lundiOuverture"), result.getInt("lundiFermeture")),
				new Day(result.getInt("mardiOuverture"), result.getInt("mardiFermeture")),
				new Day(result.getInt("mercrediOuverture"), result.getInt("mercrediFermeture")),
				new Day(result.getInt("jeudiOuverture"), result.getInt("jeudiFermeture")),
				new Day(result.getInt("vendrediOuverture"), result.getInt("vendrediFermeture")) };
		
		return new Dentiste(
				result.getString("first_name"), result.getString("last_name"),
				result.getString("speciality"), days,
				result.getString("image"), result.getString("city"), 
				result.getString("adresse"), result.getBoolean("gender"),
				result.getString("email"), result.getLong("phone"));
	}
}
