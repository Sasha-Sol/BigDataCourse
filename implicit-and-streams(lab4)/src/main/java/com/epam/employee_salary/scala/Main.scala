package com.epam.employee_salary.scala

object Main {
  def main(args: Array[String]): Unit = {

    var employees:List[Employee] = List.tabulate(15)(n => Employee(salary = 10000+n*1500))

    employees.map(emp => (SENIORITY.getSeniority(emp), emp))
      .groupBy(_._1)
      .mapValues(_.unzip._2)
      .foreach(println)

    employees.map(emp => (SENIORITY.getSeniority(emp), emp))
      .groupBy(_._1)
      .mapValues(_.unzip._2)
      .map(tuple1 => (tuple1._1, tuple1._2.size))
      .foreach(println)

    employees.map(emp => (SENIORITY.getSeniority(emp), emp))
      .groupBy(_._1)
      .mapValues(_.unzip._2)
      .map(tuple1 => (tuple1._1, tuple1._2.maxBy(_.salary)))
      .foreach(println)


  }
}
