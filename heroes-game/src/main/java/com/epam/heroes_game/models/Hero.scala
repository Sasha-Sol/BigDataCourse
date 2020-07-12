package com.epam.heroes_game.models

abstract class Hero() {
  var power: Int
  var hp: Int

  def kick(hero: Hero):Unit

  def isAlive():Boolean = hp > 0

}
