package com.epam.taxi_service.java;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class MainJava {



    public static void main(String[] args) {
        System.setProperty("hadoop.home.dir", "c:/winutils");
        Logger.getLogger("org.apache").setLevel(Level.WARN);

        TaxiService service = new TaxiService();

        System.out.println(service.getTaxiDrivers().count());
        System.out.println(service.getTaxiOrders().count());

        System.out.println("The orders to boston for drive distance more than 10km are ");
        JavaRDD<Order> boston = service.getAllOrdersToSpecificTownWithDistanceAbove("Boston", 10);
        boston.foreach(v->System.out.println(v));

        System.out.println("summary km of rides to boston are " + service.getSummaryDistanceFromAllOrdersToSpeceificTown("Boston"));

//        boston.for
//        );

    }
}
