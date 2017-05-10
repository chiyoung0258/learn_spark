/**
  * Created by chiyoung on 17. 5. 9.
  */

package main.scala

import org.apache.spark.sql.SparkSession

object SparkSessionWordCount {

  def main(args : Array[String]) : Unit = {
    val input = args(0)

    val spark : SparkSession = SparkSession.builder.master("local").appName("wordcount2").getOrCreate()

    import spark.implicits._

    val source = spark.read.text(input).as[String]
    val word = source.flatMap(line => line.split(" "))
    val groupedWord = word.groupByKey(_.toLowerCase())
    val cnt = groupedWord.count().toDF().orderBy($"count(1)".desc)
    cnt.show()
  }
}
