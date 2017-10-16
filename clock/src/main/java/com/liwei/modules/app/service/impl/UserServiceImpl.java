package com.liwei.modules.app.service.impl;


import com.liwei.common.exception.RRException;
import com.liwei.common.validator.Assert;
import com.liwei.modules.app.dao.AppUserDao;
import com.liwei.modules.app.entity.AppUserEntity;
import com.liwei.modules.app.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private AppUserDao userDao;


    @Override
    public AppUserEntity queryByMobile(String mobile) {
        return userDao.queryByMobile(mobile);
    }

    @Override
    public long login(String mobile, String password) {
        AppUserEntity user = queryByMobile(mobile);
        Assert.isNull(user, "手机号或密码错误");

        //密码错误
        if (!user.getPassword().equals(DigestUtils.sha256Hex(password))) {
            throw new RRException("手机号或密码错误");
        }
        return user.getUserId();
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AppUserEntity userEntity) {
        return userDao.insert(userEntity);
    }

    @Override
    public int insertSelective(AppUserEntity userEntity) {
        return userDao.insertSelective(userEntity);
    }

    @Override
    public AppUserEntity selectByPrimaryKey(Long id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AppUserEntity userEntity) {
        return userDao.updateByPrimaryKeySelective(userEntity);
    }

    @Override
    public int updateByPrimaryKey(AppUserEntity userEntity) {
        return userDao.updateByPrimaryKey(userEntity);
    }
}
