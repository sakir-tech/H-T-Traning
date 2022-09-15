package com.flightapp.entity;

import javax.persistence.Entity;

@Entity
public class Passenger extends AbstractEntity {

	private String name;
	private String gender;
	private String meal;
	private Integer age;
	private String phone;

	public Passenger() {
		// TODO Auto-generated constructor stub
	}

	public Passenger(String name, String email, String gender, String meal, Integer age, String phone) {
		super();
		this.name = name;
		this.gender = gender;
		this.meal = meal;
		this.age = age;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
