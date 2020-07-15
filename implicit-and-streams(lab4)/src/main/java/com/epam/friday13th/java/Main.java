package com.epam.friday13th.java;

public class Main {
    public static void main(String[] args) {

        Friday13Locator.getSorted13thsFridaysByYearsAndCountFinalImplementation(2000,2019).entrySet().forEach(entry -> System.out.println(entry.toString()));

    }


}
