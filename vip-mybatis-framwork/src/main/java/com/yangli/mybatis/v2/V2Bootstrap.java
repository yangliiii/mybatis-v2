package com.yangli.mybatis.v2;

import com.yangli.mybatis.beans.Test;
import com.yangli.mybatis.mapper.TestMapper;
import com.yangli.mybatis.v2.config.V2Configuration;
import com.yangli.mybatis.v2.executor.V2ExecutorFactory;
import com.yangli.mybatis.v2.executor.V2SimpleExecutor;
import com.yangli.mybatis.v2.session.V2SqlSession;

import java.io.IOException;

/**
 * Created by lies on 2018/4/3.
 */
public class V2Bootstrap {

    public static void main(String[] args) throws IOException {
        V2Configuration configuration = new V2Configuration();
//        configuration.scanPath("com.yangli.abc.mybatis.mapper");
//        configuration.build();

        V2SqlSession sqlSession = new V2SqlSession(configuration,
                V2ExecutorFactory.get(V2ExecutorFactory.V2ExecutorType.SIMPLE.name(),configuration));
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        Test test = testMapper.selectByPrimaryKey(1);
        System.out.println(test);
    }
}
