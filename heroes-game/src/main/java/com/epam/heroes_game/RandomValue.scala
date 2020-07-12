package com.epam.heroes_game

import scala.util.Random

object RandomValue {
  def fromTo(from: Int, to: Int): Int = {
    from + Random.nextInt(to - from + 1)
  }
}
