package com.liwei.modules.oss.cloud;


import com.liwei.common.exception.RRException;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.request.DelFileRequest;
import com.qcloud.cos.request.UploadFileRequest;
import com.qcloud.cos.sign.Credentials;
import net.sf.json.JSONObject;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * 腾讯云存储
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-26 20:51
 */
public class QcloudCloudStorageService extends CloudStorageService {
    private COSClient client;

    public QcloudCloudStorageService(CloudStorageConfig config) {
        this.config = config;

        //初始化云存储配置
        init();
    }

    private void init() {
        Credentials credentials = new Credentials(config.getQcloudAppId(), config.getQcloudSecretId(),
                config.getQcloudSecretKey());

        //初始化客户端配置
        ClientConfig clientConfig = new ClientConfig();
        //设置bucket所在的区域，华南：gz 华北：tj 华东：sh
        clientConfig.setRegion(config.getQcloudRegion());

        client = new COSClient(clientConfig, credentials);
    }

    @Override
    public String upload(byte[] data, String cosPath) {
        //腾讯云必需要以"/"开头
        if (!cosPath.startsWith("/")) {
            cosPath = "/" + cosPath;
        }

        //上传到腾讯云
        UploadFileRequest request = new UploadFileRequest(config.getQcloudBucketName(), cosPath, data);
        String response = client.uploadFile(request);
        JSONObject jsonObject = JSONObject.fromObject(response);
        if (jsonObject.getInt("code") == 0) {
            return config.getQcloudDomain() + cosPath;
        } else {
            throw new RRException("文件上传失败，" + jsonObject.getString("message"));
        }
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            byte[] data = IOUtils.toByteArray(inputStream);
            return this.upload(data, path);
        } catch (IOException e) {
            throw new RRException("上传文件失败", e);
        }
    }

    @Override
    public String uploadSuffix(byte[] data, Long userId, String suffix) {
        return upload(data, getPath(config.getQcloudPrefix(), userId, suffix));
    }

    @Override
    public String uploadSuffix(InputStream inputStream, Long userId, String suffix) {
        return upload(inputStream, getPath(config.getQcloudPrefix(), userId, suffix));
    }

    @Override
    public void deleteObject(String cosPath) {
        // String path="/clock/music/2/93ae49c8a9f74a92b16609d0d7f785b4.mp3";
        cosPath = cosPath.substring(config.getQcloudDomain().length());
        DelFileRequest delete = new DelFileRequest(config.getQcloudBucketName(), cosPath);
        String response = client.delFile(delete);
        JSONObject jsonObject = JSONObject.fromObject(response);
        if (jsonObject.getInt("code") == 0) {
            return;
        } else {
            throw new RRException("文件上传失败，" + jsonObject.getString("message"));
        }
    }
}
