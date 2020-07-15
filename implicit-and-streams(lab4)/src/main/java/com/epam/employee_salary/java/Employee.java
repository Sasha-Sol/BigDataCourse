package com.epam.employee_salary.java;


public class Employee {
    private double salary;

    Employee(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return "Employee with salary:" + getSalary();
    }

}
