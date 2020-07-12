package com.epam.friday13th.java;

public class Main {
    public static void main(String[] args) {

        Friday13Locator.getSortedFridaysBy(2000,2019).forEach((k,v) -> System.out.println(k.toString() + "," + v));

    }


}
