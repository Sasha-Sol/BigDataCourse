package com.epam.friday13th.scala

import java.time.DayOfWeek

import scala.collection.JavaConverters._

object Friday13thLocator {

  def getSorted13thsFridaysByYearsAndCount(startYear: Int, endYear: Int): List[(Int, Int)] = {
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
}
