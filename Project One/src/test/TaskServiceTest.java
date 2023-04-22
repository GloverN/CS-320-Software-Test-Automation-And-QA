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
import taskservice.TaskService;

class TaskServiceTest {
	private TaskService taskList;

	@BeforeEach
	void setUp() throws Exception {
		taskList = new TaskService();
		taskList.addTask(new Task("12345", "Task #1", "Completes Task #1"));
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testTaskServiceAddition() {
		assertFalse(taskList.addTask(new Task("12345", "Task #1", "Completes Task #1")));
		assertFalse(taskList.addTask("12345", "Task #1", "Completes Task #1"));
		assertTrue(taskList.addTask(new Task("67890", "Task #2", "Completes Task #2")));
		assertTrue(taskList.addTask("15973", "Task #3", "Completes Task #3"));
	}
	
	@Test
	void testTaskServiceUpdate() {
		assertFalse(taskList.updateTask(new Task("67890", "Task #2", "Completes Task #2")));
		assertFalse(taskList.updateTask("67890", "Task #2", "Completes Task #2"));
		assertTrue(taskList.updateTask(new Task("12345", "Task #2", "Completes Task #2")));
		assertTrue(taskList.updateTask("12345", "Task #3", "Completes Task #3"));
	}
	
	@Test
	void testTaskServiceDelete() {
		assertFalse(taskList.deleteTask(new Task("67890", "Task #2", "Completes Task #2")));
		assertFalse(taskList.deleteTask("16254"));
		assertTrue(taskList.deleteTask(new Task("12345", "Task #1", "Completes Task #1")));
		assertFalse(taskList.deleteTask("12345"));
		taskList.addTask(new Task("12345", "Task #1", "Completes Task #1"));
		assertTrue(taskList.deleteTask("12345"));
	}

}
