package com.gitee.fun2code;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws Exception{
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<Person> persons = env.fromElements(
          new Person("zhangsan",11),
                new Person("lisi",22),
                new Person("wangwu",51)
        );

        DataStream<Person> adults = persons.filter(new FilterFunction<Person>() {
            @Override
            public boolean filter(Person person) throws Exception {
                return person.age > 18;
            }
        });

        adults.print();

        env.execute();
    }

    public static class Person{
        public String name;
        public Integer age;

        public Person(){

        }

        public Person(String name,Integer age){
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return this.name.toString() + ": age " + this.age.toString();
        }
    }

}
