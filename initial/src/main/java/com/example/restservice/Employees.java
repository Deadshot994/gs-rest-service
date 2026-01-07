package com.example.restservice;

import java.util.List;

public class Employees {

    private List<Employee> Employees;

    public Employees(List<Employee> employees) {
        this.Employees = employees;
    }

    public List<Employee> getEmployees() {
        return Employees;
    }

    public void setEmployees(List<Employee> employees) {
        Employees = employees;
    }
}
