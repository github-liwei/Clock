package com.liwei.modules.app.service.impl;

import com.liwei.modules.app.dao.AppMusicDao;
import com.liwei.modules.app.entity.AppMusicEntity;
import com.liwei.modules.app.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LIWEI on 2017/10/13.
 */
@Service("musicService")
public class MusicServiceImpl implements MusicService {
    @Autowired
    private AppMusicDao musicDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return musicDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AppMusicEntity e) {
        return musicDao.insert(e);
    }

    @Override
    public int insertSelective(AppMusicEntity e) {
        return musicDao.insertSelective(e);
    }

    @Override
    public AppMusicEntity selectByPrimaryKey(Long id) {
        return musicDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AppMusicEntity e) {
        return musicDao.updateByPrimaryKeySelective(e);
    }

    @Override
    public int updateByPrimaryKey(AppMusicEntity e) {
        return musicDao.updateByPrimaryKey(e);
    }

    @Override
    public List<AppMusicEntity> queryListByUserId(Long userId) {
        return musicDao.queryListByUserId(userId);
    }
}
