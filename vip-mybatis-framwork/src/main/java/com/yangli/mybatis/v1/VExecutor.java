package com.yangli.mybatis.v1;

/**
 * 操作数据库，定义为接口
 * 实际操作交予实现类来完成
 *
 * Created by lies on 2018/4/2.
 */
public interface VExecutor {
    <T> T query(String statement, String parameter);
}
