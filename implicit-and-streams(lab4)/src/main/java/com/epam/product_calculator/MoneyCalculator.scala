package com.epam.product_calculator

import com.epam.product_calculator.traits.Pricable

object MoneyCalculator {
  def totalPrice(implicit list:List[Pricable]):Double = {
    list.map(_.price).sum
  }

}
