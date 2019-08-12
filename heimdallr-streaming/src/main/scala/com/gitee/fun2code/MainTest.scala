package com.gitee.fun2code

import com.alibaba.fastjson.JSON
import org.apache.log4j.{Level, Logger}
import org.apache.spark
import org.apache.spark.sql.SQLContext
import org.apache.spark.streaming.State
import org.apache.spark.{SparkConf, SparkContext}
/**
  * Created by Administrator on 2019/4/27.
  */
object MainTest {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val conf = new SparkConf().setAppName("Main Test").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val sqlContext = new SQLContext(sc)

    val rdd = sc.parallelize(List("{'id':'123',name:'zhangsan'}","{'id':'456',name:'lisi'}"))

    val idRDD = rdd.map(s => {
      val obj = JSON.parseObject(s)
      IdEntity(obj.getString("id"))
    })

    val nameRDD = rdd.map(s => {
      val obj = JSON.parseObject(s)
      NameEntity(obj.getString("name"))
    })

    sqlContext.createDataFrame(idRDD).registerTempTable("t_id")
    sqlContext.createDataFrame(nameRDD).registerTempTable("t_name")

    sqlContext.sql("select * from t_id").show()
    sqlContext.sql("select * from t_name").show()

    //rdd.flatMap(_.split(" ")).map(x=>(x,1)).reduceByKey(_+_).foreach(println)

   /* val mappingFunc = (word: String, one: Option[Int], state: State[Int]) => {
      val sum = one.getOrElse(0) + state.getOption.getOrElse(0)
      val output = (word, sum)
      state.update(sum)
      state.remove()
      output
    }*/

    sc.stop()
  }

  case class IdEntity(id:String)

  case class NameEntity(name:String)

}
