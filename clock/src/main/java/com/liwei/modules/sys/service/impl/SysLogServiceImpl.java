package com.liwei.modules.sys.service.impl;

import com.liwei.modules.sys.dao.SysLogDao;
import com.liwei.modules.sys.entity.SysLogEntity;
import com.liwei.modules.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LIWEI on 2017/10/11.
 */
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao logEntityMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return logEntityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysLogEntity entity) {
        return logEntityMapper.insert(entity);
    }

    @Override
    public int insertSelective(SysLogEntity entity) {
        return logEntityMapper.insertSelective(entity);
    }

    @Override
    public SysLogEntity selectByPrimaryKey(Long id) {
        return logEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysLogEntity entity) {
        return logEntityMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int updateByPrimaryKey(SysLogEntity entity) {
        return logEntityMapper.updateByPrimaryKey(entity);
    }
}
