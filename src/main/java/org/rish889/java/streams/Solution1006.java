package org.rish889.java.streams;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/*
    Problem Statement:
    You are tasked with developing a system in Java to manage employee records with the use of Lambda expressions and other Java 8 features.
    The system should be capable of performing operations such as adding, updating, removing, and querying employee details in an efficient manner,
    applying the concepts of functional programming wherever possible.

    Detail:
    The application will have the following functionalities:

    Employee Details: Each employee record will consist of fields such as
        Employee ID
        Name
        Department
        Salary

    Functionality
        Add Employee:
            Allow the user to add a new employee by providing details such as employee ID, name, department, and salary. Validate that the employee ID is unique.

        Update Employee:
            Provide functionality to update an existing employee's details based on their employee ID. The user can update the Name, Department, or Salary.

        Delete Employee:
            Implement a feature where an employee's record can be deleted from the system using their Employee ID.

        Querying Employees:
            Search by Department: Enable users to retrieve a list of employees who are in a specific department using Lambda expressions and Stream API.
            Fetch Top Earners: Fetch the top N employees with the highest salaries using Lambda expressions to sort and limit the result set.
            Average Salary Computation: Compute the average salary of employees department-wise or across the company.
            Notification System: Notify when an employee is added, updated, or removed. This will simulate a simple real-time update feature to the console.

    Requirements:
        Use Java 8 features extensively, specifically Lambda expressions and Stream API for handling collections and performing operations.
        Develop the system as a command-line application where users can enter their choices and provide inputs.
        Data can be stored in-memory using a Collection such as List, Set, or Map; persistence is not required.
        Use functional interfaces and custom predicates where necessary for filtering and comparison.
        By the end of this project, you should demonstrate a good understanding of lambda expressions, streams, and method references in Java 8.
        This task will assess your ability to implement a real-time system and optimize data operations using functional programming constructs.
 */
public class Solution1006 {
    public static void main(String args[]) {
        Solution1006 sol = new Solution1006();
        var employee1 = new Employee("1001", "Rishabh_1", "Dept_1", 10000);
        var employee2 = new Employee("1002", "Rishabh_2", "Dept_1", 20000);
        var employee3 = new Employee("1002", "Rishabh_3", "Dept_1", 20000);
        var employee4 = new Employee("1004", "Rishabh_4", "Dept_2", 40000);
        var employee5 = new Employee("1005", "Rishabh_5", "Dept_1", 50000);

        final EmployeeService employeeService = new EmployeeServiceImpl();
        employeeService.subscribeToNotification(System.out::println);
        employeeService.add(employee1);
        employeeService.add(employee2);
        employeeService.add(employee3);
        employeeService.add(employee4);
        employeeService.add(employee5);

        employeeService.update(new Employee("1002", "Rishabh_3", "Dept_1", 20000));
        employeeService.delete("1002");

        System.out.println(employeeService.searchByDepartment("Dept_1"));
        System.out.println(employeeService.fetchTopEarners(2));
        System.out.println(employeeService.averageSalary(null));
        System.out.println(employeeService.averageSalary("Dept_1"));
    }

    public int solution() {
        return -1;
    }


}

class Employee {
    private final String employee_id;
    private final String name;
    private final String department;
    private final Integer salary;

    public Employee(String employee_id, String name, String department, Integer salary) {
        this.employee_id = employee_id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employee_id, employee.employee_id) && Objects.equals(name, employee.name) && Objects.equals(department, employee.department) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_id, name, department, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id='" + employee_id + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }

    public String getEmployeeId() {
        return employee_id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public Integer getSalary() {
        return salary;
    }
}

interface EmployeeService {
    Employee add(Employee employee);

    Employee fetchEmployeeById(String employeeId);

    Employee update(Employee employee);

    void delete(String employeeId);

    List<Employee> searchByDepartment(String department);

    List<Employee> fetchTopEarners(int n);

    Double averageSalary(String department);

    void subscribeToNotification(Consumer<Map<String, Employee>> consumer);
}

class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeDb = new HashMap<>();
    private final List<Consumer<Map<String, Employee>>> subscribers = new ArrayList<>();

    @Override
    public Employee add(Employee employee) {
        Employee response = employeeDb.putIfAbsent(employee.getEmployeeId(), employee);
        subscribers.forEach(s -> s.accept(employeeDb));
        return response;
    }

    @Override
    public Employee fetchEmployeeById(String employeeId) {
        Employee response = employeeDb.get(employeeId);
        subscribers.forEach(s -> s.accept(employeeDb));
        return response;
    }

    @Override
    public Employee update(Employee employee) {
        Employee response = employeeDb.computeIfPresent(employee.getEmployeeId(), (_, _) -> employee);
        subscribers.forEach(s -> s.accept(employeeDb));
        return response;
    }

    @Override
    public void delete(String employeeId) {
        employeeDb.remove(employeeId);
        subscribers.forEach(s -> s.accept(employeeDb));
    }

    @Override
    public List<Employee> searchByDepartment(String department) {
        return employeeDb.values().stream()
                .filter(e -> e.getDepartment().equals(department))
                .toList();
    }

    @Override
    public List<Employee> fetchTopEarners(int n) {
        return employeeDb.values().stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .limit(n)
                .toList();
    }

    @Override
    public Double averageSalary(String department) {
        return employeeDb.values().stream()
                .filter(e -> Objects.isNull(department) || e.getDepartment().equals(department))
                .collect(Collectors.averagingInt(Employee::getSalary));
    }

    @Override
    public void subscribeToNotification(Consumer consumer) {
        subscribers.add(consumer);
    }
}

