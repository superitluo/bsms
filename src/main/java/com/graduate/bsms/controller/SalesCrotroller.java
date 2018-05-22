package com.graduate.bsms.controller;

import com.graduate.bsms.pojo.*;
import com.graduate.bsms.service.SalesService;
import com.graduate.bsms.util.PageUtil;
import com.graduate.bsms.util.UUIDFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("sales")
public class SalesCrotroller {

    @Autowired
    private SalesService salesService;


    @RequestMapping(value = "showIndex", method = RequestMethod.GET)
    public String showIndex(Model model) {
        return "sales/index";
    }

    @RequestMapping(value = "showAddSales", method = RequestMethod.GET)
    public String showAddSales(Model model) {
        return "sales/add";
    }

    @RequestMapping(value = "showUpdateSales", method = RequestMethod.GET)
    public String showUpdateSales(Model model, @RequestParam(value = "id") String id) {
        model.addAttribute("id", id);
        return "sales/update";
    }

    @RequestMapping(value = "showCount", method = RequestMethod.GET)
    public String showCount(Model model) {
        return "sales/count";
    }

    @RequestMapping(value = "salesDeleteById", method = RequestMethod.POST)
    public @ResponseBody
    int deleteByPrimaryKey(String id) throws Exception {
        return this.salesService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "salesInsert", method = RequestMethod.POST)
    public @ResponseBody
    int insert(String bookId, String gkcardnumber, Integer number, Integer payStatus, Integer shipStatus, Double price,
               Double totalPrice, Integer returns, HttpSession session) throws Exception {
        System.out.println(totalPrice);
        Sales parameter = new Sales();
        parameter.setId(UUIDFactory.getUUID());
        parameter.setBookid(bookId);
        parameter.setNumber(number);
        parameter.setGkcardnumber(gkcardnumber);
        parameter.setPaystatus(payStatus);
        parameter.setShipstatus(shipStatus);
        parameter.setPrice(price);
        parameter.setTotalprice(totalPrice);
        parameter.setReturns(returns);
        User user = (User) session.getAttribute("user");
        parameter.setCreateuser(user.getId().toString());
        parameter.setUpdateuser(null);
        //设置时间格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = formatter.format(new Date()); //系统时间
        Date date = formatter.parse(s);
        parameter.setCreatetime(date);
        parameter.setUpdatetime(null);
        parameter.setStatus(1);
        return this.salesService.insert(parameter);
    }

    @RequestMapping(value = "salesById", method = RequestMethod.GET)
    public @ResponseBody
    Sales selectByPrimaryKey(String id) throws Exception {
        return this.salesService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "salesUpdate", method = RequestMethod.POST)
    public @ResponseBody
    int updateByPrimaryKey(String id, String bookId, String gkcardnumber, Integer number, Integer payStatus, Integer shipStatus, Double price,
                           Double totalPrice, Integer returns, HttpSession session
    ) throws Exception {
        Sales parameter = new Sales();
        parameter.setId(id);
        parameter.setBookid(bookId);
        parameter.setNumber(number);
        parameter.setGkcardnumber(gkcardnumber);
        parameter.setPaystatus(payStatus);
        parameter.setShipstatus(shipStatus);
        parameter.setPrice(price);
        parameter.setTotalprice(totalPrice);
        parameter.setReturns(returns);
        parameter.setStatus(1);
        User user = (User) session.getAttribute("user");
        parameter.setUpdateuser(user.getId().toString());
        //设置时间格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = formatter.format(new Date()); //系统时间
        Date date = formatter.parse(s);
        parameter.setUpdatetime(date);
        return this.salesService.updateByPrimaryKey(parameter);
    }

    @RequestMapping(value = "salesAll", method = RequestMethod.GET)
    public @ResponseBody
    List<Sales> selectAll() {
        return this.salesService.selectAll();
    }

    @RequestMapping(value = "selectSales", method = RequestMethod.POST)
    public @ResponseBody
    TablePage selectSales(@RequestParam("pageSize") int pageSize,
                          @RequestParam("pageCurrent") int pageCurrent,
                          Integer payStatus, Integer shipStatus, Integer returns) {
        Page page = PageUtil.getPage(pageCurrent, pageSize);
        Sales sales = new Sales();
        sales.setPaystatus(payStatus);
        sales.setShipstatus(shipStatus);
        sales.setReturns(returns);
        sales.setStatus(1);

        List<Sales> list = salesService.selectSales(page, sales);
        int totalRow = salesService.querySalesTotal();
        return new TablePage<>(list, pageCurrent, pageSize, totalRow);
    }

    @RequestMapping(value = "selectSalesByDayNumber", method = RequestMethod.POST)
    public @ResponseBody
    List<Integer> selectSalesWeek(Integer number) {
        return this.salesService.selectSalesByDayNumber(number);
    }

}
