package main.scala

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object RestaurantUsage {
  def main (args : Array[String]) : Unit = {
    val input = args(0)
    val output = args(1)
    val conf = new SparkConf().setAppName("RestaurantUsage").setMaster("local[*]")
    val sc = new SparkContext(conf)
    
    val fooddata = sc.textFile(input);
    // make record
    val mapRDD = fooddata.map (line => line.split(",")).map(column => ((column(1),column(8)),1))
    val aggrRDD = mapRDD.reduceByKey((x,y) => x+y)
    val sortedRDD = aggrRDD.sortBy( x => x, true)
    
    sortedRDD.saveAsTextFile(output)
  }
}