package com.epam.heroes_game.models

case class Elf() extends Hero {
  var power:Int = 10
  var hp:Int = 10

  println("Hero " + this.getClass.getSimpleName + " was created with power:" + power + " and hp:" + hp)

  override def kick(hero: Hero): Unit = {
    var kickString:String =  "Elf kicks " + hero.getClass.getSimpleName + " with "
    if (power > hero.power) {
      hero.hp = 0
      kickString.concat(hero.hp.toString)
    } else {
      hero.hp -= 1
      kickString += "1"
    }
    println(kickString + " power")
    if(hero.hp < 0)
      hero.hp = 0
    println(hero.getClass.getSimpleName + " hp dropped to " + hero.hp)

  }
}
