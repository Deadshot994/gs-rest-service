package com.example.restservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * Test 1: Test that the initial employee list is not empty
 * Test 2: Test that adding an employee increases the list size
 * Test 3: Test GET returns correct employee data
 * Test 4: Test POST adds correct employee details
 * Test 5: Test duplicate employee IDs are allowed (current behavior)
 */

public class EmployeeManagerTest {

    //Test 1
    @Test
    public void testInitialEmployeeList() {
        EmployeeManager manager = new EmployeeManager();
        Employees employees = manager.getEmployees();

        assertNotNull(employees);
        assertEquals(3, employees.getEmployees().size());
    }

    //Test 2
    @Test
    public void testAddEmployee() {

        EmployeeManager manager = new EmployeeManager();

        Employee newEmployee = new Employee(
                "E004",
                "Bob",
                "Taylor",
                "bob.taylor@example.com",
                "DevOps Engineer"
        );

        manager.addEmployee(newEmployee);

        assertEquals(4, manager.getEmployees().getEmployees().size());
    }

    //Test 3
    @Test
    public void testEmployeeDataIntegrity() {
        EmployeeManager manager = new EmployeeManager();
        Employees employees = manager.getEmployees();

        Employee firstEmployee = employees.getEmployees().get(0);

        assertEquals("E001", firstEmployee.getEmployee_id());
        assertEquals("John", firstEmployee.getFirst_name());
        assertEquals("Doe", firstEmployee.getLast_name());
        assertEquals("john.doe@example.com", firstEmployee.getEmail());
        assertEquals("Software Engineer", firstEmployee.getTitle());
    }

    //Test 4
    @Test
    public void testAddedEmployeeDataIsCorrect() {
        EmployeeManager manager = new EmployeeManager();

        Employee newEmployee = new Employee(
                "E005",
                "Sara",
                "Williams",
                "sara.williams@example.com",
                "QA Engineer"
        );

        manager.addEmployee(newEmployee);

        Employee addedEmployee = manager.getEmployees().getEmployees().get(3);

        assertEquals("E005", addedEmployee.getEmployee_id());
        assertEquals("Sara", addedEmployee.getFirst_name());
        assertEquals("Williams", addedEmployee.getLast_name());
        assertEquals("sara.williams@example.com", addedEmployee.getEmail());
        assertEquals("QA Engineer", addedEmployee.getTitle());
    }

    //Test 5
    @Test
    public void testDuplicateEmployeeIdAllowed() {
        EmployeeManager manager = new EmployeeManager();

        Employee duplicateEmployee = new Employee(
                "E001",   // duplicate ID
                "Mike",
                "Johnson",
                "mike.johnson@example.com",
                "Intern"
        );
        manager.addEmployee(duplicateEmployee);

        assertEquals(4, manager.getEmployees().getEmployees().size());
    }
}
