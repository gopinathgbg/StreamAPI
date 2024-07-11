package com.example;

public class Employee {

private String name;
private int salary;
private String Dept;
private String location;

public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getDept() {
	return Dept;
}
public void setDept(String dept) {
	Dept = dept;
}

public String getName() {
	return name;
}
public Employee(String name, int salary, String dept, String location) {
	super();
	this.name = name;
	this.salary = salary;
	Dept = dept;
	this.location = location;
}
public Employee(String name, int salary) {
	super();
	this.name = name;
	this.salary = salary;
	
}
public void setName(String name) {
	this.name = name;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
@Override
public String toString() {
	return "Employee [name=" + name + ", salary=" + salary + ", Dept=" + Dept + ", location=" + location
			+ ", getLocation()=" + getLocation() + ", getDept()=" + getDept() + ", getName()=" + getName()
			+ ", getSalary()=" + getSalary() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}


}
