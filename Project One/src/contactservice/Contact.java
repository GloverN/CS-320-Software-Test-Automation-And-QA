/*
 * Nicholas Glover
 * 4/4/2023
 * CS-320: Project One
 */

package contactservice;

public class Contact {
	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String id, String firstName, String lastName, String phone, String address) {
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID: ID must not be null or longer than 10 characters.");
		}
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid firstName: Name must not be null or longer than 10 characters.");
		}
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid lastName: Name must not be null or longer than 10 characters.");
		}
		if(phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone: Phone number must be 10 characters or not be null.");
		}
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address: Address must not be null or longer than 30 characters.");
		}
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// Getters
	public String getID() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	// Setters
	public void setFirstName(String firstName) {
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid firstName: Name must not be null or longer than 10 characters.");
		}
		
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid lastName: Name must not be null or longer than 10 characters.");
		}
		
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		if(phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone: Phone number must be 10 characters or not be null.");
		}
		
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address: Address must not be null or longer than 30 characters.");
		}
		
		this.address = address;
	}
}
