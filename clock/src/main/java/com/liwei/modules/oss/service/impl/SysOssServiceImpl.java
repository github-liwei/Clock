package com.liwei.modules.oss.service.impl;

import com.liwei.modules.oss.dao.SysOssDao;
import com.liwei.modules.oss.entity.SysOssEntity;
import com.liwei.modules.oss.service.SysOssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysOssService")
public class SysOssServiceImpl implements SysOssService {
    @Autowired
    private SysOssDao ossEntityMapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return ossEntityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysOssEntity e) {
        return ossEntityMapper.insert(e);
    }

    @Override
    public int insertSelective(SysOssEntity e) {
        return ossEntityMapper.insertSelective(e);
    }

    @Override
    public SysOssEntity selectByPrimaryKey(Long id) {
        return ossEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysOssEntity e) {
        return ossEntityMapper.updateByPrimaryKeySelective(e);
    }

    @Override
    public int updateByPrimaryKey(SysOssEntity e) {
        return ossEntityMapper.updateByPrimaryKey(e);
    }
}
