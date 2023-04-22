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
import java.util.Date;

class AppointmentTest {
	private Appointment appt;
	private Date future;
	private Date past;

	@BeforeEach
	void setUp() throws Exception {
		future = new Date();
		past = new Date();
		future.setTime(future.getTime() + 10000);
		past.setTime(past.getTime() - 10000);
		appt = new Appointment("12345", future, "An appointment set in the future.");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testApptGets() {
		assertEquals(appt.getID(), "12345");
		assertEquals(appt.getDate(), future);
		assertEquals(appt.getDesc(), "An appointment set in the future.");
	}
	
	@Test
	void testApptCreateIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, future, "An appointment set in the future.");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", null, "An appointment set in the future.");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", future, null);
		});
	}
	
	@Test
	void testApptCreateIsLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345678901", future, "An appointment set in the future.");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", future, "An appointment set in the future.123456789012345678");
		});
	}
	
	@Test
	void testApptCreateIsInPast() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", past, "An appointment set in the past.");
		});
	}

}
