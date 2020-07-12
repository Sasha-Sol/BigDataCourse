package com.epam.product_calculator.models

import com.epam.product_calculator.traits.Costable

case class Chair() extends Costable {
  override def cost: Int = 50
}
