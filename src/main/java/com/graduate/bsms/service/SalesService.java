package com.graduate.bsms.service;

import com.graduate.bsms.pojo.Page;
import com.graduate.bsms.pojo.Sales;

import java.util.List;

public interface SalesService {

    int deleteByPrimaryKey(String id);

    int insert(Sales record);

    int insertSelective(Sales record);

    Sales selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Sales record);

    int updateByPrimaryKey(Sales record);

    List<Integer> selectSalesByDayNumber(Integer dayNumber);

    List<Sales> selectAll();

    List<Sales> selectSales(Page page, Sales record);

    Integer querySalesTotal();

    List<Sales> selectByStatus(Sales record);

}
