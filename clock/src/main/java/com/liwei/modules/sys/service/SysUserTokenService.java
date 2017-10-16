package com.liwei.modules.sys.service;

import com.liwei.common.utils.BaseService;
import com.liwei.common.utils.R;
import com.liwei.modules.sys.entity.SysUserTokenEntity;

/**
 * Created by LIWEI on 2017/10/11.
 */
public interface SysUserTokenService extends BaseService<SysUserTokenEntity> {
    /**
     * 生成token
     *
     * @param userId 用户ID
     */
    R createToken(long userId);

    /**
     * 退出，修改token值
     *
     * @param userId 用户ID
     */
    void logout(long userId);

}
