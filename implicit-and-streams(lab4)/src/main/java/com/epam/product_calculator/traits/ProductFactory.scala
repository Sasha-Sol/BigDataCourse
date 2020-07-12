package com.epam.product_calculator.traits

trait ProductFactory {
  def generateProduct():Costable
  def generateProducts(amount: Int):List[Costable]
}
