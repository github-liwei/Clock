package com.liwei.modules.app.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LIWEI on 2017/10/10.
 */
public class AppMusicTypeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 音乐类型id
     */
    private Long musicTypeId;

    /**
     * 类型名：eg 伤感
     */
    private String typeName;

    private List<Long> musicPathIdList;

    public AppMusicTypeEntity() {
    }

    public AppMusicTypeEntity(Long musicTypeId, String typeName) {
        this.musicTypeId = musicTypeId;
        this.typeName = typeName;
    }

    public Long getMusicTypeId() {
        return musicTypeId;
    }

    public void setMusicTypeId(Long musicTypeId) {
        this.musicTypeId = musicTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Long> getMusicPathIdList() {
        return musicPathIdList;
    }

    public void setMusicPathIdList(List<Long> musicPathIdList) {
        this.musicPathIdList = musicPathIdList;
    }
}
