package com.epam.employee_salary.java;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

public enum Seniority {
    JUNIOR(0, 14000),
    MIDDLE(14000,21000),
    SENIOR(21000,Integer.MAX_VALUE);


    private final int min;
    private final int max;

    Seniority(int min, int max) {
        this.min = min;
        this.max = max;
    }


    public static Seniority getBySalary(double salary) {
        return Arrays.stream(values()).filter(seniority -> seniority.min <= salary && seniority.max > salary).findAny().get();

    }


}
