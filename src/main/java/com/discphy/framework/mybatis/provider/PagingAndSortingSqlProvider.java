package com.discphy.framework.mybatis.provider;

import com.discphy.framework.mybatis.spec.Pageable;
import com.discphy.framework.mybatis.support.SqlProviderSupport;
import org.apache.ibatis.builder.annotation.ProviderContext;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

import java.io.Serializable;

/**
 * PagingAndSortingSqlProvider
 *
 * @see SqlProviderSupport
 * @param <T> Table Entity
 * @param <ID> Table PK
 */
public class PagingAndSortingSqlProvider<T, ID extends Serializable> extends SqlProviderSupport<T, ID> {

    private final Log log = LogFactory.getLog(this.getClass());

    /**
     * Find All by pageable.
     *
     * @param pageable {@link Pageable}
     * @param ctx {@link ProviderContext}
     * @return dynamic SQL {@link String}
     */
    public String findAll(Pageable pageable, ProviderContext ctx) {
        String sql = new SQL()
            .SELECT(selectColumns(ctx))
            .FROM(tableName(ctx))
            .ORDER_BY(orders(pageable.getSort(), ctx))
            .OFFSET_ROWS("#{offset}")
            .FETCH_FIRST_ROWS_ONLY("#{limit}")
            .toString();

        if(log.isTraceEnabled()) {
            log.trace("created sql : " + sql);
        }

        return sql;
    }
}
