package com.liwei.modules.app.dao;

import com.liwei.common.utils.BaseDao;
import com.liwei.modules.app.entity.AppMusicEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppMusicDao extends BaseDao<AppMusicEntity> {
    List<AppMusicEntity> queryListByUserId(Long userId);
}