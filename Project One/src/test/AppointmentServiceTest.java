/*
 * Nicholas Glover
 * 4/4/2023
 * CS-320: Project One
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import apptservice.Appointment;
import apptservice.AppointmentService;
import java.util.Date;

class AppointmentServiceTest {
	private AppointmentService apptList;
	private Date future;

	@BeforeEach
	void setUp() throws Exception {
		future = new Date();
		future.setTime(future.getTime() + 10000);
		apptList = new AppointmentService();
		apptList.addAppointment(new Appointment("12345", future, "An appointment set in the future."));
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAppointmentServiceAddition() {
		assertFalse(apptList.addAppointment(new Appointment("12345", future, "An appointment set in the future.")));
		assertFalse(apptList.addAppointment("12345", future.getTime(), "An appointment set in the future."));
		assertTrue(apptList.addAppointment(new Appointment("67890", future, "A second appointment set in the future.")));
		assertTrue(apptList.addAppointment("15973", future.getTime(), "A third appointment set in the future."));
	}
	
	@Test
	void testAppointmentServiceDelete() {
		assertFalse(apptList.deleteAppointment(new Appointment("67890", future, "A second appointment set in the future.")));
		assertFalse(apptList.deleteAppointment("16254"));
		assertTrue(apptList.deleteAppointment(new Appointment("12345", future, "An appointment set in the future.")));
		assertFalse(apptList.deleteAppointment("12345"));
		apptList.addAppointment(new Appointment("12345", future, "An appointment set in the future."));
		assertTrue(apptList.deleteAppointment("12345"));
	}

}
