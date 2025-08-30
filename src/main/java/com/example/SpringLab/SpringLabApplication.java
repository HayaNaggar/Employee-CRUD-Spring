package com.example.SpringLab;

import com.example.SpringLab.entity.Employee;
import com.example.SpringLab.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLabApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(SpringLabApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Demo of CRUD operations
        System.out.println("=== Employee CRUD Demo ===");

        // CREATE operations
        Employee emp1 = employeeService.createEmployee("Albus Dumbledore", "dumbledore@example.com", 50000, "IT");
        Employee emp2 = employeeService.createEmployee("Harry Potter", "Harry@example.com", 60000, "HR");
        Employee emp3 = employeeService.createEmployee("Hermione Granger", "Hermione@example.com", 55000, "Finance");

        System.out.println("\n=== List All Employees ===");
        employeeService.listAllEmployees();

        System.out.println("\n=== Update Employee ===");
        employeeService.updateEmployee(1, "Dumbledore  Updated", "dumbledore.updated@example.com", 55000, "IT");

        System.out.println("\n=== List After Update ===");
        employeeService.listAllEmployees();

        System.out.println("\n=== Deletr Employee ===");
        employeeService.deleteEmployee(2);

        System.out.println("\n=== List After Delete ===");
        employeeService.listAllEmployees();

        System.out.println("\nTotal employees: " + employeeService.getEmployeeCount());
    }
}

