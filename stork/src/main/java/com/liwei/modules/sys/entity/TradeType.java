package com.liwei.modules.sys.entity;

import java.io.Serializable;

/**
 * Created by LIWEI on 2017/9/5.
 */
public class TradeType  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String info;//交易类别信息

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
