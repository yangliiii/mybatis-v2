package com.yangli.mybatis.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类，返回一个被代理的对象
 *
 * Created by lies on 2018/4/2.
 */
public class VMapperProxy implements InvocationHandler {
    private VSqlSession sqlSession;

    public VMapperProxy(VSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    /**
     *
     * @param proxy 代理对象
     * @param method    代理对象中的方法
     * @param args  参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass().getName().equals(VConfiguration.MapperXml.namespace)) {
            return sqlSession.selectOne(VConfiguration.MapperXml.methodSqlMapping.get(method.getName()),String.valueOf(args[0]));
        }
        return method.invoke(this,args);
    }
}
