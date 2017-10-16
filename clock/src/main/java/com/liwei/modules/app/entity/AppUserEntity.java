package com.liwei.modules.app.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户
 *
 * @author liwei
 */
public class AppUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long userId;

    private String username;

    private String mobile;

    private String password;

    private Date createTime;

    public AppUserEntity(Long userId, String username, String mobile, String password, Date createTime) {
        this.userId = userId;
        this.username = username;
        this.mobile = mobile;
        this.password = password;
        this.createTime = createTime;
    }

    public AppUserEntity() {
        super();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
