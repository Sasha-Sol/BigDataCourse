package com.epam.heroes_game.models

case class Knight() extends Hero() {
  val rnd = new scala.util.Random
  var power = getKnightRandomNumber
  var hp = getKnightRandomNumber

  println("Hero " + this.getClass.getSimpleName + " was created with power:" + power + " and hp:" + hp)

  override def kick(hero: Hero): Unit = {
    println("Knight kicks " + hero.getClass.getSimpleName + " with " + power + " power")
    //TODO change
    hero.hp -= power
    if(hero.hp < 0)
      hero.hp = 0
    println(hero.getClass.getSimpleName + " hp dropped to " + hero.hp)
  }

  def getKnightRandomNumber:Int = 2 + rnd.nextInt(10+1)
}
