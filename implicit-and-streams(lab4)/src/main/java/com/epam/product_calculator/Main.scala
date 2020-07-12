package com.epam.product_calculator

import com.epam.product_calculator.traits.Costable

object Main {
  def main(args: Array[String]): Unit = {
    import com.epam.product_calculator.Helpers.asPricableList

    val costableList: List[Costable] = ProductFactoryImpl.generateProducts(10)
    println("Total amount of all products in nis = " + MoneyCalculator.totalPrice(costableList))


  }
}
