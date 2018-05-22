package com.graduate.bsms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Admin on 2018/5/5.
 */
@Controller
public class MainController {
    @RequestMapping("showIndex")
    public String showIndex() {
        return "main/index";
    }
}
