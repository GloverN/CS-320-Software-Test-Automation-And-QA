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

import taskservice.Task;

class TaskTest {
	private Task task;
	
	@BeforeEach
	void setUp() throws Exception {
		task = new Task("12345", "Task #1", "Completes Task #1");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testTaskGets() {
		assertEquals(task.getID(), "12345");
		assertEquals(task.getName(), "Task #1");
		assertEquals(task.getDesc(), "Completes Task #1");
	}
	
	@Test
	void testTaskCreateIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Task #1", "Completes Task #1");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", null, "Completes Task #1");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "Task #1", null);
		});
	}
	
	@Test
	void testTaskCreateIsLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678901", "Task #1", "Completes Task #1");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "Task #123456789012345", "Completes Task #1");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "Task #1", "Completes Task #12345678901234567890123456789012345");
		});
	}
	
	@Test
	void testTaskSet() {
		task.setName("Task #2");
		assertNotEquals(task.getName(), "Task #1");
		assertEquals(task.getName(), "Task #2");
		task.setDesc("Completes Task #2");
		assertNotEquals(task.getDesc(), "Completes Task #1");
		assertEquals(task.getDesc(), "Completes Task #2");
	}
	
	@Test
	void testTaskSetIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			task.setName(null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			task.setDesc(null);
		});
	}
	
	@Test
	void testTaskSetIsLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			task.setName("Task #123456789012345");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			task.setDesc("Completes Task #12345678901234567890123456789012345");
		});
	}

}
