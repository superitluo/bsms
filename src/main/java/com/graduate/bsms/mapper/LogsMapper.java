package com.graduate.bsms.mapper;


import com.graduate.bsms.pojo.Logs;

import java.util.List;

public interface LogsMapper {
    int deleteByPrimaryKey(Integer logid);

    int insert(Logs record);

    int insertSelective(Logs record);

    Logs selectByPrimaryKey(Integer logid);

    int updateByPrimaryKeySelective(Logs record);

    int updateByPrimaryKey(Logs record);

    List<Logs> selectAll();
}