package com.graduate.bsms.controller;

import com.graduate.bsms.pojo.*;
import com.graduate.bsms.service.LogsService;
import com.graduate.bsms.service.UserService;
import com.graduate.bsms.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserCrotroller {

    @Autowired
    private UserService userService;
    @Autowired
    private LogsService logsService;

    @RequestMapping(value = "showIndex", method = RequestMethod.GET)
    public String showIndex(Model model) {
        return "user/index";
    }

    @RequestMapping(value = "showAddUser", method = RequestMethod.GET)
    public String showAddUser(Model model) {
        return "user/add";
    }

    @RequestMapping(value = "showUpdateUser", method = RequestMethod.GET)
    public String showUpdateUser(Model model, @RequestParam(value = "id") String id) {
        model.addAttribute("id", id);
        return "user/update";
    }

    @RequestMapping(value = "userDeleteById", method = RequestMethod.POST)
    public @ResponseBody
    int deleteByPrimaryKey(Long id) throws Exception {
        return this.userService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "userInsert", method = RequestMethod.POST)
    public @ResponseBody
    int insert(String usercode, String username, Integer gender, String birthday, String phone,
               String address, Integer userrole, HttpSession session) throws Exception {
        User parameter = new User();
        parameter.setUsercode(usercode);
        parameter.setUsername(username);
        parameter.setUserpassword("123456");
        parameter.setGender(gender);
        //设置时间格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String s = formatter.format(new Date()); //系统时间
        Date date = formatter.parse(s);
        Date bir = formatter.parse(birthday);
        parameter.setBirthday(bir);
        parameter.setPhone(phone);
        parameter.setAddress(address);
        parameter.setUserrole(userrole);
        User user = (User) session.getAttribute("user");
        parameter.setCreatedby(user.getId());
        parameter.setModifyby(null);
        parameter.setCreationdate(date);
        parameter.setModifydate(null);
        return this.userService.insert(parameter);
    }

    @RequestMapping(value = "userById", method = RequestMethod.GET)
    public @ResponseBody
    User selectByPrimaryKey(Long id) throws Exception {
        return this.userService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "userUpdate", method = RequestMethod.POST)
    public @ResponseBody
    int updateByPrimaryKey(
            Long id, String username, Integer gender, String birthday, String phone,
            String address, Integer userrole, HttpSession session) throws Exception {
        User parameter = new User();
        parameter.setId(id);
        parameter.setUsername(username);
        parameter.setGender(gender);
        //设置时间格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String s = formatter.format(new Date()); //系统时间
        Date date = formatter.parse(s);
        Date bir = formatter.parse(birthday);
        parameter.setBirthday(bir);
        parameter.setPhone(phone);
        parameter.setAddress(address);
        parameter.setUserrole(userrole);
        User user = (User) session.getAttribute("user");
        parameter.setModifyby(user.getId());
        parameter.setModifydate(date);
        return this.userService.updateByPrimaryKey(parameter);
    }

    @RequestMapping(value = "userList", method = RequestMethod.GET)
    public @ResponseBody
    List<User> selectList() {
        return this.userService.selectList();
    }

    @RequestMapping(value = "selectUser", method = RequestMethod.POST)
    public @ResponseBody
    TablePage selectUser(@RequestParam("pageSize") int pageSize,
                         @RequestParam("pageCurrent") int pageCurrent,
                         String username) {
        Page page = PageUtil.getPage(pageCurrent, pageSize);
        List<User> list = userService.selectUser(page, username);
        int totalRow = userService.queryUserTotal();
        return new TablePage<>(list, pageCurrent, pageSize, totalRow);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public @ResponseBody
    User Login(String usercode, String userpassword, String ip, Model model, HttpSession session) {
        User parameter = new User();
        parameter.setUsercode(usercode);
        parameter.setUserpassword(userpassword);
        Logs logs = new Logs();
        logs.setOperationtype("登录操作");
        logs.setIp("127.0.0.1");
        logs.setOperationuserid(usercode);
        logs.setOperationdate(new Date());
        User user = this.userService.Login(parameter);
        if (user != null) {
            logs.setOperationresult("成功");
            session.setAttribute("user", user);
        } else {
            logs.setOperationresult("失败");
        }
        logsService.insert(logs);
        return this.userService.Login(parameter);
    }

    @RequestMapping(value = "updatePassword.json", method = {RequestMethod.POST})
    public @ResponseBody
    int updatePassword(String usercode, String userpassword) {
        User parameter = new User();
        parameter.setUsercode(usercode);
        parameter.setUserpassword(userpassword);
        return this.userService.updatePassword(parameter);
    }
}
