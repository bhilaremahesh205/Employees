package com.mahesh.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DevOps")

public class Employee {

	@Id
	String id;
	String empId;
	String empName;
	String empEmail;
	Double empContact;
	String empAddress;
	String empDesignation;

	public Employee() {

	}

	public Employee(String id, String empName, String empEmail, Double empContact, String empAddress,
			String empDesignation) {

		this.id = id;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empContact = empContact;
		this.empAddress = empAddress;
		this.empDesignation = empDesignation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public Double getEmpContact() {
		return empContact;
	}

	public void setEmpContact(Double empContact) {
		this.empContact = empContact;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public Object get() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmpId() {
		return empId;
	}
	
	public void setEmpId(String empId) {
		this.empId = empId;
	}
}
