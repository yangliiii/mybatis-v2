package com.yangli.mybatis.v2.executor;

import com.yangli.mybatis.beans.Test;
import com.yangli.mybatis.v2.config.V2Configuration;
import com.yangli.mybatis.v2.config.V2MapperRegistry;
import lombok.Data;

import java.sql.*;

/**
 * 具体实现者
 *
 * Created by lies on 2018/4/3.
 */
@Data
public class V2SimpleExecutor implements V2Executor {

    private V2Configuration configuration;

    public V2SimpleExecutor(V2Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T query(V2MapperRegistry.MapperData mapperData, Object parameter) {

        // jdbc
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String pwd = "root";

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Test test = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,pwd);
            ps = connection.prepareStatement(String.format(mapperData.getSql(),
                    Integer.parseInt(String.valueOf(parameter))));
            rs = ps.executeQuery();

            while (rs.next()) {
                test = new Test();
                test.setId(rs.getInt(1));
                test.setNums(rs.getInt(2));
                test.setName(rs.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(ps != null){
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return (T) test;
    }
}
