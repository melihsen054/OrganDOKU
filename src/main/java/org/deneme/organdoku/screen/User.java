package org.deneme.organdoku.screen;

import java.io.File;
import java.io.Serializable;

//This class is to manage the users easily

public class User implements Serializable{
	private String name = "Mr/Mrs"; //field
	private int age=0;
	private boolean gender=true;
	private String username="sari cizmeli mehmet aga";
	private String password;
	private File file;
	
	public User(){
		
	}
	
	public User(String name, int age, boolean gender , String username , String password) { // constructor for user
		setName(name);
		setAge(age);
		setGender(gender);
		setUsername(username);
		setPassword(password);
	}
	
	public String getName() { //getter and setter methods
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
