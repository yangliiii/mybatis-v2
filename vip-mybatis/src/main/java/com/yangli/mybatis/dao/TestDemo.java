package com.yangli.mybatis.dao;

import com.yangli.mybatis.beans.Test;
import com.yangli.mybatis.mapper.TestMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by lies on 2018/3/30.
 */
public class TestDemo {

    private static SqlSession getSqlSession() throws FileNotFoundException {
        // 加载配置文件
        InputStream is = new FileInputStream("D:\\IdeaProjects\\mybatis-v2\\vip-mybatis\\src\\main\\resources\\mybatis-config.xml") ;

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        return sqlSessionFactory.openSession();
    }

    public static void main(String[] args) throws FileNotFoundException {
        TestMapper testMapper = getSqlSession().getMapper(TestMapper.class);
        Test test = testMapper.selectByPrimaryKey(2);
        System.out.println(test.getId() + " : " + test.getName());
    }
}
