package com.yangli.mybatis.v2.executor;

import com.yangli.mybatis.v2.config.V2Configuration;

/**
 * Created by lies on 2018/4/3.
 */
public class V2ExecutorFactory {

    private static final String SIMPLE = "SIMPLE";
    private static final String CACHE = "CACHE";

    public static V2Executor DEFAULT(V2Configuration configuration){
        return get(SIMPLE, configuration);
    }

    public static V2Executor get(String key, V2Configuration configuration) {
        if (SIMPLE.equalsIgnoreCase(key)) {
            return new V2SimpleExecutor(configuration);
        }
        if (CACHE.equalsIgnoreCase(key)) {
            return new V2CachingExecutor(new V2SimpleExecutor(configuration));
        }
        throw new RuntimeException("not found executor");
    }

    public enum V2ExecutorType{
        SIMPLE,CACHE
    }

}
