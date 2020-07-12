package com.epam.product_calculator

import com.epam.product_calculator.traits.{Costable, Pricable}

object Helpers {
  val usdToNis:Double = 3.47

  implicit def asPricableList(costableList:List[Costable]) : List[Pricable] = {
    var pricableList:List[Pricable] = List[Pricable]()
    costableList foreach { costable =>
      pricableList ::= new Pricable {
        override def price: Double = costable.cost * usdToNis
      }
    }
    pricableList
  }

}
