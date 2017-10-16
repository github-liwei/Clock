package com.liwei.modules.app.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by LIWEI on 2017/10/10.
 */
public class AppMusicEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 音乐路径Id
     */
    private Long musicId;
    /**
     * 音乐发布者
     */
    private Long userId;

    /**
     * 音乐类型id
     */
    private Long musicTypeId;

    /**
     * 音乐名字
     */
    private String musicName;

    /**
     * 音乐路径
     */
    private String musicUrlPath;

    private Date createTime;

    public AppMusicEntity() {
    }

    public AppMusicEntity(Long musicId, Long userId, Long musicTypeId, String musicUrlPath, String musicName, Date createTime) {
        this.musicId = musicId;
        this.userId = userId;
        this.musicTypeId = musicTypeId;
        this.musicUrlPath = musicUrlPath;
        this.musicName = musicName;
        this.createTime = createTime;
    }

    public Long getMusicId() {
        return musicId;
    }

    public void setMusicId(Long musicId) {
        this.musicId = musicId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMusicTypeId() {
        return musicTypeId;
    }

    public void setMusicTypeId(Long musicTypeId) {
        this.musicTypeId = musicTypeId;
    }

    public String getMusicUrlPath() {
        return musicUrlPath;
    }

    public void setMusicUrlPath(String musicUrlPath) {
        this.musicUrlPath = musicUrlPath == null ? null : musicUrlPath.trim();
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName == null ? null : musicName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
