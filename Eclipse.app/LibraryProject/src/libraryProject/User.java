package libraryProject;

import java.util.ArrayList;

/**
 * 
 * Allows the creation of a new User to access the Library program
 * 
 * @author Mark MacDonald and Samantha Tilo
 */
public class User {
	private String name;
	private String email;
	private int phoneNumber;

	/**
	 * Creates a new instance of User
	 * 
	 * @param name        Name of User
	 * @param email       Email of User
	 * @param phoneNumber Phone Number of User
	 */
	public User(String name, String email, int phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the phoneNumber
	 */
	public int getPhoneNumber() {
		return phoneNumber;
	}
}
