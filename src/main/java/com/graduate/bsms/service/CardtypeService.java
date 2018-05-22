package com.graduate.bsms.service;

import com.graduate.bsms.pojo.Cardtype;

import java.util.List;

/**
 * Created by Admin on 2018/5/15.
 */
public interface CardtypeService {
    int deleteByPrimaryKey(String id);

    int insert(Cardtype record);

    int insertSelective(Cardtype record);

    Cardtype selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Cardtype record);

    int updateByPrimaryKey(Cardtype record);

    List<Cardtype> selectAll();
}
