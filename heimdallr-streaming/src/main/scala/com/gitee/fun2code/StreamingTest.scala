package com.gitee.fun2code

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by Administrator on 2019/4/27.
  */
object StreamingTest {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val conf = new SparkConf().setAppName("StreamingTest")
    val ssc = new StreamingContext(conf, Seconds(5))

    val messages = KafkaUtils.createStream(ssc, "cdh01:2181", "stest", Map("test" -> 1))


    messages.map(_._2).flatMap(_.split(" ")).map(x => (x, 1)).reduceByKey(_+_).print()

    ssc.start()
    ssc.awaitTermination()


  }

}
