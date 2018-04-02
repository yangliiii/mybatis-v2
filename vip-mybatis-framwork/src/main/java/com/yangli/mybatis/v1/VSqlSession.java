package com.yangli.mybatis.v1;

/**
 * 访问数据库的一次会话
 * 本次会话中需要拿到对应的执行方法、sql语句，通过VConfiguration进行操作。
 * 本次会话需要操作数据库，操作数据库的过程交于VExecutor来进行操作
 *
 * Created by lies on 2018/4/2.
 */
public class VSqlSession {
    VConfiguration configuration = null;
    VExecutor executor = null;

    public VSqlSession(VConfiguration configuration, VExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    <T> T getMapper(Class clazz){
        return configuration.getMapper(clazz,this);
    }

    <T> T selectOne(String statement, String parameter){
        return executor.query(statement,parameter);
    }
}
