package com.graduate.bsms.controller;

import com.graduate.bsms.pojo.Role;
import com.graduate.bsms.pojo.User;
import com.graduate.bsms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("showIndex")
    public String showIndex() {
        return "role/index";
    }

    @RequestMapping(value = "showAddRole", method = RequestMethod.GET)
    public String showAddProduct() {
        return "role/add";
    }

    @RequestMapping(value = "showUpdateRole", method = RequestMethod.GET)
    public String showUpdateRole(Model model, String id) {
        model.addAttribute("id", id);
        return "role/update";
    }

    @RequestMapping(value = "roleDeleteById", method = RequestMethod.POST)
    public @ResponseBody
    int deleteByPrimaryKey(Long id) throws Exception {
        return this.roleService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "roleInsert", method = RequestMethod.POST)
    public @ResponseBody
    int insert(String rolecode, String rolename,
               HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");
        Role parameter = new Role();
        parameter.setRolecode(rolecode);
        parameter.setRolename(rolename);
        parameter.setCreatedby(user.getId().toString());
        parameter.setModifyby(null);
        //设置时间格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = formatter.format(new Date()); //系统时间
        Date date = formatter.parse(s);
        parameter.setCreationdate(date);
        parameter.setModifydate(null);
        return this.roleService.insert(parameter);
    }

    @RequestMapping(value = "roleById", method = RequestMethod.POST)
    public @ResponseBody
    Role selectByPrimaryKey(Long id) throws Exception {
        return this.roleService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "roleUpdate", method = RequestMethod.POST)
    public @ResponseBody
    int updateByPrimaryKey(Long id, String rolecode, String rolename, HttpSession session
    ) throws Exception {
        Role parameter = new Role();
        User user = (User) session.getAttribute("user");
        parameter.setId(id);
        parameter.setRolecode(rolecode);
        parameter.setRolename(rolename);
        parameter.setModifyby(user.getId().toString());
        //设置时间格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = formatter.format(new Date()); //系统时间
        Date date = formatter.parse(s);
        parameter.setModifydate(date);
        return this.roleService.updateByPrimaryKey(parameter);
    }

    @RequestMapping(value = "roleAll", method = RequestMethod.GET)
    public @ResponseBody
    List<Role> selectAll() {
        return this.roleService.selectAll();
    }

}
