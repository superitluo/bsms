package com.graduate.bsms.controller;


import com.graduate.bsms.pojo.Logs;
import com.graduate.bsms.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 2018/5/2.
 */
@Controller
@RequestMapping("logs")
public class LogsController {
    @Autowired
    private LogsService logsService;

    @RequestMapping("showIndex")
    public String showIndex() {
        return "logs/index";
    }

    @RequestMapping("selectAllLogs")
    public @ResponseBody
    List<Logs> selectAllLogs() {
        return logsService.selectAll();
    }
}
