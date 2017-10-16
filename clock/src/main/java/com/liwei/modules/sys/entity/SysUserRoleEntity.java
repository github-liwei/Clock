package com.liwei.modules.sys.entity;


import java.io.Serializable;

/**
 * 用户与角色对应关系
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:28:39
 */
public class SysUserRoleEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;

    public SysUserRoleEntity(Long id, Long userId, Long roleId) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
    }

    public SysUserRoleEntity() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getRoleId() {
        return roleId;
    }

}
