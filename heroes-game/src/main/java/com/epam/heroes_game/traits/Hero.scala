package com.epam.heroes_game.traits

trait Hero {
  var power: Int
  var hp: Int

  def kick(hero: Hero):Unit

  def isAlive():Boolean = hp > 0
}
