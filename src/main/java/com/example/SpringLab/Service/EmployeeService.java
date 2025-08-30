package com.example.SpringLab.Service;

import com.example.SpringLab.entity.Employee;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service


public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();
    private int nextId = 1;

    // CREATE - Add new employee
    public Employee createEmployee(String name, String email, int salary, String department) {
        Employee employee = new Employee(nextId++, name, email, salary, department);
        employees.add(employee);
        System.out.println("Employee created: " + employee);
        return employee;
    }

    // CREATE
    public Employee createEmployee(Employee employee) {
        employee.setId(nextId++);
        employees.add(employee);
        System.out.println("Employee created: " + employee);
        return employee;
    }

    //READ
    public Optional<Employee> getEmployeeById(int id) {
        return employees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst();
    }

    // READ (LIST ALL EMPLOYEES))
    public List<Employee> listAllEmployees() {
        System.out.println("Listing all employees:");
        employees.forEach(System.out::println);
        return new ArrayList<>(employees);
    }

    // UPDATE
    public Employee updateEmployee(int id, String name, String email, int salary, String department) {
        Optional<Employee> existingEmp = getEmployeeById(id);
        if (existingEmp.isPresent()) {
            Employee employee = existingEmp.get();
            employee.setName(name);
            employee.setEmail(email);
            employee.setSalary(salary);
            employee.setDepartment(department);
            System.out.println("Employee updated: " + employee);
            return employee;
        }
        System.out.println("Employee with ID " + id + " not found");
        return null;
    }

    // DELETE
    public boolean deleteEmployee(int id) {
        boolean removed = employees.removeIf(emp -> emp.getId() == id);
        if (removed) {
            System.out.println("Employee with ID " + id + " deleted");
        } else {
            System.out.println("Employee with ID " + id + " not found");
        }
        return removed;
    }

    // DELETE
    public boolean deleteEmployee(Employee employee) {
        boolean removed = employees.remove(employee);
        if (removed) {
            System.out.println("Employee deleted: " + employee);
        } else {
            System.out.println("Employee not found in list");
        }
        return removed;
    }

    //  method to get count of employees
    public int getEmployeeCount() {
        return employees.size();
    }

    // Utility method to check if employee exists
    public boolean employeeExists(int id) {
        return employees.stream().anyMatch(emp -> emp.getId() == id);
    }
}
