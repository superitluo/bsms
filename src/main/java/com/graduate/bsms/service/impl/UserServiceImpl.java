package com.graduate.bsms.service.impl;


import com.graduate.bsms.mapper.UserMapper;
import com.graduate.bsms.pojo.Page;
import com.graduate.bsms.pojo.User;
import com.graduate.bsms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return this.userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        String usercode = record.getUsercode();
        String username = record.getUsername();
        String userpassword = record.getUserpassword();
        Integer gender = record.getGender();
        Date birthday = record.getBirthday();
        String phone = record.getPhone();
        String address = record.getAddress();
        Integer userrole = record.getUserrole();
        if (usercode == null && username == null && userpassword == null && gender == null && birthday == null &&
                phone == null && address == null && userrole == null) {
            return 0;
        } else {
            return this.userMapper.insert(record);
        }
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        Long id = record.getId();
        String usercode = record.getUsercode();
        String username = record.getUsername();
        String userpassword = record.getUserpassword();
        Integer gender = record.getGender();
        Date birthday = record.getBirthday();
        String phone = record.getPhone();
        String address = record.getAddress();
        Integer userrole = record.getUserrole();
        if (id == null) {
            return -1;
        }
        if (usercode == null && username == null && userpassword == null && gender == null && birthday == null &&
                phone == null && address == null && userrole == null) {
            return 0;
        } else {
            return this.userMapper.updateByPrimaryKey(record);
        }
    }

    @Override
    public List<User> selectList() {
        return this.userMapper.selectList();
    }

    @Override
    public List<User> selectUser(Page page, String username) {
        return userMapper.selectUser(page, username);
    }

    @Override
    public User Login(User record) {
        String usercode = record.getUsercode();
        String userpassword = record.getUserpassword();
        if (usercode == null && userpassword == null) {
            return null;
        } else {
            return this.userMapper.Login(record);
        }
    }

    @Override
    public Integer queryUserTotal() {
        return userMapper.queryUserTotal();
    }

    @Override
    public int updatePassword(User record) {
        String userpassword = record.getUserpassword();
        if (userpassword == null) {
            return 0;
        } else {
            return this.userMapper.updatePassword(record);
        }
    }
}
