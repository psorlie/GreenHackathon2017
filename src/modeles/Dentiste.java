/**
 * 
 */
package modeles;

/**
 * @author sorlie
 *
 */
public class Dentiste {
	private String firstName;
	private String surname;
	private String speciality;
	private OpeningHours openingHours;
	private String photo;
	
	/*************************
	 ******** Getter *********
	 *************************/
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public String getSpeciality() {
		return this.speciality;
	}
	
	public OpeningHours getOpeningHours() {
		return this.openingHours;
	}
	
	public String getPhoto() {
		return this.photo;
	}
	
	/*************************
	 ******** Setter *********
	 *************************/
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	public void setOpeningHours(OpeningHours openingHours) {
		this.openingHours = openingHours;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	
}
