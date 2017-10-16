package com.liwei.modules.sys.dao;

import com.liwei.common.utils.BaseDao;
import com.liwei.modules.sys.entity.SysConfigEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysConfigDao extends BaseDao<SysConfigEntity> {

    void updateValueByKey(SysConfigEntity configEntity);

    SysConfigEntity queryByKey(String key);
}