package com.yangli.mybatis.v2.session;

import com.yangli.mybatis.v2.binding.V2MapperProxy;
import com.yangli.mybatis.v2.config.V2Configuration;
import com.yangli.mybatis.v2.config.V2MapperRegistry;
import com.yangli.mybatis.v2.executor.V2Executor;
import lombok.Data;

import java.lang.reflect.Proxy;

/**
 *  一次会话  主要包括了Configuration 和 Executor
 *
 * Created by lies on 2018/4/3.
 */
@Data
public class V2SqlSession {
    private V2Configuration configuration;
    private V2Executor executor;

    public V2SqlSession(V2Configuration configuration, V2Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    // 动态代理
    public <T> T getMapper(Class<T> clazz){
        return (T) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{clazz},
                new V2MapperProxy(this, clazz));
    }

    //
    public <T> T selectOne(V2MapperRegistry.MapperData mapperData, String parameter){
        return executor.query(mapperData,parameter);
    }
}
