package com.liwei;

import com.liwei.modules.app.utils.JwtUtils;
import com.liwei.modules.sys.dao.SysUserDao;
import com.liwei.modules.sys.entity.SysUserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClockApplicationTests {
    @Autowired
    private SysUserDao userEntityMapper;
    @Autowired
    private JwtUtils jwtUtils;

    @Test
    public void contextLoads() {
        SysUserEntity userEntity = new SysUserEntity(2L, "liwei", "8800580..", "h8dh8shd8shd", "4444@qq.com", "11", (byte) 1, 1L, new Date());
        userEntityMapper.insert(userEntity);
    }


    @Test
    public void test() {
        String token = jwtUtils.generateToken(1);
        System.out.println(token);
    }

}
