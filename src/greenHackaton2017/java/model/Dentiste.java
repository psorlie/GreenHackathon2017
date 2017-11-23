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
	private String address;
	private boolean gender;
	private String email;
	private Long phone;
	
	public Dentiste(String firstName, String surname, String speciality, Day[] openingHours,
			String photo, String city, String address, boolean gender, String email, Long phone) {
		this.firstName = firstName;
		this.surname = surname;
		this.speciality = speciality;
		this.openingHours = openingHours;
		this.photo = photo;
		this.city = city;
		this.address = address;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
	}
	
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

	public String getAddress() {
		return this.address;
	}

	public String getCity() {
		return this.city;
	}

	public boolean isFemale() {
		return this.gender;
	}

	public String getEmail() {
		return this.email;
	}
	
	public Long getPhone() {
		return this.phone;
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

	public void setAdress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setFemale(boolean isFemale) {
		this.gender = isFemale;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPhone(Long phone) {
		this.phone = phone;
	}
}
