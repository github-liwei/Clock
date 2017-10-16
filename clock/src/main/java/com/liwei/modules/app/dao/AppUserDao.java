package com.liwei.modules.app.dao;

import com.liwei.common.utils.BaseDao;
import com.liwei.modules.app.entity.AppUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AppUserDao extends BaseDao<AppUserEntity> {
    AppUserEntity queryByMobile(@Param("mobile") String mobile);
}