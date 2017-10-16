package com.liwei.common.utils;

/**
 * Created by LIWEI on 2017/9/13.
 */
public interface BaseService<T> {
    int deleteByPrimaryKey(Long id);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);
}
