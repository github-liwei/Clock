package com.liwei.modules.app.service;


import com.liwei.common.utils.BaseService;
import com.liwei.modules.app.entity.AppUserEntity;

/**
 * 用户
 *
 * @author liwei
 */
public interface UserService extends BaseService<AppUserEntity> {

    AppUserEntity queryByMobile(String mobile);

    /**
     * 用户登录
     *
     * @param mobile   手机号
     * @param password 密码
     * @return 返回用户ID
     */
    long login(String mobile, String password);
}
