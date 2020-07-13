package com.epam.employee_salary.scala

object Main {
  def main(args: Array[String]): Unit = {

    var employees:List[Employee] = List.tabulate(15)(n => Employee(salary = 10000+n*1500))
    println(employees)
  }
}
