package com.graduate.bsms.service;

import com.graduate.bsms.pojo.Customer;
import com.graduate.bsms.pojo.KeyAndValue;
import com.graduate.bsms.pojo.Page;

import java.util.List;

/**
 * Created by Admin on 2018/5/6.
 */
public interface CustomerService {
    int deleteByPrimaryKey(String id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    List<Customer> selectList(Page page, String name);

    Integer queryCustomerTotal();

    List<KeyAndValue> queryNameById();
}
