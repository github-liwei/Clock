package com.liwei.modules.sys.dao;

import com.liwei.modules.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by LIWEI on 2017/9/5.
 */
@Mapper
public interface UserDao extends BaseDao<User> {

}
