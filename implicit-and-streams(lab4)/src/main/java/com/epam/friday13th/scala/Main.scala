package com.epam.friday13th.scala


object Main {
  def main(args: Array[String]): Unit = {
    Friday13thLocator.getSorted13thsFridaysByYearsAndCountFinalImpl(2000, 2019).foreach(println)
  }
}
