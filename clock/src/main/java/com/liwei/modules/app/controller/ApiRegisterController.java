package com.liwei.modules.app.controller;


import com.liwei.common.utils.R;
import com.liwei.common.validator.Assert;
import com.liwei.modules.app.entity.AppUserEntity;
import com.liwei.modules.app.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 注册
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-26 17:27
 */
@RestController
@RequestMapping("/app")
public class ApiRegisterController {
    @Autowired
    private UserService userService;

    /**
     * 注册
     */
    @PostMapping("register")
    public R register(String mobile, String password) {
        Assert.isBlank(mobile, "手机号不能为空");
        Assert.isBlank(password, "密码不能为空");

        AppUserEntity user = new AppUserEntity();
        user.setPassword(DigestUtils.sha256Hex(password));
        user.setCreateTime(new Date());
        user.setMobile(mobile);
        user.setUsername(mobile);
        userService.insert(user);

        return R.ok();
    }
}
