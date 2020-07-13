package com.epam.employee_salary.java;

public enum Seniority {
    JUNIOR,
    MIDDLE,
    SENIOR,;

    public static Seniority getEmployeeSeniority(Employee emp) {
        double empSalary = emp.getSalary();
        if(empSalary < 14000.0)
            return Seniority.JUNIOR;
        else if(empSalary < 21000.0)
            return Seniority.MIDDLE;
        else
            return Seniority.SENIOR;

    }


}
