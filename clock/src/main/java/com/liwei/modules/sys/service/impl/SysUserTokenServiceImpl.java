package com.liwei.modules.sys.service.impl;

import com.liwei.common.utils.R;
import com.liwei.modules.sys.entity.SysUserTokenEntity;
import com.liwei.modules.sys.service.SysUserTokenService;
import org.springframework.stereotype.Service;

/**
 * Created by LIWEI on 2017/10/11.
 */
@Service("sysUserTokenService")
public class SysUserTokenServiceImpl implements SysUserTokenService {
    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(SysUserTokenEntity sysUserTokenEntity) {
        return 0;
    }

    @Override
    public int insertSelective(SysUserTokenEntity sysUserTokenEntity) {
        return 0;
    }

    @Override
    public SysUserTokenEntity selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(SysUserTokenEntity sysUserTokenEntity) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SysUserTokenEntity sysUserTokenEntity) {
        return 0;
    }

    @Override
    public R createToken(long userId) {
        return null;
    }

    @Override
    public void logout(long userId) {

    }
}
