package com.liwei.modules.sys.service.impl;

import com.liwei.modules.sys.entity.User;
import com.liwei.modules.sys.dao.UserDao;
import com.liwei.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by LIWEI on 2017/9/5.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User queryByUserName(String username) {
        return null;
    }

    @Override
    public User queryObject(Long userId) {
        return userDao.queryObject(userId);
    }

    @Override
    public List<User> queryList(Map<String, Object> map) {
        return null;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return 0;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteBatch(Long[] userIds) {

    }

    @Override
    public int updatePassword(Long userId, String password, String newPassword) {
        return 0;
    }
}
