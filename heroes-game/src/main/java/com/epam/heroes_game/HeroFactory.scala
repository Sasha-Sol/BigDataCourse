package com.epam.heroes_game

import java.lang.reflect.Constructor

import com.epam.heroes_game.models.Hero
import org.reflections.Reflections


object HeroFactory {

  val rnd = new scala.util.Random

  var reflections:Reflections = new Reflections("com.epam.heroes_game");
  var heroClasses = reflections.getSubTypesOf(classOf[Hero])

  def createCharacter: Hero = {
    var randomValue:Int = rnd.nextInt(heroClasses.size())
    val iterator = heroClasses.iterator()
    var heroConstructor: Constructor[_ <: Hero] = iterator.next().getDeclaredConstructor()

    while (iterator.hasNext && randomValue != 0) {
      heroConstructor = iterator.next().getDeclaredConstructor()
      randomValue -= 1
    }
    return heroConstructor.newInstance()
  }

}
