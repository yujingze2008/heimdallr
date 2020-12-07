package com.gitee.fun2code;/*
package com.gitee.code4fun.doris;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import javax.sql.DataSource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class DorisExample {


    public static void main(String[] args) throws Exception{
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://192.168.9.24:9030/ods");
        ds.setUsername("root");
        ds.setPassword("123456");
        ds.setInitialSize(50);
        ds.setMaxIdle(30);

        QueryRunner run = new QueryRunner(ds);

        */
/*int rs = run.query("select count(*) as cnt from sys_user", new ResultSetHandler<Integer>() {
            @Override
            public Integer handle(ResultSet resultSet) throws SQLException {
                if(resultSet.next()){
                    return resultSet.getInt("cnt");
                }
                return 0;
            }
        });

        System.out.println(rs);*//*




        for(int i=0;i<100000;i++){
            int inserts = run.update( "INSERT INTO `sys_user` VALUES (?, 'ff1a9ca2246a484b9957dbac2891017d', 'ff1a9ca2246a484b9957dbac2891017d', '101010', 'c159ff22682c764aa3bad1157b589f11086e292bf7cdfcfa40fa80a3', null, ?, '', '18688888888', '18688888888', '2', '', '0:0:0:0:0:0:0:1', '2020-10-14 17:43:01', '2020-10-14 17:43:04', '1', '1', '2017-03-10 11:38:42', '1', '2020-10-14 17:43:01', '', '0', 'D2:EB:EC:88:40:22', '1872');",
                    UUID.randomUUID().toString().replaceAll("-",""), "于景泽"+i);
            System.out.println(inserts);
        }

        ds.close();

    }

}
*/
