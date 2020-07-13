package com.epam.employee_salary.scala

object SENIORITY extends Enumeration {
  val JUNIOR, MIDDLE, SENIOR = Value

  def getSeniority(employee: Employee):Value = employee match {
    case e: Employee if e.salary > 21000 => SENIORITY.SENIOR
    case e: Employee if e.salary > 14000 => SENIORITY.MIDDLE
    case e: Employee => SENIORITY.JUNIOR
  }
}
