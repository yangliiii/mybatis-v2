package com.yangli.mybatis.v2.config;

import com.yangli.mybatis.beans.Test;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 注册中心
 * 提供参数封装以及namespace
 *
 * Created by lies on 2018/4/3.
 */
@Data
public class V2MapperRegistry {

    private static final Map<String, MapperData> methodSqlMapping = new HashMap();

    public V2MapperRegistry(){
        methodSqlMapping.put("com.yangli.mybatis.mapper.TestMapper",
                new MapperData(Test.class,"select * from test where id = %d"));
    }

    // 提供参数名称以及参数类型
    public class MapperData<T>{
        private Class<T> clazz;
        private String sql;

        public MapperData(Class<T> clazz, String sql) {
            this.clazz = clazz;
            this.sql = sql;
        }

        public Class<T> getClazz() {
            return clazz;
        }

        public void setClazz(Class<T> clazz) {
            this.clazz = clazz;
        }

        public String getSql() {
            return sql;
        }

        public void setSql(String sql) {
            this.sql = sql;
        }
    }

    public MapperData get(String namespace){
        return methodSqlMapping.get(namespace);
    }

}
