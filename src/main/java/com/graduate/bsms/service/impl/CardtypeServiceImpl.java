package com.graduate.bsms.service.impl;

import com.graduate.bsms.mapper.CardtypeMapper;
import com.graduate.bsms.pojo.Cardtype;
import com.graduate.bsms.service.CardtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 2018/5/15.
 */
@Service
public class CardtypeServiceImpl implements CardtypeService {
    @Autowired
    private CardtypeMapper cardtypeMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return cardtypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Cardtype record) {
        return cardtypeMapper.insert(record);
    }

    @Override
    public int insertSelective(Cardtype record) {
        return 0;
    }

    @Override
    public Cardtype selectByPrimaryKey(String id) {
        return cardtypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Cardtype record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Cardtype record) {
        return cardtypeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Cardtype> selectAll() {
        return cardtypeMapper.selectAll();
    }
}
