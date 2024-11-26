package com.example.java8Practise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee{
		private String name;
		private int id;
		private String location;
		private String gender;
		private int age;
		private double salary ;
		
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public Employee(String name, int id, String location, String gender,int age) {
			super();
			this.name = name;
			this.id = id;
			this.location = location;
			this.gender = gender;
			this.age=age;
		}
		@Override
		public String toString() {
			return "Employee [name=" + name + 
					", id=" + id + 
					", location=" +
					location + 
					", gender=" +
					gender + "]";
		}
		
		
	public static void main(String[] args) {
	
		List<Employee> emplist= Arrays.asList(
				
				new Employee("vaibhav",4,"Pune","Male",20),
				new Employee("vaibhavi",2,"Mumbai","Female",34),
				new Employee("Suraj",3,"Hydrabad","Male",18),
				new Employee("somaya",7,"telangana","Female",40),
				new Employee("Raju",10,"Surat","male",50)
				
				);
		
	//Map<String, Long>name=	emplist.stream().collect(Collectors.groupingBy(Employee::getGender),Collectors.counting());
		
		// Problem Statment: Sort the employee based on age
		List<Employee>sortedbasedongender= emplist.stream()
		.sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());

		sortedbasedongender.forEach(ele-> System.out.println("Age "+ele.getAge()+ "Name:"+ele.getName()));
		
		emplist.stream().filter(e-> e.getAge()>25).collect(Collectors.groupingBy(Employee::getId));
	}
	
}	