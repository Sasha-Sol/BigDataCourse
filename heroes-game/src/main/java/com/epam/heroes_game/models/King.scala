package com.epam.heroes_game.models

import com.epam.heroes_game.RandomValue
import com.epam.heroes_game.traits.{Hero, RandomKickHero}

case class King() extends RandomKickHero with Hero {
  val from:Int = 5
  val to:Int = 15

  var power = RandomValue.fromTo(from,to)
  var hp = RandomValue.fromTo(from,to)

  println("Hero " + this.getClass.getSimpleName + " was created with power:" + power + " and hp:" + hp)

  override def kick(hero: Hero): Unit = randomKick(this, hero)
}
