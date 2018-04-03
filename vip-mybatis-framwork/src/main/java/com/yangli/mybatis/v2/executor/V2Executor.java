package com.yangli.mybatis.v2.executor;

import com.yangli.mybatis.v2.config.V2MapperRegistry;

/**
 * Created by lies on 2018/4/3.
 */
public interface V2Executor {
    <T> T query(V2MapperRegistry.MapperData mapperData, Object parameter);
}
