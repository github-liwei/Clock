package com.liwei.modules.app.controller;


import com.liwei.common.annotation.Login;
import com.liwei.common.utils.R;
import com.liwei.common.validator.Assert;
import com.liwei.modules.app.entity.AppTokenEntity;
import com.liwei.modules.app.entity.AppUserEntity;
import com.liwei.modules.app.service.TokenService;
import com.liwei.modules.app.service.UserService;
import com.liwei.modules.app.utils.JwtUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * APP登录授权
 *
 * @author liwei
 */
@RestController
@RequestMapping("/app")
public class ApiLoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private TokenService tokenService;

    /**
     * 登录
     */
    @PostMapping("login")
    public R login(String mobile, String password) {
        Assert.isBlank(mobile, "手机号不能为空");
        Assert.isBlank(password, "密码不能为空");

        //用户登录
        long userId = userService.login(mobile, password);

        //生成token
        String token = jwtUtils.generateToken(userId);

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());

        //判断token是否存在
        AppTokenEntity tokenEntity = tokenService.selectByPrimaryKey(userId);
        if (tokenEntity == null) {
            tokenService.insert(new AppTokenEntity(userId, token, new Date(System.currentTimeMillis() + jwtUtils.getExpire()), new Date()));
        } else {
            tokenEntity.setUpdateTime(new Date());
            tokenEntity.setExpireTime(new Date(System.currentTimeMillis() + jwtUtils.getExpire()));
            tokenEntity.setToken(token);
            tokenService.updateByPrimaryKey(tokenEntity);
        }
        return R.ok(map);
    }

    @Login
    @PostMapping("update")
    public R update(String mobile, String oldPassword, String newPassword) {
        Assert.isBlank(mobile, "手机号不能为空");
        Assert.isBlank(oldPassword, "老密码不能为空");
        Assert.isBlank(newPassword, "新密码不能为空");

        long userId = userService.login(mobile, oldPassword);
        AppUserEntity userEntity = new AppUserEntity();
        userEntity.setUserId(userId);
        userEntity.setPassword(DigestUtils.sha256Hex(newPassword));
        userService.updateByPrimaryKeySelective(userEntity);

        tokenService.deleteByPrimaryKey(userId);
        return R.ok("修改成功");
    }

}
