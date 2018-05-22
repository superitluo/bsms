package com.graduate.bsms.service;


import com.graduate.bsms.pojo.Page;
import com.graduate.bsms.pojo.User;

import java.util.List;

public interface UserService {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectList();

    List<User> selectUser(Page page, String username);

    User Login(User record);

    Integer queryUserTotal();

    int updatePassword(User record);
}
