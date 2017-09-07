package com.liwei.modules.sys.service;

import com.liwei.modules.sys.entity.User;

import java.util.List;
import java.util.Map;


public interface UserService {


    /**
     * 根据用户名，查询系统用户
     */
    User queryByUserName(String username);

    /**
     * 根据用户ID，查询用户
     * @param userId
     * @return
     */
    User queryObject(Long userId);

    /**
     * 查询用户列表
     */
    List<User> queryList(Map<String, Object> map);

    /**
     * 查询总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存用户
     */
    void save(User user);

    /**
     * 修改用户
     */
    void update(User user);

    /**
     * 删除用户
     */
    void deleteBatch(Long[] userIds);

    /**
     * 修改密码
     * @param userId       用户ID
     * @param password     原密码
     * @param newPassword  新密码
     */
    int updatePassword(Long userId, String password, String newPassword);


}
