package com.epam.friday13th.java;

import java.time.*;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Friday13Locator {

    public static Map<Integer, Long> getSorted13thsFridaysByYearsAndCountFirstImplementation(int startYear, int endYear) {

        return LocalDate.of(startYear, Month.JANUARY, 13)
                .datesUntil(LocalDate.of(endYear, Month.DECEMBER, 31))
                .filter(date -> date.getDayOfWeek() == DayOfWeek.FRIDAY && date.getDayOfMonth() == 13)
                .map(d -> Map.entry(d.getYear(), 1))
                .collect(
                        Collectors.groupingBy(
                                Map.Entry::getKey, Collectors.counting()
                        )
                )
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByKey().reversed())
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public static Map<Integer, Long> getSorted13thsFridaysByYearsAndCountFinalImplementation(int startYear, int endYear) {
        return LocalDate.of(startYear, Month.JANUARY, 13)
                .datesUntil(LocalDate.of(endYear, Month.DECEMBER, 14), Period.ofMonths(1))
                .filter(date -> date.getDayOfWeek() == DayOfWeek.FRIDAY).collect(
                        Collectors.groupingBy(
                                LocalDate::getYear, Collectors.counting()
                        )
                ).entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByKey().reversed())
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (oldValue, newValue) -> oldValue, LinkedHashMap::new));


    }
}
