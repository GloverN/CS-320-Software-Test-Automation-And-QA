/*
 * Nicholas Glover
 * 4/4/2023
 * CS-320: Project One
 */

package apptservice;

import apptservice.Appointment;

import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {
	private ArrayList<Appointment> apptList;
	
	public AppointmentService() {
		apptList = new ArrayList<>();
	}
	
	public boolean addAppointment(Appointment appt) {
		for(Appointment i : apptList) {
			if(i.getID().equals(appt.getID()))
				return false;
		}
		
		apptList.add(appt);
		
		return true;
	}
	
	public boolean addAppointment(String id, long date, String desc) {
		for(Appointment i : apptList) {
			if(i.getID().equals(id))
				return false;
		}
		
		apptList.add(new Appointment(id, new Date(date), desc));
		
		return true;
	}
	
	public boolean deleteAppointment(Appointment appt) {
		for(Appointment i : apptList) {
			if(i.getID().equals(appt.getID())) {
				return apptList.remove(i);
			}
		}
		
		return false;
	}
	
	public boolean deleteAppointment(String id) {
		for(Appointment i : apptList) {
			if(i.getID().equals(id)) {
				return apptList.remove(i);
			}
		}
		
		return false;
	}
}
