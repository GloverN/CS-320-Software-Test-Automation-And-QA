/*
 * Nicholas Glover
 * 4/4/2023
 * CS-320: Project One
 */

package taskservice;

import java.util.ArrayList;

import taskservice.Task;

public class TaskService {
	private ArrayList<Task> taskList;
	
	public TaskService() {
		taskList = new ArrayList<>();
	}
	
	public boolean addTask(Task addition) {
		for(Task i : taskList) {
			if(i.getID().equals(addition.getID()))
				return false;
		}
		
		taskList.add(addition);
		
		return true;
	}
	
	public boolean addTask(String id, String name, String desc) {
		for(Task i : taskList) {
			if(i.getID().equals(id))
				return false;
		}
		
		taskList.add(new Task(id, name, desc));
		
		return true;
	}
	
	public boolean updateTask(Task updated) {
		for(Task i : taskList) {
			if(i.getID().equals(updated.getID())) {
				i = updated;
				return true;
			}
		}
		
		return false;
	}
	
	public boolean updateTask(String id, String name, String desc) {
		for(Task i : taskList) {
			if(i.getID().equals(id)) {
				i = new Task(id, name, desc);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean deleteTask(Task deleted) {
		for(Task i : taskList) {
			if(i.getID().equals(deleted.getID())) {
				return taskList.remove(i);
			}
		}
		
		return false;
	}
	
	public boolean deleteTask(String id) {
		for(Task i : taskList) {
			if(i.getID().equals(id)) {
				return taskList.remove(i);
			}
		}
		
		return false;
	}
}
