package com.graduate.bsms.mapper;


import com.graduate.bsms.pojo.Page;
import com.graduate.bsms.pojo.Sales;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalesMapper {

    Sales selectByPrimaryKey(String id);

    List<Sales> selectSales(String name);

    int deleteByPrimaryKey(String id);

    int insert(Sales record);

    int insertSelective(Sales record);

    int updateByPrimaryKeySelective(Sales record);

    int updateByPrimaryKey(Sales record);

    Integer selectSalesByDay(Integer day);

    List<Sales> selectAll();

    List<Sales> selectSales(@Param("page") Page page, @Param("sales") Sales record);

    Integer querySalesTotal();
}