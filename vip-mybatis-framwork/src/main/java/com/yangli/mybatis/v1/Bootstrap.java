package com.yangli.mybatis.v1;

import com.yangli.mybatis.beans.Test;
import com.yangli.mybatis.mapper.TestMapper;

/**
 * Created by lies on 2018/4/2.
 */
public class Bootstrap {
    public static void main(String[] args) {
        VSqlSession sqlSession = new VSqlSession(new VConfiguration(),new VSimpleExecutor());
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        Test test = testMapper.selectByPrimaryKey(1);
        System.out.println(test);
    }

}
