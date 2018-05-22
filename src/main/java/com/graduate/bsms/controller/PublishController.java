package com.graduate.bsms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.graduate.bsms.pojo.BookType;
import com.graduate.bsms.pojo.Publish;
import com.graduate.bsms.pojo.Result;
import com.graduate.bsms.pojo.TablePage;
import com.graduate.bsms.service.PublishService;
import com.graduate.bsms.util.PageUtil;

@Controller
@RequestMapping("publish")
public class PublishController {
    @Autowired
    PublishService publishService;

    @RequestMapping(value = "addPublish", method = RequestMethod.POST)
    public @ResponseBody
    Result addPublish(Model model, @RequestParam("publishName") String publishName) {
        if (publishName == "" && publishName.equals(null)) {
            return new Result(404, "出版社名不能为空");
        } else {
            publishService.addPublish(publishName);
            return new Result(200, "添加图书出版社成功");
        }
    }

    @RequestMapping("index")
    public String publish(Model model) {
        return "datas/publish";
    }

    @RequestMapping(value = "queryAllPublish")
    public @ResponseBody
    List<Publish> queryAllBookType(Model model) {
        return publishService.queryAllPublish();
    }

    @RequestMapping(value = "queryUsablePublishList")
    public @ResponseBody
    TablePage queryUsablePublishList(Model model,
                                     @RequestParam("pageSize") int pageSize,
                                     @RequestParam("pageCurrent") int pageCurrent) {
        List<Publish> publishList = publishService.
                queryUsablePublishList(PageUtil.getPage(pageCurrent, pageSize));
        return new TablePage(publishList, pageCurrent, pageSize, publishService.queryUsablePublishTotal());
    }

    @RequestMapping(value = "queryUnusablePublishList")
    public @ResponseBody
    TablePage queryUnusablePublishList(Model model,
                                       @RequestParam("pageSize") int pageSize,
                                       @RequestParam("pageCurrent") int pageCurrent) {
        List<Publish> publishList = publishService.queryUnusablePublishList(PageUtil.getPage
                (pageCurrent, pageSize));
        return new TablePage(publishList, pageCurrent, pageSize, publishService.queryUnusablePublishTotal());
    }

    @RequestMapping("addAllPublish")
    public @ResponseBody
    Result addAllPublish(Model model) {
        publishService.addAllPublish();
        return new Result(200, "全部移动成功！");
    }

    @RequestMapping("removeAllPublish")
    public @ResponseBody
    Result removeAllPublish(Model model) {
        publishService.removeAllPublish();
        return new Result(200, "全部移动成功！");
    }

    @RequestMapping(value = "setToUsable", method = RequestMethod.POST)
    public @ResponseBody
    Result setToUsable(Model model, @RequestParam("publishIds") String publishIds) {
        publishService.setToUsable(publishIds);
        return new Result(200, "全部移动成功！");
    }

    @RequestMapping(value = "setToUnusable", method = RequestMethod.POST)
    public @ResponseBody
    Result setToUnusable(Model model, @RequestParam("publishIds") String publishIds) {
        publishService.setToUnusable(publishIds);
        return new Result(200, "全部移动成功！");
    }
}
