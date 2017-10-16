package com.liwei.modules.app.entity;

import java.util.Date;

public class AppTokenEntity {
    private Long userId;

    private String token;

    private Date expireTime;

    private Date updateTime;

    public AppTokenEntity(Long userId, String token, Date expireTime, Date updateTime) {
        this.userId = userId;
        this.token = token;
        this.expireTime = expireTime;
        this.updateTime = updateTime;
    }

    public AppTokenEntity() {
        super();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}