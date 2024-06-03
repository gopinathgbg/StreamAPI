package com.example.java8Practise;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.java8Practise.*;

public class JavaStreamExercise {

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
		
		
		//1) Problem: Given a list of integers, filter out the even numbers and collect the result into a list.
		
		List<Integer> numbers =Arrays.asList(1,3,54,7,8,20,21,77,88,66);

		List<Integer> oddNumbers=numbers.stream().filter(n -> n%2!=0)
				.sorted()
				.collect(Collectors.toList());
		// System.out.println(oddNumbers);
	
		//2)Problem: Given a list of strings, convert each string to its uppercase form and collect the result into a list.
		
		List<String> listOfStrings= Arrays.asList("Banana","Apple","Orange");
	List<String>toUpperCase=	listOfStrings.stream().map(String::toUpperCase).collect(Collectors.toList());	
	//	System.out.println(toUpperCase);
	
		//3) Problem: Given a list of lists of strings, flatten the list into a single list of strings.
		
		List<List<String>> list1= Arrays.asList(
				Arrays.asList("a","b"),
				Arrays.asList("c","d"),
				Arrays.asList("e","f")
				);
		
		List<String> listString = list1.stream().flatMap(List::stream).collect(Collectors.toList());
	//	System.out.println(listString);
	// 4) Problem: Given a list of strings, group them by their length.	
		
		List<String> listofStrings= Arrays.asList("Gopinath","Girish","Ankush","Akshay","Vaibhav");
	 Map<Integer, List<String>> groupedByLen=	listofStrings.stream().collect(Collectors.groupingBy(String::length));
	// System.out.println("groupedByLen"+groupedByLen);
	
	 
	 //Extra for Student class
	 
	Map<String,List<Student>>studentMap= studentList.stream().collect(Collectors.groupingBy(Student::getGender));
//	 System.out.println(studentMap);
		
		//5) Problem: Given a list of integers, find the maximum value.
	 List<Integer> num= Arrays.asList(1,7,4,8,3,22,90,34,61,52);
	Optional<Integer> max= num.stream().max(Integer::compareTo);
//	 max.ifPresent(System.out::println); 
	
	 //6) Problem: Given a list of integers, find the sum of all elements.
	 List<Integer> nums= Arrays.asList(1,7,4,8,3,2);
	 int sum= nums.stream().mapToInt(Integer::intValue)
              .sum();
//	 System.out.println(sum);
	 
	 List<Double> doublenums= Arrays.asList(1.32,7.0,4.1,8.0,3.3,2.9);
	 double sumofdoubles= doublenums.stream().mapToDouble(Double::doubleValue).sum();
//	 System.out.println(sumofdoubles);
	
	 // 7) Problem: Given a list of strings, check if any string starts with the letter "a".
	 
	 List<String> names= Arrays.asList("Ashwini","Akash","Narayan","Girija","dhyanchand");
	boolean b=names.stream().anyMatch(a -> a.startsWith("S"));
	
	// System.out.println(b);
	
	//Complex Level:
	// 8) Problem: Given a list of people, group them by their age and then partition them into minors and adults.
	 
	 List<Person> people = Arrays.asList(
	            new Person("Alice", 30),
	            new Person("Bob", 20),
	            new Person("Charlie", 15),
	            new Person("David", 35),
	            new Person("Eve", 25)
	        );
	 
	Map<Integer,List<Person>> groupByAge= people.stream().collect(Collectors.groupingBy(Person::getAge));
	 Map <Boolean,List<Person> >partitionedByAge=people.stream().collect(Collectors.partitioningBy(p ->p.getAge() >=18));
	System.out.println(partitionedByAge);
	
	// Problem: Create a method to find the longest string in a list using a custom stream operation.
	
	List<String> strings= Arrays.asList("Gopinath","GirishPatil","Ankush","Akshay","Vishal");
   Optional<String> longestName=	strings.stream().reduce((s1,s2) -> s1.length() >s2.length() ? s1:s2);
	longestName.ifPresent(System.out::println);
	} 

}
