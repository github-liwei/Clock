package com.liwei.modules.oss.cloud;

import com.liwei.common.validator.group.QcloudGroup;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 云存储配置信息
 *
 * @author liwei
 */
public class CloudStorageConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    //类型 1：七牛  2：阿里云  3：腾讯云
    @Range(min = 1, max = 3, message = "类型错误")
    private Integer type;
    //腾讯云绑定的域名
    @NotBlank(message = "腾讯云绑定的域名不能为空", groups = QcloudGroup.class)
    @URL(message = "腾讯云绑定的域名格式不正确", groups = QcloudGroup.class)
    private String qcloudDomain;
    //腾讯云路径前缀
    private String qcloudPrefix;
    //腾讯云AppId
    @NotNull(message = "腾讯云AppId不能为空", groups = QcloudGroup.class)
    private Integer qcloudAppId;
    //腾讯云SecretId
    @NotBlank(message = "腾讯云SecretId不能为空", groups = QcloudGroup.class)
    private String qcloudSecretId;
    //腾讯云SecretKey
    @NotBlank(message = "腾讯云SecretKey不能为空", groups = QcloudGroup.class)
    private String qcloudSecretKey;
    //腾讯云BucketName
    @NotBlank(message = "腾讯云BucketName不能为空", groups = QcloudGroup.class)
    private String qcloudBucketName;
    //腾讯云COS所属地区
    @NotBlank(message = "所属地区不能为空", groups = QcloudGroup.class)
    private String qcloudRegion;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getQcloudDomain() {
        return qcloudDomain;
    }

    public void setQcloudDomain(String qcloudDomain) {
        this.qcloudDomain = qcloudDomain;
    }

    public String getQcloudPrefix() {
        return qcloudPrefix;
    }

    public void setQcloudPrefix(String qcloudPrefix) {
        this.qcloudPrefix = qcloudPrefix;
    }

    public Integer getQcloudAppId() {
        return qcloudAppId;
    }

    public void setQcloudAppId(Integer qcloudAppId) {
        this.qcloudAppId = qcloudAppId;
    }

    public String getQcloudSecretId() {
        return qcloudSecretId;
    }

    public void setQcloudSecretId(String qcloudSecretId) {
        this.qcloudSecretId = qcloudSecretId;
    }

    public String getQcloudSecretKey() {
        return qcloudSecretKey;
    }

    public void setQcloudSecretKey(String qcloudSecretKey) {
        this.qcloudSecretKey = qcloudSecretKey;
    }

    public String getQcloudBucketName() {
        return qcloudBucketName;
    }

    public void setQcloudBucketName(String qcloudBucketName) {
        this.qcloudBucketName = qcloudBucketName;
    }

    public String getQcloudRegion() {
        return qcloudRegion;
    }

    public void setQcloudRegion(String qcloudRegion) {
        this.qcloudRegion = qcloudRegion;
    }
}
