# LEARNING SPARK
## RDD CREATION
### parallelize
### textFile
### wholeTextFiles
### sequenceFile
## RDD STORE
### saveAsTextFile
### saveAsObjectFile
### saveAsSequenceFile
## RDD CACHE
### cache
### persist
## TRANSFORMATION
### map
### filter
### flatMap
### mapPartitions
### union
### intersection
### subtract
### distinct
### cartesian
### zip
### zipWithIndex
### groupBy
### keyBy
### sortBy
### pipe
### randomSplit
### coalesce
### repartition
### sample
## TRANSFORMATION - Key/Value RDD
### keys
### values
### mapValues
### join
### leftOuterJoin
### rightOuterJoin
### fullOuterJoin
### sampleByKey
### subtractByKey
### groupByKey
### reduceByKey
    main.scala.RestaurantUsage
## ACTION 
### collect
### count
### countByValue
### first
### max
### min
### take
### takeOrdered
### top
### fold
### reduce
## ACTION - Key/Value RDD
### countByKey
### lookup
## ACTION - Numeric
### mean
### stdev
### sum
### variance

# Build with Gradle
## update gradle 3.5
    $ sudo add-apt-repository ppa:cwchien/gradle
    $ sudo apt-get update
    $ sudo apt-get install gradle-3.5
## configuring zinc compiler (a standalone version of sbt's incremental Scala compiler)
    dependencies {
        zinc 'com.typesafe.zinc:zinc:0.3.9'
    }
## run with spark-submit
    SPARK_HOME/bin/spark-submit --class "main.scala.WordCount" build/libs/learn_spark-1.0.jar README.md output
    
# Make Test Code
## generate sample log
### https://www.mockaroo.com/
    logid - number
    time - date
    account - regular expression - account\d{1}
    
    can generate 1000 rows test rows.

