package com.epam.friday13th.scala

import java.time.{DayOfWeek, LocalDate}

import scala.collection.JavaConverters._

object Friday13thLocator {

  def getSorted13thsFridaysByYearsAndCountFirstImpl(startYear: Int, endYear: Int): List[(Int, Int)] = {
    DatesStream.getDatesStreamBetween(startYear, endYear)
      .iterator()
      .asScala
      .filter(date => date.getDayOfWeek() == DayOfWeek.FRIDAY && date.getDayOfMonth() == 13)
      .map(date => (date.getYear, 1))
      .toList
      .groupBy(_._1)
      .mapValues(d => d.map(x => x._2)
        .reduceLeft(_ + _))
      .toList
      .sortBy(d1 => (d1._2, d1._1))
      .reverse
  }

  def getSorted13thsFridaysByYearsAndCountFinalImpl(startYear: Int, endYear: Int): List[(Int, Int)] = {
    List.range(startYear, endYear)
      .map(
        year => (year, (1 to 12)
          .count(LocalDate.of(year, _, 13).getDayOfWeek == DayOfWeek.FRIDAY)))
      .sortBy(d1 => (d1._2, d1._1))
      .reverse
  }
}
