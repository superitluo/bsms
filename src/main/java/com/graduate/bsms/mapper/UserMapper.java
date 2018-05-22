package com.graduate.bsms.mapper;


import com.graduate.bsms.pojo.Page;
import com.graduate.bsms.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectList();

    List<User> selectUser(@Param("page") Page page, @Param("username") String username);

    User Login(User record);

    Integer queryUserTotal();

    int updatePassword(User record);
}