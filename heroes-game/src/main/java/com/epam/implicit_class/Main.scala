package com.epam.implicit_class

object Main {
  def main(args: Array[String]): Unit = {

    import com.epam.implicit_class.Helpers._
    println("checking if this is email:" + "test@test.com".isEmail)
    println("checking if this is email:" + "Robert Cecil Martin".isEmail)
    println("checking if this is email:" + "@test.com".isEmail)

  }

}
