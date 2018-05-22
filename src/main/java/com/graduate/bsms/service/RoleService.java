package com.graduate.bsms.service;


import com.graduate.bsms.pojo.Role;

import java.util.List;

public interface RoleService {

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectAll();
}
