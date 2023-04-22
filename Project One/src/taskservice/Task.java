/*
 * Nicholas Glover
 * 4/4/2023
 * CS-320: Project One
 */

package taskservice;

public class Task {
	private String id;
	private String name;
	private String desc;
	
	public Task(String id, String name, String desc) {
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid id: ID must not be null or longer than 10 characters.");
		}
		if(name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name: Name must not be null or longer than 20 characters.");
		}
		if(desc == null || desc.length() > 50) {
			throw new IllegalArgumentException("Invalid desc: Description must not be null or longer than 50 characters.");
		}
		
		this.id = id;
		this.name = name;
		this.desc = desc;
	}
	
	// Getters
	public String getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDesc() {
		return desc;
	}
	
	// Setters
	public void setName(String name) {
		if(name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name: Name must not be null or longer than 20 characters.");
		}
		
		this.name = name;
	}
	
	public void setDesc(String desc) {
		if(desc == null || desc.length() > 50) {
			throw new IllegalArgumentException("Invalid desc: Description must not be null or longer than 50 characters.");
		}
		
		this.desc = desc;
	}
}
