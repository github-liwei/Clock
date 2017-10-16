package com.liwei.modules.sys.service;

import com.liwei.common.utils.BaseService;
import com.liwei.modules.sys.entity.SysConfigEntity;

/**
 * Created by LIWEI on 2017/10/12.
 */
public interface SysConfigService extends BaseService<SysConfigEntity> {
    /**
     * 根据key，更新value
     */
    void updateValueByKey(String key, String value);

    /**
     * 根据key，获取配置的value值
     *
     * @param key key
     */
    String getValue(String key);

    /**
     * 根据key，获取value的Object对象
     *
     * @param key   key
     * @param clazz Object对象
     */
    <T> T getConfigObject(String key, Class<T> clazz);
}
