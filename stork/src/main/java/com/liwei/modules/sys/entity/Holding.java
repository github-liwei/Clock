package com.liwei.modules.sys.entity;

import java.io.Serializable;

/**
 * 股票持仓表
 * Created by LIWEI on 2017/9/5.
 */
public class Holding implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Integer number;
    private Integer avg_price;
    private Stock stock;
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getAvg_price() {
        return avg_price;
    }

    public void setAvg_price(Integer avg_price) {
        this.avg_price = avg_price;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
