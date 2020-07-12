package com.epam.heroes_game.traits

import com.epam.heroes_game.RandomValue

trait RandomKickHero{
  val from:Int
  val to:Int

  def randomKick(attacker:Hero, hero: Hero): Unit = {
    val kickPower:Int = RandomValue.fromTo(from, to)
    println(attacker.getClass.getSimpleName + " kicks " + hero.getClass.getSimpleName + " with random " + kickPower + " power")
    hero.hp -= kickPower
    if(hero.hp < 0)
      hero.hp = 0
    println(hero.getClass.getSimpleName + " hp dropped to " + hero.hp)
  }
}
