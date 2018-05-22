package com.graduate.bsms.service.impl;


import com.graduate.bsms.mapper.LogsMapper;
import com.graduate.bsms.pojo.Logs;
import com.graduate.bsms.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LogsServiceImpl implements LogsService {

    @Autowired
    private LogsMapper logsMapper;

    @Override
    public int deleteByPrimaryKey(Integer logid) {
        return 0;
    }

    @Override
    public int insert(Logs record) {
        String operationtype = record.getOperationtype();
        String operationresult = record.getOperationresult();
        String operationuserid = record.getOperationuserid();
        String ip = record.getIp();
        if (operationtype == null && operationresult == null && operationuserid == null) {
            return 0;
        }
        return this.logsMapper.insert(record);
    }

    @Override
    public int insertSelective(Logs record) {
        return 0;
    }

    @Override
    public Logs selectByPrimaryKey(Integer logid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Logs record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Logs record) {
        return 0;
    }

    @Override
    public List<Logs> selectAll() {
        return this.logsMapper.selectAll();
    }
}
