/**
 * 
 */
package com.bimal.model;

/**
 * @author bimalthapa
 *
 */
public class UserModel {
	
	private String email;
	private String password;
	private String name;
	private String gender;
	private String contact;
	private String country;
	
	/**
	 Default constructor
	 */
	public UserModel(){
		this.email = "";
		this.password = "";
		this.name = "";
		this.gender = "";
		this.contact = "";
		this.country = "";
	}
	
	/**
	 * @param email
	 * @param password
	 * @param name
	 * @param gender
	 * @param contact
	 * @param country
	 */
	public UserModel(String email, String password, String name, String gender, String contact, String country) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.contact = contact;
		this.country = country;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
}
