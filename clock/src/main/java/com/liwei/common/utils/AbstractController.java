package com.liwei.common.utils;


import com.liwei.modules.sys.entity.SysUserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected SysUserEntity getUser() {
        return null;
    }

    protected Integer getUserId() {
        return getUser().getUserId().intValue();
    }

}
