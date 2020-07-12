package com.epam.heroes_game

import com.epam.heroes_game.models.Hero

object GameManager {
  def fight(hero1: Hero, hero2: Hero): Unit = {

    var winner = ""

    while (hero1.isAlive() && hero2.isAlive()) {
      hero1.kick(hero2)
      if (hero2.isAlive())
        hero2.kick(hero1)
    }

    if (hero1.isAlive())
      winner = "First Hero " + hero1.getClass.getSimpleName
    else
      winner = "Second Hero " + hero2.getClass.getSimpleName
    println("The battle is over, " + winner + " won")
  }

}
