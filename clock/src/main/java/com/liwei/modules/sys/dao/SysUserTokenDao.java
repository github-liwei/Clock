package com.liwei.modules.sys.dao;

import com.liwei.common.utils.BaseDao;
import com.liwei.modules.sys.entity.SysUserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserTokenDao extends BaseDao<SysUserTokenEntity> {
    SysUserTokenEntity queryByUserId(Long userId);

    SysUserTokenEntity queryByToken(String token);
}