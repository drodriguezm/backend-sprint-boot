package com.bezkoder.spring.jpa.h2.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;
	
	//@Column(name = "birthdate")
	//private Date birthDate;

	@Column(name = "address")
	private String address;
	
	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	public Person() {
		
	}
	
	public Person(String dni, String firstName, String lastName,
	 //Date birthDate,
	  String address, String email, String phone) {
		this.dni = dni;
		this.firstName = firstName;
		this.lastName = lastName;
		//this.birthDate = birthDate;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	//public Date getBirthDate() {
	//	return birthDate;
	//}

	//public void setBirthDate(Date birthDate) {
	//	this.birthDate = birthDate;
	//}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	  	
}