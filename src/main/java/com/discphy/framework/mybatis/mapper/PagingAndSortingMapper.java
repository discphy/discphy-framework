package com.discphy.framework.mybatis.mapper;

import com.discphy.framework.mybatis.provider.PagingAndSortingSqlProvider;
import com.discphy.framework.mybatis.spec.Pageable;
import org.apache.ibatis.annotations.SelectProvider;

import java.io.Serializable;
import java.util.List;

/**
 * PagingAndSortingMapper
 *
 * @see PagingAndSortingSqlProvider
 * @param <T> Table Entity
 * @param <ID> Table PK
 */
public interface PagingAndSortingMapper<T, ID extends Serializable> {

    /**
     * @param pageable {@link Pageable}
     * @return Table entities {@link List}&lt;{@link T}&gt;
     */
    @SelectProvider(type = PagingAndSortingSqlProvider.class)
    List<T> findAll(Pageable pageable);

}
