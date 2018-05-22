package com.graduate.bsms.service.impl;


import com.graduate.bsms.mapper.SalesMapper;
import com.graduate.bsms.pojo.Page;
import com.graduate.bsms.pojo.Sales;
import com.graduate.bsms.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesMapper salesMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return this.salesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Sales record) {
        String bookid = record.getBookid();
        String gkcardnumber= record.getGkcardnumber();
        Integer number = record.getNumber();
        Integer payStatus = record.getPaystatus();
        Integer shipStatus = record.getShipstatus();
        Double price = record.getPrice();
        Double totalPrice = record.getTotalprice();
        Integer returns = record.getReturns();
        String createuser = record.getCreateuser();
        Date createtime = record.getCreatetime();
        String updateuser = record.getUpdateuser();
        Date updatetime = record.getUpdatetime();
        if (bookid == null && number == null && payStatus == null && shipStatus == null && price == null && totalPrice == null && returns == null){
            return 0;
        }else {
            return this.salesMapper.insert(record);
        }
    }

    @Override
    public int insertSelective(Sales record) {
        return 0;
    }

    @Override
    public Sales selectByPrimaryKey(String id) {
        return this.salesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Sales record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Sales record) {
        String id = record.getId();
        String bookid = record.getBookid();
        String gkcardnumber= record.getGkcardnumber();
        Integer number = record.getNumber();
        Integer payStatus = record.getPaystatus();
        Integer shipStatus = record.getShipstatus();
        Double price = record.getPrice();
        Double totalPrice = record.getTotalprice();
        Integer returns = record.getReturns();
        String createuser = record.getCreateuser();
        Date createtime = record.getCreatetime();
        String updateuser = record.getUpdateuser();
        Date updatetime = record.getUpdatetime();
        if ( id == null ) {
            return -1;
        }
        if (bookid == null && number == null && payStatus == null && shipStatus == null && price == null && totalPrice == null && returns == null){
            return 0;
        }else {
            return this.salesMapper.updateByPrimaryKey(record);
        }
    }

    @Override
    public  List<Integer>  selectSalesByDayNumber(Integer dayNumber) {
        List<Integer>  number =new ArrayList<Integer>();
        for(int i=dayNumber-1;i>=0;i--){
            salesMapper.selectSalesByDay(i);
            if(salesMapper.selectSalesByDay(i)==null){
                number.add(0);
            }else{
                number.add(salesMapper.selectSalesByDay(i));
            }
        }
        return number;
    }

    @Override
    public List<Sales> selectAll() {
        return this.salesMapper.selectAll();
    }

    @Override
    public List<Sales> selectSales(Page page, Sales record) {
        return salesMapper.selectSales(page,record);
    }

    @Override
    public Integer querySalesTotal() {
        return salesMapper.querySalesTotal();
    }

    @Override
    public List<Sales> selectByStatus(Sales record) {
        return null;
    }
}
