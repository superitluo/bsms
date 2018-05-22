package com.graduate.bsms.controller;

import com.graduate.bsms.pojo.*;
import com.graduate.bsms.service.CustomerService;
import com.graduate.bsms.util.PageUtil;
import com.graduate.bsms.util.UUIDFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 2018/5/15.
 */
@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String showIndex(Model model) {
        return "customer/index";
    }

    @RequestMapping(value = "showAdd", method = RequestMethod.GET)
    public String showAdd(Model model) {
        return "customer/add";
    }

    @RequestMapping(value = "showUpdate", method = RequestMethod.GET)
    public String showUpdateCustomerr(Model model, @RequestParam(value = "id") String id) {
        model.addAttribute("id", id);
        return "customer/update";
    }

    @RequestMapping(value = "customerById", method = RequestMethod.GET)
    public @ResponseBody
    Customer selectByPrimaryKey(String id) throws Exception {
        return this.customerService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "selectList", method = RequestMethod.POST)
    public @ResponseBody
    TablePage selectList(@RequestParam("pageSize") int pageSize,
                         @RequestParam("pageCurrent") int pageCurrent,
                         String customername) {
        Page page = PageUtil.getPage(pageCurrent, pageSize);
        List<Customer> list = customerService.selectList(page, customername);
        int totalRow = customerService.queryCustomerTotal();
        return new TablePage<>(list, pageCurrent, pageSize, totalRow);
    }

    @RequestMapping(value = "customerInsert", method = RequestMethod.POST)
    public @ResponseBody
    int insert(String name, String cardnumber, Integer gender, String birthday, String phone,
               String address, String cardtypeid, HttpSession session) throws Exception {
        Customer customer = new Customer();
        customer.setId(UUIDFactory.getUUID());
        customer.setName(name);
        customer.setCardnumber(cardnumber);
        customer.setGender(gender);
        customer.setPhone(phone);
        customer.setAddress(address);
        customer.setCardtypeid(cardtypeid);
        //设置时间格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date bir = formatter.parse(birthday);
        customer.setBirthday(bir);
        User user = (User) session.getAttribute("user");
        customer.setCreatuserid(user.getId().toString());
        customer.setStatus(0);
        return this.customerService.insert(customer);
    }

    @RequestMapping(value = "customerUpdate", method = RequestMethod.POST)
    public @ResponseBody
    int updateByPrimaryKey(
            String id, String name, String cardnumber, Integer gender, String birthday, String phone,
            String address, String cardtypeid, HttpSession session) throws Exception {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setCardnumber(cardnumber);
        customer.setGender(gender);
        customer.setPhone(phone);
        customer.setAddress(address);
        customer.setCardtypeid(cardtypeid);
        //设置时间格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date bir = formatter.parse(birthday);
        customer.setBirthday(bir);
        User user = (User) session.getAttribute("user");
        customer.setUpdateuserid(user.getId().toString());
        customer.setStatus(0);
        return this.customerService.updateByPrimaryKey(customer);
    }

    @RequestMapping(value = "customerDeleteById", method = RequestMethod.POST)
    public @ResponseBody
    int deleteByPrimaryKey(String id) throws Exception {
        return this.customerService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "queryNameById", method = RequestMethod.GET)
    public @ResponseBody
    List<KeyAndValue> queryNameById() {
        return customerService.queryNameById();
    }
}
