package com.example.java8Practise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Programing {

	public static void main(String[] args) {
		List<Student> studentList = Stream.of(
				new Student(1, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 122,
						Arrays.asList("+912632632782", "+1673434729929")),
				new Student(2, "Pulkit", 56, "Male", "Computer Engineering", "Delhi", 67,
						Arrays.asList("+912632632762", "+1673434723929")),
				new Student(3, "Ankit", 25, "Female", "Mechanical Engineering", "Kerala", 164,
						Arrays.asList("+912632633882", "+1673434709929")),
				new Student(4, "Satish Ray", 30, "Male", "Mechanical Engineering", "Kerala", 26,
						Arrays.asList("+9126325832782", "+1671434729929")),
				new Student(5, "Roshan", 23, "Male", "Biotech Engineering", "Mumbai", 12,
						Arrays.asList("+012632632782")),
				new Student(6, "Chetan", 24, "Male", "Mechanical Engineering", "Pune", 90,
						Arrays.asList("+9126254632782", "+16736784729929")),
				new Student(7, "Arun", 26, "Male", "Electronics Engineering", "Pune", 324,
						Arrays.asList("+912632632782", "+1671234729929")),
				new Student(8, "Nam", 31, "Male", "Computer Engineering", "Pune", 433,
						Arrays.asList("+9126326355782", "+1673434729929")),
				new Student(9, "Sonu", 27, "Female", "Computer Engineering", "Pune", 7,
						Arrays.asList("+9126398932782", "+16563434729929", "+5673434729929")),
				new Student(10, "Shubham", 26, "Male", "Instrumentation Engineering", "Mumbai", 98,
						Arrays.asList("+912632646482", "+16734323229929")))
				.collect(Collectors.toList());

		// 1) student in between rank 50 and 100
		List<Student> sudentbyRank = studentList.stream()
				.filter(student -> student.getRank() > 50 & student.getRank() < 100).collect(Collectors.toList());

		// System.out.println(sudentbyRank);
		// 2) studentList from Pune & Mumbai and sort them bt theirname
		List<Student> studentFromPuneandSortByName = studentList.stream()
				.filter(student -> student.getCity().equals("Pune") || student.getCity().equals("Mumbai"))
				.sorted(Comparator.comparing(Student::getFirstName, Comparator.reverseOrder()))
				.collect(Collectors.toList());
		;

		// System.out.println(studentFromPuneandSortByName);

		// 3) find department list and and find distinct department

		List<String> availableDeprtname = studentList.stream().map(Student::getDept).collect(Collectors.toList());
		/*
		 * studentList .stream().map(Student::getDept).distinct().
		 * collect(Collectors.toList());
		 */
		// System.out.println(availableDeprtname);

		Set<String> distinctDepartment = availableDeprtname.stream().collect(Collectors.toSet());
		// System.out.println(" Departments are:"+distinctDepartment);
	
		// 4) find the unique Department from the list 
		
		// best Solution
		Set<String> uniqueDept = studentList.stream().map(Student::getDept).distinct().collect(Collectors.toSet());
	//	System.out.println(uniqueDept);
    
		List<List<String>> contactList = studentList.stream().map(Student::getContacts).distinct().collect(Collectors.toList());
	//	System.out.println("ConctList: "+contactList);
		
	/*	onetoOne--> map
		onetoMany-->flatmap */
		
	// 5) find the conctList 	
		List<String> contactListbyFlatMap = studentList.stream().flatMap(student -> student.getContacts().stream())
				.distinct().
				collect(Collectors.toList());
	//	System.out.println("ContactList by flatMap "+contactListbyFlatMap);
		
	// 6) find the department whos having maximum student
	Map.Entry<String, Long>	result =studentList.stream().collect(Collectors.groupingBy(Student::getDept,Collectors.counting()))
		.entrySet().stream().max(Map.Entry.comparingByValue()).get();
	//	System.out.println(result);
	// 7) find the average age of male and female student	
		
	Map<String,Double>	averageageofmaleandfemale=studentList.stream().collect(Collectors.groupingBy(Student::getGender,Collectors.averagingInt(Student::getAge)));
	//	System.out.println(averageageofmaleandfemale+"<==:is the averageageofmaleandfemale");
		
	//	8) find the highest rank in each department 
		
//		Map<String,Optional<Student>> higestrankineachdept= studentList.stream().collect(Collectors.groupingBy(Student::getDept),Collectors.minBy(Comparator.comparing(Student::getRank)));
	//	9) find the student who has second rank 
		 	 Student student=studentList.stream()
		.sorted(Comparator.comparing(Student::getRank))
		.skip(1)
		.findFirst().get();
		
		 	 System.out.println(student);
 	}
}