package com.gitee.fun2code.helloworld;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;

/**
 * Created by Administrator on 2019/2/2.
 */
public class WorldCountTopology {

    private static TopologyBuilder builder = new TopologyBuilder();

    public static void main(String[] args){

        Config config = new Config();

        if (args != null && args.length > 0) {
            if(args.length != 6){
                System.out.println("args error exit");
                System.exit(0);
            }
            try {
                config.setNumWorkers(Integer.parseInt(args[1]));
                builder.setSpout("randomSpout",new RandomSpout(),Integer.parseInt(args[2]));
                builder.setBolt("wordBolt",new WordBolt(),Integer.parseInt(args[3])).shuffleGrouping("randomSpout");
                builder.setBolt("countBolt", new CountBolt(),Integer.parseInt(args[4])).fieldsGrouping("wordBolt",
                        new Fields("word"));
                builder.setBolt("Print", new PrintBolt(),Integer.parseInt(args[5])).shuffleGrouping(
                        "countBolt");
                StormSubmitter.submitTopology(args[0], config,
                        builder.createTopology());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            builder.setSpout("randomSpout",new RandomSpout());
            builder.setBolt("wordBolt",new WordBolt()).shuffleGrouping("randomSpout");
            builder.setBolt("countBolt", new CountBolt()).fieldsGrouping("wordBolt",
                    new Fields("word"));
            builder.setBolt("Print", new PrintBolt()).shuffleGrouping(
                    "countBolt");
            config.setMaxTaskParallelism(1);
            LocalCluster cluster = new LocalCluster();
            cluster.submitTopology("mywordcount", config, builder.createTopology());
        }

    }

}
