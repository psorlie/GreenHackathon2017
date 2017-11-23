/**
 * 
 */
package greenHackaton2017.java.model;

/**
 * @author sorlie
 *
 */
public class Dentiste {
	private String firstName;
	private String surname;
	private String speciality;
	private Day[] openingHours;
	private String photo;
	private String city;
	private String adresse;
	private boolean gender;
	private String email;
	private Long phone;
	
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
	
	public Day[] getOpeningHours() {
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
	
	public void setOpeningHours(Day[] openingHours) {
		this.openingHours = openingHours;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adress) {
		this.adresse = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	
}
