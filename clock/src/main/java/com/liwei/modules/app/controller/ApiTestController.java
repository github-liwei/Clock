package com.liwei.modules.app.controller;


import com.liwei.common.annotation.Login;
import com.liwei.common.utils.R;
import com.liwei.modules.app.annotation.LoginUser;
import com.liwei.modules.app.entity.AppUserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * APP测试接口
 */
@RestController
@RequestMapping("/app")
public class ApiTestController {

    /**
     * 获取用户信息
     */
    @Login
    @GetMapping("userInfo")
    public R userInfo(@LoginUser AppUserEntity user) {
        return R.ok().put("user", user);
    }

    /**
     * 获取用户ID
     */
    @Login
    @GetMapping("userId")
    public R userInfo(@RequestAttribute("userId") Integer userId) {
        return R.ok().put("userId", userId);
    }

    /**
     * 忽略Token验证测试
     */
    @GetMapping("notToken")
    public R notToken() {
        return R.ok().put("msg", "无需token也能访问。。。");
    }


}
