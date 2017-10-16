package com.liwei.modules.app.controller;


import com.liwei.common.annotation.Login;
import com.liwei.common.annotation.SysLog;
import com.liwei.common.exception.RRException;
import com.liwei.common.utils.ConfigConstant;
import com.liwei.common.utils.R;
import com.liwei.common.validator.Assert;
import com.liwei.modules.app.annotation.LoginUser;
import com.liwei.modules.app.entity.AppMusicEntity;
import com.liwei.modules.app.entity.AppUserEntity;
import com.liwei.modules.app.service.MusicService;
import com.liwei.modules.oss.cloud.OSSFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * 文件上传
 *
 * @author chenshun
 */
@RestController
@RequestMapping("/app")
public class ApiMusicController {
    @Autowired
    private MusicService musicService;


    private final static String KEY = ConfigConstant.CLOUD_STORAGE_CONFIG_KEY;

    /**
     * 列表
     */
    @Login
    @GetMapping("/listMusic")
    public R list(@LoginUser AppUserEntity user) {
        // musicService.queryListByUserId(user.getUserId());
        return R.ok();
    }


    /**
     * @param file        文件
     * @param user        用户信息
     * @param musicTypeId music类型
     * @return url
     * @throws Exception
     */
    @SysLog("上传音乐")
    @Login
    @PostMapping("/upload")
    public R upload(@RequestParam("file") MultipartFile file, @LoginUser AppUserEntity user, Long musicTypeId) throws Exception {
        Assert.isNull(user, "无user信息");
        Assert.isNull(musicTypeId, "无music类型信息");
        if (file.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }
        //上传文件
        String _suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String _url = OSSFactory.build().uploadSuffix(file.getBytes(), user.getUserId(), _suffix);

        AppMusicEntity _music = new AppMusicEntity();
        _music.setUserId(user.getUserId());
        _music.setMusicTypeId(musicTypeId);
        _music.setCreateTime(new Date());
        _music.setMusicUrlPath(_url);
        _music.setMusicName(file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf(".")));
        musicService.insert(_music);
        return R.ok().put("url", _music);
    }

    @Login
    @GetMapping("/downloadMusic")
    public R downloadMusic(@RequestParam("musicId") Long id) {
        AppMusicEntity music = musicService.selectByPrimaryKey(id);
        if (music == null) {
            return R.error("您下的资源不见，我们尽快找回");
        } else {
            return R.ok("文件删除成功");
        }
    }

    /**
     * 删除
     */
    @Login
    @RequestMapping("/delete")
    public R delete(@RequestParam Long id) {
        AppMusicEntity music = musicService.selectByPrimaryKey(id);
        Assert.isNull(music, "主人，未查找到此音乐");
        OSSFactory.build().deleteObject(music.getMusicUrlPath());
        musicService.deleteByPrimaryKey(id);
        return R.ok("文件删除成功");
    }

}
