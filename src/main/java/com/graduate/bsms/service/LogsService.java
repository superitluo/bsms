package com.graduate.bsms.service;

import com.graduate.bsms.pojo.Logs;

import java.util.List;

public interface LogsService {

    int deleteByPrimaryKey(Integer logid);

    int insert(Logs record);

    int insertSelective(Logs record);

    Logs selectByPrimaryKey(Integer logid);

    int updateByPrimaryKeySelective(Logs record);

    int updateByPrimaryKey(Logs record);

    List<Logs> selectAll();
}
