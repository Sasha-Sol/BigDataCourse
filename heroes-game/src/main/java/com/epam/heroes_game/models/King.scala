package com.epam.heroes_game.models

case class King() extends Hero {
  val rnd = new scala.util.Random
  var power:Int = getKnightRandomNumber
  var hp:Int = getKnightRandomNumber

  println("Hero " + this.getClass.getSimpleName + " was created with power:" + power + " and hp:" + hp)

  override def kick(hero: Hero): Unit = {
    println("King kicks " + hero.getClass.getSimpleName + " with " + power + " power")

    hero.hp -= power
    if(hero.hp < 0)
      hero.hp = 0
    println(hero.getClass.getSimpleName + " hp dropped to " + hero.hp)
  }

  def getKnightRandomNumber:Int = 5 + rnd.nextInt(10+1)
}
