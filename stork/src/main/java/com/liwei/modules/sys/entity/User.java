package com.liwei.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by LIWEI on 2017/9/5.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String password;
    private Integer money;
    private String phone;
    private Date reg_date;
    private String role;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", phone='" + phone + '\'' +
                ", reg_date=" + reg_date +
                ", role='" + role + '\'' +
                '}';
    }
}
