package com.liwei.common.utils;


import java.util.List;
import java.util.Map;

/**
 * liwei
 *
 * @param <T>
 */

public interface BaseDao<T> {
    int deleteByPrimaryKey(Long id);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);


    List<Map<String, Object>> queryLimitList(Map<String, Object> map);

    int queryTotal();

    int deleteBatchById();
}
