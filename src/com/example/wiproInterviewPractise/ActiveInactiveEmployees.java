package com.example.wiproInterviewPractise;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee2 {
    private String name;
    private String department;
    private int salary;
    private boolean active;

    public Employee2(String name, String department, int salary, boolean active) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.active = active;
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

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', department='" + department + "', salary=" + salary + ", active=" + active + "}";
    }
}

public class ActiveInactiveEmployees {
    public static void main(String[] args) {
        // Sample list of employees
        List<Employee2> employees = Arrays.asList(
            new Employee2("Alice", "HR", 50000, true),
            new Employee2("Bob", "HR", 60000, false),
            new Employee2("Charlie", "IT", 75000, true),
            new Employee2("Dave", "IT", 80000, false),
            new Employee2("Eve", "Finance", 90000, true),
            new Employee2("Frank", "Finance", 95000, false)
        );

        // Partition employees into active and inactive
        Map<Boolean, List<Employee2>> partitionedEmployees = employees.stream()
            .collect(Collectors.partitioningBy(Employee2::isActive));

        // Get active and inactive employees
        List<Employee2> activeEmployees = partitionedEmployees.get(true);
        List<Employee2> inactiveEmployees = partitionedEmployees.get(false);

        // Print active employees
        System.out.println("Active Employees:");
        activeEmployees.forEach(System.out::println);

        // Print inactive employees
        System.out.println("Inactive Employees:");
        inactiveEmployees.forEach(System.out::println);
        
     // Group employees by department
        Map<String, List<Employee2>> employeesByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee2::getDepartment));

        employeesByDept.forEach((department, employeeList) -> {
            System.out.println("Department: " + department);
            employeeList.forEach(System.out::println);
        });
    }
}
