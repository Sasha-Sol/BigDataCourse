package com.epam.heroes_game.models

case class Hobbit() extends Hero {
  var power = 0
  var hp = 3
  println("Hero " + this.getClass.getSimpleName + " was created with power:" + power + " and hp:" + hp)

  override def kick(hero: Hero): Unit = {

    println("Hobbit start crying")
  }
}
