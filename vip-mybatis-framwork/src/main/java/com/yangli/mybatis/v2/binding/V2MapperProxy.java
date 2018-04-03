package com.yangli.mybatis.v2.binding;

import com.yangli.mybatis.v2.config.V2Configuration;
import com.yangli.mybatis.v2.config.V2MapperRegistry;
import com.yangli.mybatis.v2.session.V2SqlSession;
import lombok.Data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by lies on 2018/4/3.
 */
@Data
public class V2MapperProxy<T> implements InvocationHandler {
    private V2SqlSession sqlSession;
    private Class<T> clazz;

    public V2MapperProxy(V2SqlSession sqlSession, Class<T> clazz) {
        this.sqlSession = sqlSession;
        this.clazz = clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 首先获取MapperData 参数类型以及sql
        V2MapperRegistry.MapperData mapperData = sqlSession.getConfiguration().getMapperRegistry()
                .get("com.yangli.mybatis.mapper.TestMapper");
        if (null != mapperData){
            System.out.println(String.format("SQL: [ %s ] , parameter : [%s]",mapperData.getSql(),args[0]));
            return sqlSession.selectOne(mapperData,String.valueOf(args[0]));
        }

        return method.invoke(proxy,args);
    }
}
