//package com.gitee.fun2code;
//
//import org.apache.commons.lang.time.StopWatch;
//import redis.clients.jedis.Jedis;
//
///**
// * Created by Administrator on 2018/7/5.
// */
//public class RedisTest {
//
//    public static void main(String[] args) throws Exception{
//
//        Jedis jedis = new Jedis("192.168.56.102");
//        System.out.println(jedis.ping());
//
//        /*for(int i=0;i<1000000;i++){
//            String key = UUID.randomUUID().toString();
//            jedis.set(key,""+i);
//            System.out.println(i);
//        }*/
//        /*String hashKey = "test";
//        for(int i=0;i<1000000;i++){
//            String key = UUID.randomUUID().toString();
//            jedis.hset(hashKey,key,""+i);
//            System.out.println(i);
//        }*/
//
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        /*for(int i=0;i<1000;i++){
//            jedis.get(""+i);
//        }*/
//
//        for(int i=0;i<1000;i++){
//            jedis.hget("test",""+i);
//        }
//
//        stopWatch.stop();
//
//
//
//        System.out.println(stopWatch.getTime());
//
//    }
//
//}
