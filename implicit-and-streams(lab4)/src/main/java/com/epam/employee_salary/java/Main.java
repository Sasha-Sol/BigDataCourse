package com.epam.employee_salary.java;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = IntStream.range(1,15).mapToObj(i -> new Employee(10000.0 + i*1000.0)).collect(Collectors.toList());

        employees.stream()
                .collect(Collectors.groupingBy(emp -> Seniority.getBySalary(emp.getSalary())))
                .entrySet()
                .forEach(System.out::println);

        employees.stream()
                .collect(Collectors.groupingBy(emp -> Seniority.getBySalary(emp.getSalary()),Collectors.counting()))
                .entrySet()
                .forEach(System.out::println);

        employees.stream()
                .collect(Collectors.groupingBy(emp -> Seniority.getBySalary(emp.getSalary()),Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
                .entrySet()
                .forEach(System.out::println);

    }
}
