package com.discphy.framework.mybatis.domain;


import com.discphy.framework.mybatis.spec.Pageable;

/**
 * PageRequest
 *
 * @see Pageable
 */
public class PageRequest implements Pageable {

    /**
     * page number
     */
    private final int page;

    /**
     * page size
     */
    private final int size;

    /**
     * sort
     */
    private final Sort sort;

    /**
     * @param page page
     * @param size size
     * @param sort sort {@link Sort}
     */
    public PageRequest(int page, int size, Sort sort) {
        this.page = page;
        this.size = size;
        this.sort = sort;
    }

    /**
     * create PageRequest
     * @param page page
     * @param size size
     * @return PageRequest {@link PageRequest}
     */
    public static PageRequest of(int page, int size) {
        return PageRequest.of(page, size, null);
    }

    /**
     * create PageRequest
     * @param page page
     * @param size size
     * @param sort sort
     * @return PageRequest {@link PageRequest}
     */
    public static PageRequest of(int page, int size, Sort sort) {
        return new PageRequest(page, size, sort);
    }

    /**
     * @return offset {@link Long}
     */
    @Override
    public long getOffset() {
        return (long)page * (long)size;
    }

    /**
     * @return limit {@link Integer}
     */
    @Override
    public int getLimit() {
        return this.size;
    }

    /**
     * @return sort {@link Sort}
     */
    @Override
    public Sort getSort() {
        return this.sort;
    }
}