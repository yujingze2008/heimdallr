package com.gitee.fun2code

import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.api.windowing.time.Time

object Credit51EtlJob {

  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.createLocalEnvironment()
    val text = env.socketTextStream("192.168.111.131",9999)

    val counts = text.flatMap{ _.toLowerCase.split("\\W+") filter { _.nonEmpty }}.map{(_,1)}
        .keyBy(0)
        .timeWindow(Time.seconds(5))
        .sum(1)
    counts.print()
    env.execute("Credit51EtlJob")

  }

}
