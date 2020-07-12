package com.epam.friday13th.java;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.stream.Stream;

public class DateRange implements Iterable<LocalDate>{
    private LocalDate startDate;
    private LocalDate endDate;

    DateRange(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Stream<LocalDate> stream() {
        return Stream.iterate(startDate, m -> m.plusMonths(1));
    }

    @Override
    public Iterator<LocalDate> iterator() {
        return stream().iterator();
    }
}
