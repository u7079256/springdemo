package com.heima.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;

public class DataSourceTest {
    @Test
    public void test1() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
