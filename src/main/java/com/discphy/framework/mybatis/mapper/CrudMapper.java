package com.discphy.framework.mybatis.mapper;

import com.discphy.framework.mybatis.provider.CrudSqlProvider;
import org.apache.ibatis.annotations.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * CrudMapper
 *
 * @see CrudSqlProvider
 * @param <T> Table Entity
 * @param <ID> Table PK
 */
public interface CrudMapper<T, ID extends Serializable> {

    /**
     * @param entity Table Entity {@link T}
     * @return save Count {@link Integer}
     */
    @InsertProvider(type = CrudSqlProvider.class)
    int save(T entity);

    /**
     * @param id Table PK {@link ID}
     * @return find Table Entity {@link Optional}&lt;{@link T}&gt;}
     */
    @SelectProvider(type = CrudSqlProvider.class)
    Optional<T> findById(ID id);

    /**
     * @param ids Table PKs {@link List}&lt;{@link ID}&gt;
     * @return find Table Entities {@link List}&lt;{@link T}&gt;
     */
    @SelectProvider(type = CrudSqlProvider.class)
    List<T> findAllById(@Param("ids") Iterable<ID> ids);

    /**
     * @return find Table count {@link Long}
     */
    @SelectProvider(type = CrudSqlProvider.class)
    long count();

    /**
     * @param id Table PK {@link ID}
     * @return delete count {@link Integer}
     */
    @DeleteProvider(type = CrudSqlProvider.class)
    int deleteById(ID id);

    /**
     * @param entity Table entity {@link T}
     * @return delete count {@link Integer}
     */
    @DeleteProvider(type = CrudSqlProvider.class)
    int delete(T entity);

    /**
     * @param ids Table PKs {@link List}&lt;{@link ID}&gt;
     * @return delete count {@link Integer}
     */
    @DeleteProvider(type = CrudSqlProvider.class)
    int deleteAllById(@Param("ids") Iterable<ID> ids);

    /**
     * @param entity Table entity {@link T}
     * @return create count {@link Integer}
     */
    @InsertProvider(type = CrudSqlProvider.class)
    int create(T entity);

    /**
     * update all column
     * @param entity Table entity {@link T}
     * @return update count {@link Integer}
     */
    @UpdateProvider(type = CrudSqlProvider.class)
    int update(T entity);

    /**
     * update nonnull column
     * @param entity Table entity {@link T}
     * @return update count {@link Integer}
     */
    @UpdateProvider(type = CrudSqlProvider.class)
    int dynamicUpdate(T entity);

    /**
     * bulk insert
     * @param entities Table entities {@link List}&lt;{@link T}&gt;
     * @return create count {@link Integer}
     */
    @InsertProvider(type = CrudSqlProvider.class)
    int createAll(@Param("entities") Iterable<T> entities);

}
