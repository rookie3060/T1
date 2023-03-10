package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String name;
@JoinColumn(name = "department_id")
@OneToOne
private Department department;
public Department getDepartment() {
	return department;
}
public void setDepartment(Department department) {
	this.department = department;
}
public int getId() {
	return id;
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(int id, String name) {
	super();
	this.id = id;
	this.name = name;
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



}
