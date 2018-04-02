package com.yangli.mybatis.v1;

import com.yangli.mybatis.beans.Test;

import java.sql.*;

/**
 * 具体数据库操作实现类
 *
 * Created by lies on 2018/4/2.
 */
public class VSimpleExecutor implements VExecutor {

    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/test";
    private String username = "root";
    private String pwd = "root";

    // JDBC
    @Override
    public <T> T query(String statement, String parameter) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Test test = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,pwd);
            ps = connection.prepareStatement(String.format(statement,Integer.parseInt(parameter)));
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
                rs.close();
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return (T) test;
    }
}
