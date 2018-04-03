package com.yangli.mybatis.v2.executor;

import com.yangli.mybatis.v2.config.V2MapperRegistry;

/**
 * Created by lies on 2018/4/3.
 */
public class V2CachingExecutor implements V2Executor {
    public V2CachingExecutor(V2SimpleExecutor v2SimpleExecutor) {
    }

    @Override
    public <T> T query(V2MapperRegistry.MapperData mapperData, Object parameter) {
        return null;
    }
}
