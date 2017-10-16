package com.liwei.modules.app.service;

import com.liwei.common.utils.BaseService;
import com.liwei.modules.app.entity.AppMusicEntity;

import java.util.List;

/**
 * Created by LIWEI on 2017/10/13.
 */
public interface MusicService extends BaseService<AppMusicEntity> {
    List<AppMusicEntity> queryListByUserId(Long userId);
}
