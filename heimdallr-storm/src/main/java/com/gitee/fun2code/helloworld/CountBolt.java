package com.gitee.fun2code.helloworld;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/2/2.
 */
public class CountBolt implements IRichBolt{

    Map<String, Integer> counters;
    OutputCollector outputCollector;

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        outputCollector = collector;
        counters = new HashMap<String, Integer>();
    }

    @Override
    public void execute(Tuple tuple) {

        String str = tuple.getString(0);

        if (!counters.containsKey(str)) {
            counters.put(str, 1);
        } else {
            Integer c = counters.get(str) + 1;
            counters.put(str, c);
        }
        int max = 0;
        String maxWord = "";
        for(String key : counters.keySet()){
            int value = counters.get(key);
            if(value > max){
                max = value;
                maxWord = key;
            }
        }

        outputCollector.emit(new Values("max counts word is ["+maxWord+"] with "+max));

    }

    @Override
    public void cleanup() {

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("word"));
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}
