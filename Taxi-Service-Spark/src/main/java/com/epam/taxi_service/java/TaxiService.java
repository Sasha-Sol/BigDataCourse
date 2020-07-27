package com.epam.taxi_service.java;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.storage.StorageLevel;
import scala.Tuple4;

import java.util.List;

public class TaxiService {

    private static String DRIVERS_PATH = "Taxi-Service-Spark/src/main/resources/drivers.txt";
    private static String TAXI_ORDER_PATH = "Taxi-Service-Spark/src/main/resources/taxi_orders.txt";

    private JavaRDD<String> taxiOrders;
    private JavaRDD<String> taxiDrivers;

    public TaxiService() {
        SparkConf conf = new SparkConf().setAppName("startingSpark").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        this.taxiDrivers = sc.textFile(DRIVERS_PATH);
        this.taxiOrders = sc.textFile(TAXI_ORDER_PATH);
    }

    public JavaRDD<String> getTaxiOrders() {
        return taxiOrders;
    }

    public JavaRDD<String> getTaxiDrivers() {
        return taxiDrivers;
    }

    public JavaRDD<Order> getAllOrdersToSpecificTownWithDistanceAbove(String town, int aboveKM) {
        JavaRDD<Order> map = taxiOrders.map(order -> {
            String[] s = order.split(" ");
            return new Order(Integer.parseInt(s[0]),s[1],Integer.parseInt(s[2]),s[3]);
        }).persist(StorageLevel.MEMORY_AND_DISK());

        return map.filter( order -> order.getDistance() >= aboveKM && order.getTown().equals(town));
    }

    public int getSummaryDistanceFromAllOrdersToSpeceificTown(String town) {
        JavaRDD<Order> ordersToSpecificLocation = getAllOrdersToSpecificTownWithDistanceAbove(town, 0);
        return ordersToSpecificLocation.map(order -> order.getDistance()).reduce(Integer::sum);
    }


}
