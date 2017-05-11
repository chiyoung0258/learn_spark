package main.scala
import org.apache.spark.sql.SparkSession

/**
  * Created by chiyoung on 17. 5. 11.
  */
object FlatMap {
  def main(args : Array[String]) : Unit = {
    require(args.length == 2, "[keyword] [input]")

    val keyword = args(0)
    val input = args(1)

    val spark = SparkSession.builder.master("local").appName("SparkGrep").getOrCreate()
    import spark.implicits._

    val data = spark.read.textFile(input).as[String]
    val search = data.flatMap(line => {
      if (line.toLowerCase().contains(keyword.toLowerCase())) {
        Some(line)
      } else {
        None
      }
    })
    search.show()
  }
}
