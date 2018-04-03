package com.yangli.mybatis.v2.config;

import lombok.Data;

import java.io.IOException;

/**
 *  加载xml 以及 配置信息
 *
 * Created by lies on 2018/4/3.
 */
@Data
public class V2Configuration {

    private String scanPath;

    //提供一个注册中心
    public V2MapperRegistry mapperRegistry = new V2MapperRegistry();

    public V2Configuration scanPath(String scanPath) {
        this.scanPath = scanPath;
        return this;
    }

    // 判断
    public void build() throws IOException {
        if (null == scanPath && scanPath.length() < 1) {
            throw new RuntimeException("scan path is required!!! ");
        }
    }
}
