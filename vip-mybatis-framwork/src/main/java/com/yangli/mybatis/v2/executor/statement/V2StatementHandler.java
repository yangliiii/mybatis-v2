package com.yangli.mybatis.v2.executor.statement;

import com.yangli.mybatis.v2.config.V2Configuration;
import com.yangli.mybatis.v2.config.V2MapperRegistry;
import com.yangli.mybatis.v2.executor.result.V2ResultSetHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

/**
 * Created by lies on 2018/4/4.
 */
public class V2StatementHandler {
    private V2Configuration configuration;

    private V2ResultSetHandler resultSetHandler;

    public V2StatementHandler(V2Configuration configuration) {
        this.configuration = configuration;
        resultSetHandler = new V2ResultSetHandler(configuration);
    }

    public <E> E query(V2MapperRegistry.MapperData mapperData, Object parameter){
        try {
            Connection connection = getConnection();
            PreparedStatement ps =
                    connection.prepareStatement(String.format(mapperData.getSql(),Integer.parseInt(String.valueOf(parameter))));
            ResultSet rs = ps.executeQuery();
            // ResultSetHandler
            return resultSetHandler.handle(rs, mapperData.getClazz());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Connection getConnection() throws SQLException{
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String pwd = "root";
        Connection connection = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,pwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void release(Connection connection, PreparedStatement ps, ResultSet rs){
        try {
            if (null != connection) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (null != ps) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (null != rs) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
