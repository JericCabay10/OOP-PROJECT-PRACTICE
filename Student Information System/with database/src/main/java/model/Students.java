package model;

import java.time.*;

public class Students {
	private String id;
	private String name;
	private int birthDate;
	private int age;
	private String gender;
	private String course;
	
	static LocalDate today = LocalDate.now();
	
	public Students(String id, String name, int birthDate, int age, String gender, String course) {
		setId(id);
		this.name = name;
		this.birthDate = birthDate;
		this.age = age;
		this.gender = gender;
		this.course = course;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		int count = 0;
		
		for(int a = 0; a < id.length(); a++) {
			char ch = id.charAt(a);
			
			if(ch >= '0' && ch <= '9') {
				count++;
			}
		}
		
		if(count == 9) {
			this.id = id;
		}else {
			System.out.println("The Id it must be 9 digit!");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	public void DisplayInfo() {
		System.out.println("Student Id: " + this.id);
		System.out.println("Name: " + this.name);
		System.out.println("Birth Date: " + this.birthDate);
		System.out.println("Age: " + this.age);
		System.out.println("Gender: " + this.gender);
		System.out.println("Course: " + this.course);
		System.out.println(); 
	}
	
}
