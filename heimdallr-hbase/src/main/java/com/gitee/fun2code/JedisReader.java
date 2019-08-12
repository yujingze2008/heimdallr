package com.gitee.fun2code;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2019/5/30.
 */
public class JedisReader implements Runnable {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new JedisReader()).start();
        }
    }

    static JedisCluster jedisCluster = null;

    static {
        Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
        jedisClusterNode.add(new HostAndPort("192.168.243.131", 7000));
        jedisClusterNode.add(new HostAndPort("192.168.243.131", 7001));
        jedisClusterNode.add(new HostAndPort("192.168.243.132", 7002));
        jedisClusterNode.add(new HostAndPort("192.168.243.132", 7003));
        jedisClusterNode.add(new HostAndPort("192.168.243.133", 7004));
        jedisClusterNode.add(new HostAndPort("192.168.243.133", 7005));
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(2);//设置最大连接数
        config.setMaxIdle(2);//设置最大空闲连接
        jedisCluster = new JedisCluster(jedisClusterNode, 5000, 10);
    }

    @Override
    public void run() {
        for (; ; ) {
            jedisCluster.srem("123123","asdasd");
            jedisCluster.get("Thread-91559147012382");
            jedisCluster.hget("myhash","asdasdasdasd");
           // System.out.println(Thread.currentThread().getName() + " value:" + jedisCluster.get("Thread-91559147012382").substring(1, 3));
        }
    }
}
