package com.example.wiproInterviewPractise;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}

public class MinMaxSalary {
    public static void main(String[] args) {
        // Sample list of employees
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 50000),
            new Employee("Bob", 60000),
            new Employee("Charlie", 75000),
            new Employee("Dave", 80000),
            new Employee("Eve", 90000)
        );

        // Find the minimum salary
        Optional<Employee> minSalaryEmployee = employees.stream().min((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));

        // Find the maximum salary
        Optional<Employee> maxSalaryEmployee = employees.stream().max((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));

        // Print the results
        if (minSalaryEmployee.isPresent() && maxSalaryEmployee.isPresent()) {
            System.out.println("Employee with Minimum Salary: " + minSalaryEmployee.get().getSalary());
            System.out.println("Employee with Maximum Salary: " + maxSalaryEmployee.get().getSalary());
        } else {
            System.out.println("List of employees is empty.");
        }
    }
}
