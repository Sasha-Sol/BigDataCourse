package com.epam.friday13th.scala;

import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Stream;

public class DatesStream {
    public static Stream<LocalDate> getDatesStreamBetween(int startYear, int endYear) {
        return LocalDate.of(startYear, Month.JANUARY, 13).datesUntil(LocalDate.of(endYear, Month.DECEMBER, 31));
    }
}
