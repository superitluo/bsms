package com.graduate.bsms.mapper;


import com.graduate.bsms.pojo.Cardtype;

import java.util.List;

public interface CardtypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Cardtype record);

    int insertSelective(Cardtype record);

    Cardtype selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Cardtype record);

    int updateByPrimaryKey(Cardtype record);

    List<Cardtype> selectAll();
}