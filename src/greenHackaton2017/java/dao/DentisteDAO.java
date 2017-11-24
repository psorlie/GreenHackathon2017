package greenHackaton2017.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bdd.ConnexionBDD;
import greenHackaton2017.java.model.Day;
import greenHackaton2017.java.model.Dentiste;

public class DentisteDAO {

	public static List<Dentiste> trouverDentistes(Dentiste dentiste) throws SQLException {

		String lastName = dentiste.getSurname();
		String speciality = dentiste.getSpeciality();
		String city = dentiste.getCity();
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
				+ (lundiOuverture != null || mardiOuverture != null || mercrediOuverture != null
						|| jeudiOuverture != null
						|| vendrediOuverture != null
								? (" AND ("
										+ (lundiOuverture != null
												? "(" + lundiFermeture + ">MondayOpening AND MondayOpening != 0) OR "
												: "")
										+ (lundiFermeture != null ? lundiOuverture + "<MondayClosing OR " : "")

										+ (mardiOuverture != null
												? "(" + mardiFermeture + ">TuesdayOpening AND MondayOpening != 0) OR "
												: "")
										+ (mardiFermeture != null ? mardiOuverture + "<TuesdayClosing OR " : "")

										+ (mercrediOuverture != null
												? "(" + mercrediFermeture
														+ ">WednesdayOpening AND MondayOpening != 0) OR "
												: "")
										+ (mercrediFermeture != null ? mercrediOuverture + "<WednesdayClosing OR " : "")

										+ (jeudiOuverture != null
												? "(" + jeudiFermeture + ">ThursdayOpening AND MondayOpening != 0) OR "
												: "")
										+ (jeudiFermeture != null ? jeudiOuverture + "<ThursdayClosing OR " : "")

										+ (vendrediOuverture != null
												? "(" + vendrediFermeture + ">FridayOpening AND MondayOpening != 0) OR "
												: "")
										+ (vendrediFermeture != null ? vendrediOuverture + "<FridayClosing OR " : "")
										+ " 0)")
								: "");

		String request = "SELECT d.id, first_name, last_name, email, gender, speciality, address, city, phone, image, "
				+ "MondayOpening, MondayClosing, TuesdayOpening, TuesdayClosing, WednesdayOpening, "
				+ "WednesdayClosing, ThursdayOpening, ThursdayClosing, FridayOpening, FridayClosing "
				+ "FROM dentist d, openings o " + "WHERE d.id = o.id_dentist" + clauseWhere;

		ResultSet result = ConnexionBDD.getConnexion().requestFromDataBase(request);

		List<Dentiste> dentistes = new ArrayList<Dentiste>();
		while (result.next()) {
			dentistes.add(map(result));
		}
		return dentistes;
	}

	public static List<Dentiste> dentistesContactes(String login) throws SQLException {
		List<Dentiste> dentistes = new ArrayList<>();
		String requete = "SELECT d.id, first_name, last_name, email, gender, speciality, address, city, phone"
				+ ", image, MondayOpening, MondayClosing, TuesdayOpening, TuesdayClosing, WednesdayOpening,"
				+ " WednesdayClosing, ThursdayOpening, ThursdayClosing, FridayOpening, FridayClosing FROM "
				+ "dentist d, openings o , relation1 r where d.id = o.id_dentist AND r.id = d.id AND r.id_users"
				+ " = (select id from users where login = '"+login+"')";
		
		ResultSet result = ConnexionBDD.getConnexion().requestFromDataBase(requete);

		while (result.next()) {
			dentistes.add(map(result));
		}
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

		return new Dentiste(result.getInt("id"), result.getString("first_name"), result.getString("last_name"),
				result.getString("speciality"), days, result.getString("image"), result.getString("city"),
				result.getString("address"), result.getBoolean("gender"), result.getString("email"),
				result.getLong("phone"));
	}
}
