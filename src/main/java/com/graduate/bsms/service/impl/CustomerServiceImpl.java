package com.graduate.bsms.service.impl;

import com.graduate.bsms.mapper.CustomerMapper;
import com.graduate.bsms.pojo.Customer;
import com.graduate.bsms.pojo.KeyAndValue;
import com.graduate.bsms.pojo.Page;
import com.graduate.bsms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 2018/5/6.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return customerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Customer record) {
        return customerMapper.insert(record);
    }

    @Override
    public int insertSelective(Customer record) {
        return 0;
    }

    @Override
    public Customer selectByPrimaryKey(String id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Customer record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Customer record) {
        return customerMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Customer> selectList(Page page, String name) {
        return customerMapper.selectList(page, name);
    }

    @Override
    public Integer queryCustomerTotal() {
        return customerMapper.queryCustomerTotal();
    }

    @Override
    public List<KeyAndValue> queryNameById() {
        return customerMapper.queryNameById();
    }
}
