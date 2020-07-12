package com.epam.product_calculator

import com.epam.product_calculator.traits.{Costable, ProductFactory}
import org.reflections.Reflections
import collection.JavaConverters._

import scala.util.Random

object ProductFactoryImpl extends ProductFactory{
  val costableClasses: List[Class[_ <: Costable]] = new Reflections("com.epam.product_calculator.models").getSubTypesOf(classOf[Costable]).asScala.toList

  override def generateProduct(): Costable = {
    var randomValue:Int = Random.nextInt(costableClasses.size)
    var costableClass = costableClasses(randomValue).getConstructor().newInstance()

    println(s"Generated ${costableClass.getClass.getSimpleName} with cost: ${costableClass.cost} USD")

    costableClass
  }

  override def generateProducts(amount: Int): List[Costable] = {
    var products:List[Costable] = List[Costable]()
    for (i <- 1 to amount) {
      products ::= generateProduct()
    }
    products
  }


}
