package com.liwei.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by LIWEI on 2017/10/10.
 */
public class SysUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long userId;
    private String username;
    private String password;
    /**
     * 盐
     */
    private String salt;
    private String email;
    private String mobile;

    /**
     * 状态  0：禁用   1：正常
     */
    private Byte status;

    /**
     * 角色ID列表
     */
    private List<Long> roleIdList;

    /**
     * 歌曲ID列表
     */
    private List<Long> musicIdList;

    /**
     * 创建者ID
     */
    private Long createUserId;

    /**
     * 创建时间
     */
    private Date createTime;

    public SysUserEntity() {
    }

    public SysUserEntity(Long userId, String username, String password, String salt, String email, String mobile, Byte status, Long createUserId, Date createTime) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.email = email;
        this.mobile = mobile;
        this.status = status;
        this.createUserId = createUserId;
        this.createTime = createTime;
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
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Long> roleIdList) {
        this.roleIdList = roleIdList;
    }

    public List<Long> getMusicIdList() {
        return musicIdList;
    }

    public void setMusicIdList(List<Long> musicIdList) {
        this.musicIdList = musicIdList;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
