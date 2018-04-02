package com.yangli.mybatis.v1;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * 加载xml文件，获取xml配置文件中的各种信息
 *
 * Created by lies on 2018/4/2.
 */
public class VConfiguration {

    // 动态代理，获取配置信息 Mapper类，访问数据库方法、sql等信息
    public <T> T getMapper(Class clazz, VSqlSession vSqlSession) {
        return (T) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{clazz},
                new VMapperProxy(vSqlSession));
    }

    // 模拟加载xml文件
    static class MapperXml{
        static final String namespace = "com.yangli.mybatis.mapper.TestMapper";

        static final Map<String, String> methodSqlMapping = new HashMap();

        static {
            methodSqlMapping.put("selectByPrimaryKey","select * from test where id = %d");
        }
    }
}
