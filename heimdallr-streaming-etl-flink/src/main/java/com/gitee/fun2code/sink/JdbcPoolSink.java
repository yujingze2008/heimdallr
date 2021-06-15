package com.gitee.fun2code.sink;

import com.gitee.fun2code.jobs.Iso8583Entity;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.connector.jdbc.JdbcConnectionOptions;
import org.apache.flink.connector.jdbc.JdbcExecutionOptions;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JdbcPoolSink extends RichSinkFunction {

    private JdbcExecutionOptions executionOptions;

    private JdbcConnectionOptions connectionOptions;

    private String sql;

    HikariDataSource ds = null;

    public JdbcPoolSink(String sql, JdbcExecutionOptions executionOptions, JdbcConnectionOptions connectionOptions) {
        this.sql = sql;
        this.executionOptions = executionOptions;
        this.connectionOptions = connectionOptions;
    }

    @Override
    public void open(Configuration parameters) throws Exception {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(connectionOptions.getDriverName());
        config.setJdbcUrl(connectionOptions.getDbURL());
        config.setUsername(connectionOptions.getUsername().get());
        config.setPassword(connectionOptions.getPassword().get());
        config.setMaximumPoolSize(30);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    @Override
    public void close() throws Exception {
        if (ds != null) {
            ds.close();
        }
    }

    @Override
    public void invoke(Object value, Context context) throws Exception {
        Iso8583Entity entity = (Iso8583Entity) value;
        Connection conn = ds.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, entity.getPrimaryAccountNumber());
        ps.setInt(2, entity.getProcessingCode());
        ps.setBigDecimal(3, entity.getAmountTransaction());
        ps.setString(4, entity.getTransmissionDate());
        ps.setInt(5, entity.getSystemTraceAuditNumber());
        ps.setString(6, entity.getDateExpiration());
        ps.setString(7, entity.getMerchantType());
        ps.setString(8, entity.getPointOfServiceEntryModeCode());
        ps.setString(9, entity.getCardAcceptorIdentificationCode());
        ps.setString(10, entity.getCardAcceptorNameLocation());
        ps.setString(11, entity.getCurrencyCode());
        ps.execute();
        conn.close();
    }
}
