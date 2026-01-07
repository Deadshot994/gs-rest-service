package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {

    private Employees employees;

    public EmployeeManager() {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(
                "E001",
                "John",
                "Doe",
                "john.doe@example.com",
                "Software Engineer"
        ));
        employeeList.add(new Employee(
                "E002",
                "Jane",
                "Smith",
                "jane.smith@example.com",
                "Product Manager"
        ));
        employeeList.add(new Employee(
                "E003",
                "Alice",
                "Brown",
                "alice.brown@example.com",
                "Data Analyst"
        ));

        this.employees = new Employees(employeeList);
    }

    public Employees getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.getEmployees().add(employee);
    }
}
