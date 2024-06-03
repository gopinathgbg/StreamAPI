package com.example.wiproInterviewPractise;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

class Employee1 {
    private String name;
    private String department;
    private int salary;

    public Employee1(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', department='" + department + "', salary=" + salary + "}";
    }
}

public class MaxSalaryByDepartment {
    public static void main(String[] args) {
        // Sample list of employees
        List<Employee1> employees1 = Arrays.asList(
            new Employee1("Alice", "HR", 50000),
            new Employee1("Bob", "HR", 60000),
            new Employee1("Charlie", "IT", 75000),
            new Employee1("Dave", "IT", 80000),
            new Employee1("Eve", "Finance", 90000),
            new Employee1("Frank", "Finance", 95000)
        );

        // Group employees by department and find the employee with the max salary in each department
        Map<String, Optional<Employee1>> maxSalaryByDept = employees1.stream()
            .collect(Collectors.groupingBy(
                Employee1::getDepartment,
                Collectors.maxBy(Comparator.comparingInt(Employee1::getSalary))
            ));

        // Print the results
        maxSalaryByDept.forEach((department, employee) -> 
            System.out.println("Department: " + department + ", Employee with Max Salary: " + employee.orElse(null))
        );
    }
}
