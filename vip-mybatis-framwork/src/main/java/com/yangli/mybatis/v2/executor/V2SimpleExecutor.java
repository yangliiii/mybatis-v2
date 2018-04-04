package com.yangli.mybatis.v2.executor;

import com.yangli.mybatis.beans.Test;
import com.yangli.mybatis.v2.config.V2Configuration;
import com.yangli.mybatis.v2.config.V2MapperRegistry;
import com.yangli.mybatis.v2.executor.statement.V2StatementHandler;
import lombok.Data;

import java.sql.*;

/**
 * 具体实现者
 *
 * Created by lies on 2018/4/3.
 */
@Data
public class V2SimpleExecutor implements V2Executor {

    private V2Configuration configuration;

    public V2SimpleExecutor(V2Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T query(V2MapperRegistry.MapperData mapperData, Object parameter) {

        // Handler
        V2StatementHandler statementHandler = new V2StatementHandler(configuration);
        return statementHandler.query(mapperData,parameter);
    }
}
