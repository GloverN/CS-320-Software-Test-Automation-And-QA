/*
 * Nicholas Glover
 * 4/4/2023
 * CS-320: Project One
 */

package test;

import contactservice.Contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {
	private Contact contact;
	
	@BeforeEach
	void setUp() throws Exception {
		contact = new Contact("12345", "Sam", "Smith", "1234567890", "12345 67th St S");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testContactGets() {
		assertEquals(contact.getID(), "12345");
		assertEquals(contact.getFirstName(), "Sam");
		assertEquals(contact.getLastName(), "Smith");
		assertEquals(contact.getPhone(), "1234567890");
		assertEquals(contact.getAddress(), "12345 67th St S");
	}
	
	@Test
	void testContactCreateIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Sam", "Smith", "1234567890", "12345 67th St S");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", null, "Smith", "1234567890", "12345 67th St S");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Sam", null, "1234567890", "12345 67th St S");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Sam", "Smith", null, "12345 67th St S");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Sam", "Smith", "1234567890", null);
		});
	}
	
	@Test
	void testContactCreateIsLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "Sam", "Smith", "1234567890", "12345 67th St S");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Sam45678901", "Smith", "1234567890", "12345 67th St S");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Sam", "Smith678901", "1234567890", "12345 67th St S");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Sam", "Smith", "12345678901", "12345 67th St S");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Sam", "Smith", "1234567890", "12345 67th St S1111111111111111");
		});
	}
	
	@Test
	void testContactSet() {
		contact.setFirstName("Nick");
		assertNotEquals(contact.getFirstName(), "Sam");
		assertEquals(contact.getFirstName(), "Nick");
		contact.setLastName("Nick");
		assertNotEquals(contact.getLastName(), "Smith");
		assertEquals(contact.getLastName(), "Nick");
		contact.setPhone("0987654321");
		assertNotEquals(contact.getPhone(), "1234567890");
		assertEquals(contact.getPhone(), "0987654321");
		contact.setAddress("09876 54th Ave NW");
		assertNotEquals(contact.getAddress(), "12345 67th St S");
		assertEquals(contact.getAddress(), "09876 54th Ave NW");
	}
	
	@Test
	void testContactSetIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName(null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone(null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress(null);
		});
	}
	
	@Test
	void testContactSetIsLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("Sam45678901");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("Smith678901");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("12345678901");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("12345 67th St S1111111111111111");
		});
	}

}
