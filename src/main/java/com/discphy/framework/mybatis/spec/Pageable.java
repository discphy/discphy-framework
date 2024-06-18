package com.discphy.framework.mybatis.spec;


import com.discphy.framework.mybatis.domain.Sort;

/**
 * Pageable
 */
public interface Pageable {

    /**
     * @return offset
     */
    long getOffset();

    /**
     * @return limit
     */
    int getLimit();

    /**
     * @return sort {@link Sort}
     */
    Sort getSort();
}