package com.liwei.modules.app.service.impl;

import com.liwei.modules.app.dao.AppTokenDao;
import com.liwei.modules.app.entity.AppTokenEntity;
import com.liwei.modules.app.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * token服务
 * Created by LIWEI on 2017/10/11.
 */
@Service("tokenService")
public class TokenServiceImpl implements TokenService {
    @Autowired
    private AppTokenDao tokenEntityMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return tokenEntityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AppTokenEntity tokenEntity) {
        return tokenEntityMapper.insert(tokenEntity);
    }

    @Override
    public int insertSelective(AppTokenEntity tokenEntity) {
        return tokenEntityMapper.insertSelective(tokenEntity);
    }

    @Override
    public AppTokenEntity selectByPrimaryKey(Long id) {
        return tokenEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AppTokenEntity tokenEntity) {
        return tokenEntityMapper.updateByPrimaryKeySelective(tokenEntity);
    }

    @Override
    public int updateByPrimaryKey(AppTokenEntity tokenEntity) {
        return tokenEntityMapper.updateByPrimaryKey(tokenEntity);
    }
}
