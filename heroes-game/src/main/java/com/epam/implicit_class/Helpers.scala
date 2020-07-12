package com.epam.implicit_class

object Helpers {
  implicit class StringEmailExtension(val string:String) {

    import java.util.regex.Pattern

    val regex:String = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"
    val pattern: Pattern = Pattern.compile(regex)

    def isEmail: Boolean = {
      val matcher = pattern.matcher(string)
      matcher.matches()
    }

  }
}


