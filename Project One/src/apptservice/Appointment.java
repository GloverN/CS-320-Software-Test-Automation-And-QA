/*
 * Nicholas Glover
 * 4/4/2023
 * CS-320: Project One
 */

package apptservice;

import java.util.Date;

public class Appointment {
	private String id;
	private Date now = new Date();
	private Date date;
	private String desc;
	
	public Appointment(String id, Date date, String desc) {
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid id: ID must not be null or longer than 10 characters.");
		}
		if(date == null || date.before(now)) {
			throw new IllegalArgumentException("Invalid date: Date must not be null or in the past.");
		}
		if(desc == null || desc.length() > 50) {
			throw new IllegalArgumentException("Invalid desc: Description must not be null or longer than 50 characters.");
		}
		
		this.id = id;
		this.date = date;
		this.desc = desc;
	}
	
	//Getters
	public String getID() {
		return id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getDesc() {
		return desc;
	}
}
