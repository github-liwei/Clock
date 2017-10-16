package com.liwei.modules.sys.service.impl;

import com.google.gson.Gson;
import com.liwei.common.exception.RRException;
import com.liwei.modules.sys.dao.SysConfigDao;
import com.liwei.modules.sys.entity.SysConfigEntity;
import com.liwei.modules.sys.service.SysConfigService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LIWEI on 2017/10/12.
 */
@Service("sysConfigService")
public class SysConfigServiceImpl implements SysConfigService {
    @Autowired
    private SysConfigDao configEntityMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return configEntityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysConfigEntity e) {
        return configEntityMapper.insert(e);
    }

    @Override
    public int insertSelective(SysConfigEntity e) {
        return configEntityMapper.insertSelective(e);
    }

    @Override
    public SysConfigEntity selectByPrimaryKey(Long id) {
        return configEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysConfigEntity e) {
        return configEntityMapper.updateByPrimaryKeySelective(e);
    }

    @Override
    public int updateByPrimaryKey(SysConfigEntity e) {
        return configEntityMapper.updateByPrimaryKey(e);
    }

    @Override
    public void updateValueByKey(String key, String value) {
        SysConfigEntity configEntity = new SysConfigEntity();
        configEntity.setKey(key);
        configEntity.setValue(value);
        configEntityMapper.updateValueByKey(configEntity);
    }

    @Override
    public String getValue(String key) {
        SysConfigEntity config = configEntityMapper.queryByKey(key);
        return config == null ? null : config.getValue();
    }

    @Override
    public <T> T getConfigObject(String key, Class<T> clazz) {
        String value = getValue(key);
        if (StringUtils.isNotBlank(value)) {
            return new Gson().fromJson(value, clazz);
        }

        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new RRException("获取参数失败");
        }
    }
}
