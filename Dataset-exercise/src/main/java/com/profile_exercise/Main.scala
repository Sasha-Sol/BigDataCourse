package com.profile_exercise

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.DataType
import org.apache.spark.sql.{DataFrame, SparkSession}

object Main {
  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "c:/winutils")
    Logger.getLogger("org.apache").setLevel(Level.WARN)


    var dataFrame: DataFrame = SparkSession.builder.appName("ProfileExercise").master("local[*]").getOrCreate.read.json("Dataset-exercise/src/main/java/com/profile_exercise/data/profiles.json")

    ///1///
    println("This is the DataFrame")
    dataFrame.show();

    ///2///

    println("The dataframe schema")
    dataFrame.printSchema()

    ///3///
    val types: Seq[DataType] = dataFrame.schema.map(_.dataType)
    println("All the types are")
    types.foreach(println)

    ///4////
    val dataFrameWithSalary = dataFrame.withColumn("salary", when(col("age") > 30,col("age")).otherwise(5) * size(col("keywords")))
    println("Dataframe with new salary column")
    dataFrameWithSalary.show()

    ///5 Explode solution///
    var mostCommonKeyword = dataFrame.withColumn("keywords", explode(col("keywords")))
      .groupBy("keywords")
      .count()
      .sort(col("count").desc)
      .first()
      .get(0)

    dataFrameWithSalary
      .filter(col("salary").leq(1200) && array_contains(col("keywords"), mostCommonKeyword))
      .select("name")
      .show()

  }
}
