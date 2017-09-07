package com.liwei.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 交易的信息
 * Created by LIWEI on 2017/9/5.
 */
public class Trade implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Integer trade_price;
    private Integer trader_number;
    private Date trade_date;
    private TradeType tradeType;
    private User user;
    private Stock stock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTrade_price() {
        return trade_price;
    }

    public void setTrade_price(Integer trade_price) {
        this.trade_price = trade_price;
    }

    public Integer getTrader_number() {
        return trader_number;
    }

    public void setTrader_number(Integer trader_number) {
        this.trader_number = trader_number;
    }

    public Date getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(Date trade_date) {
        this.trade_date = trade_date;
    }

    public TradeType getTradeType() {
        return tradeType;
    }

    public void setTradeType(TradeType tradeType) {
        this.tradeType = tradeType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
