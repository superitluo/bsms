package com.graduate.bsms.service.impl;

import com.graduate.bsms.mapper.RoleMapper;
import com.graduate.bsms.pojo.Role;
import com.graduate.bsms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return this.roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Role record) {
        String rolecode = record.getRolecode();
        String rolename = record.getRolename();
        if (rolecode == null && rolename == null) {
            return 0;
        } else {
            return this.roleMapper.insert(record);
        }
    }

    @Override
    public int insertSelective(Role record) {
        return 0;
    }

    @Override
    public Role selectByPrimaryKey(Long id) {
        return this.roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        Long id = record.getId();
        String rolecode = record.getRolecode();
        String rolename = record.getRolename();
        if (id == null) {
            return -1;
        }
        if (rolecode == null && rolename == null) {
            return 0;
        } else {
            return this.roleMapper.updateByPrimaryKey(record);
        }
    }

    @Override
    public List<Role> selectAll() {
        return this.roleMapper.selectAll();
    }
}
