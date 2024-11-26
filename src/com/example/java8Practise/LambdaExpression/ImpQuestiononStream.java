package com.example.java8Practise.LambdaExpression;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import com.example.*;

import com.example.Employee;

public class ImpQuestiononStream {

	public static void main(String[] args) {
		List<Integer> nums= Arrays.asList(1,2,5,78,9,0,2,4);
		
       nums.stream().filter(n -> n> 4).sorted().forEach(t -> System.out.println(t));

       // 1) find the frequency of each character in given string 
	  String name="Nitin";
	  
	Map<String,Long> frequncyofEachChar=  Arrays.stream(name.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    
	System.out.println(frequncyofEachChar);
	
	// 2) Assume that you have list of employees in various department, find the highest paying empl from each department.
	
	List<Employee> emplist=Arrays.asList(
			new Employee("Nitin", 30000,"ERD","Pune"),
			new Employee("Nitin", 79000,"IT","Mumbai"),
			new Employee("Nitin", 35000,"Mechanical","Washim"),
			new Employee("Nitin", 80000,"IT","Nagpur"),
			new Employee("Nitin", 38000,"Account","Kerala"),
			new Employee("Nitin", 46000,"Admin","UP"),
			new Employee("Nitin", 88000,"Admin","MP"),
			new Employee("Nitin", 20000,"HR","Hyadrabad"),
			new Employee("Nitin", 61000,"HR","Chennai")
		);
	emplist.stream().collect(Collectors.groupingBy(Employee::getDept));
	
	}

}
