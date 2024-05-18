package com.example;

import java.util.Arrays;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;


public class SteamTutorialExample {

	public static void main(String[] args) {
	
List<Integer> list= Arrays.asList(35,50,100,90,78,20,34);

// 1) sort array using stream
List<Integer> filteredList=list.stream().sorted().collect(Collectors.toList());

// 2) find even numbers using stream 
List<Integer> evenNumbers=list.stream().filter(i-> i%2==0).collect(Collectors.toList());
// 3) find odd numbers using stream
List<Integer> oddNumbers=list.stream().filter(i-> i%2!=0).collect(Collectors.toList());

System.out.println(filteredList);
System.out.println(evenNumbers);
System.out.println(oddNumbers);

List<Integer> marks=Arrays.asList(35,50,62,90,30,99,73,66,93);

// 4) give extra 5 marks to each student who have passed the exam
List<Integer> fiveExtramarksStudent=list.stream().filter(i-> i>35).map(j ->j+5).collect(Collectors.toList());
System.out.println(fiveExtramarksStudent);

// 5) 

	}

}