package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class SteamFilterwithPredicate {

	public static void main(String[] args) {
	
	/*	Poblem statement 1: Given a list of strings, filter out strings that are less than 4 characters long 
		and collect the remaining strings into a new list.
	*/	
		List<String> names=Arrays.asList("Gopinath", "Girish","vaibhav","Sonali","Vinayak","Meenal","om","sai");
		 List<String>newList= names.stream().filter(word -> word.length() >=4).collect(Collectors.toList());
		 System.out.println("List :"+names );
		System.out.println("New List after filtering 4 char strings"+newList);
		
	/*	Poblem statement 2 : Given a list of Person objects, filter out persons who are younger than 18 
		and live in "Pune". Collect the remaining persons into a new list.
	*/
		List<Person> people = Arrays.asList(
			    new Person("Alice", "Pune", 20),
			    new Person("Bob", "Mumbai", 17),
			    new Person("Charlie", "Pune", 18),
			    new Person("David", "Pune", 25),
			    new Person("Girish", "Dhule",27)
			    
			);
		List<Person>younerpersonNotfromPune=people.stream().filter(person -> person.getAge()>=18 && "Pune".equals(person.getAddress())).collect(Collectors.toList());
		System.out.println();
		System.out.println(younerpersonNotfromPune);
		
		// Poblem statement 3 : Persons from Mumbai

	List<Person> fromMumbai= people.stream().filter(person -> person.getAddress().equals("Mumbai")).collect(Collectors.toList());
	System.out.println("mumbai Wale log "+fromMumbai);
	
	
	//Poblem statement 4 :
	List<Employee> employees = Arrays.asList(
		    new Employee("John", 60000),
		    new Employee("Jane", 45000),
		    new Employee("Mark", 70000),
		    new Employee("Sarah", 40000)
		);
	
	List<String>empsalabove50k= employees.stream()
			.filter(emp ->emp.getSalary() > 50000 )
			.map(Employee::getName).collect(Collectors.toList());
	
	System.out.println("empsalabove50k"+empsalabove50k); 
	
	// *************Stream with predicate and use of Optional**************************
	
	/* Poblem statement 5 :Given a list of integers, find the first number that is greater than 100. 
	If no such number exists, return Optional.empty(). */
	
	List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110);
	Optional<Integer> firstGreaterThan100 = numbers.stream()
	                                               .filter(n -> n > 100)
	                                               .findFirst();
/*	Given a map of student names and their scores, filter out the students who scored less than 50
	and collect the remaining entries into a new map. */
	
	Map<String, Integer> studentScores = new HashMap<>();
	studentScores.put("Dimpi", 90);
	studentScores.put("Sona", 45);
	studentScores.put("Nayna", 75);
	studentScores.put("sham", 30);

	Map<String,Integer>StudentWhoScoremorethatn50 =studentScores.entrySet().stream().filter(entry -> entry.getValue() >=50).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue) );
	System.out.println("StudentWhoScoremorethatn50"+ StudentWhoScoremorethatn50);
	
	}

}