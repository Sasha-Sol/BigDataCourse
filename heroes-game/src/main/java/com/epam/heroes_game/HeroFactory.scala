package com.epam.heroes_game

import com.epam.heroes_game.traits.Hero
import org.reflections.Reflections

import scala.collection.JavaConverters._
import scala.util.Random

object HeroFactory {


  private val heroClasses: List[Class[_ <: Hero]] = new Reflections("com.epam.heroes_game").getSubTypesOf(classOf[Hero]).asScala.toList

  def createCharacter: Hero = {
    var randomValue:Int = Random.nextInt(heroClasses.size - 1)
    heroClasses(randomValue).getConstructor().newInstance()

  }

}
