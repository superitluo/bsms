package com.graduate.bsms.mapper;


import com.graduate.bsms.pojo.Customer;
import com.graduate.bsms.pojo.KeyAndValue;
import com.graduate.bsms.pojo.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(String id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    List<Customer> selectList(@Param("page") Page page, @Param("name") String name);

    Integer queryCustomerTotal();

    List<KeyAndValue> queryNameById();
}