package com.techpalle;

public class Department 
{
	private int id;
	private String name;
	private String location;
	private int strength;
	
	public Department(int id, String name, String location, int strength) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.strength = strength;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
}
