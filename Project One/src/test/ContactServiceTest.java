/*
 * Nicholas Glover
 * 4/4/2023
 * CS-320: Project One
 */

package test;

import contactservice.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	private ContactService contactList;

	@BeforeEach
	void setUp() throws Exception {
		contactList = new ContactService();
		contactList.addContact(new Contact("12345", "Sam", "Smith", "1234567890", "12345 67th St S"));
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testContactServiceAddition() {
		assertFalse(contactList.addContact(new Contact("12345", "Sam", "Smith", "1234567890", "12345 67th St S")));
		assertFalse(contactList.addContact("12345", "Sam", "Smith", "1234567890", "12345 67th St S"));
		assertTrue(contactList.addContact(new Contact("16254", "Nick", "Glover", "4257856374", "Maple Valley, WA")));
		assertTrue(contactList.addContact("15687", "Chris", "Glover", "4255006372", "Maple Valley, WA"));
	}
	
	@Test
	void testContactServiceUpdate() {
		assertFalse(contactList.updateContact(new Contact("16254", "Nick", "Glover", "4257856374", "Maple Valley, WA")));
		assertFalse(contactList.updateContact("16254", "Nick", "Glover", "4257856374", "Maple Valley, WA"));
		assertTrue(contactList.updateContact(new Contact("12345", "Sam", "Glover", "1234567890", "12345 67th St S")));
		assertTrue(contactList.updateContact("12345", "Sam", "Glover", "0987654321", "12345 67th St S"));
	}
	
	@Test
	void testContactServiceDelete() {
		assertFalse(contactList.deleteContact(new Contact("16254", "Nick", "Glover", "4257856374", "Maple Valley, WA")));
		assertFalse(contactList.deleteContact("16254"));
		assertTrue(contactList.deleteContact(new Contact("12345", "Sam", "Smith", "1234567890", "12345 67th St S")));
		assertFalse(contactList.deleteContact("12345"));
		contactList.addContact(new Contact("12345", "Sam", "Smith", "1234567890", "12345 67th St S"));
		assertTrue(contactList.deleteContact("12345"));
	}

}
