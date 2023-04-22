/*
 * Nicholas Glover
 * 4/4/2023
 * CS-320: Project One
 */

package contactservice;

import java.util.ArrayList;

public class ContactService {
	private ArrayList<Contact> contactList;
	
	public ContactService() {
		contactList = new ArrayList<>();
	}
	
	public boolean addContact(Contact addition) {
		for(Contact i : contactList) {
			if(i.getID().equals(addition.getID()))
				return false;
		}
		
		contactList.add(addition);
		
		return true;
	}
	
	public boolean addContact(String id, String firstName, String lastName, String phone, String address) {
		for(Contact i : contactList) {
			if(i.getID().equals(id))
				return false;
		}
		
		contactList.add(new Contact(id, firstName, lastName, phone, address));
		
		return true;
	}
	
	public boolean updateContact(Contact updated) {
		for(Contact i : contactList) {
			if(i.getID().equals(updated.getID())) {
				i = updated;
				return true;
			}
		}
		
		return false;
	}
	
	public boolean updateContact(String id, String firstName, String lastName, String phone, String address) {
		for(Contact i : contactList) {
			if(i.getID().equals(id)) {
				i = new Contact(id, firstName, lastName, phone, address);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean deleteContact(Contact deleted) {
		for(Contact i : contactList) {
			if(i.getID().equals(deleted.getID())) {
				return contactList.remove(i);
			}
		}
		
		return false;
	}
	
	public boolean deleteContact(String id) {
		for(Contact i : contactList) {
			if(i.getID().equals(id)) {
				return contactList.remove(i);
			}
		}
		
		return false;
	}
}
