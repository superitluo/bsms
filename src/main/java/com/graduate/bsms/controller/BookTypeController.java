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
import com.graduate.bsms.pojo.Result;
import com.graduate.bsms.pojo.TablePage;
import com.graduate.bsms.service.BookTypeService;
import com.graduate.bsms.util.PageUtil;

@Controller
@RequestMapping("bookType")
public class BookTypeController {
    @Autowired
    BookTypeService bookTypeService;

    @RequestMapping(value = "addBookType", method = RequestMethod.POST)
    public @ResponseBody
    Result addBookType(Model model, @RequestParam("bookTypeName") String bookTypeName) {
        if (bookTypeName == "" && bookTypeName.equals(null)) {
            return new Result(404, "类型名不能为空");
        } else {
            bookTypeService.addBookType(bookTypeName);
            return new Result(200, "添加图书类型成功");
        }
    }

    @RequestMapping("index")
    public String bookType(Model model) {
        return "datas/bookType";
    }

    @RequestMapping(value = "queryAllBookType")
    public @ResponseBody
    List<BookType> queryAllBookType(Model model) {
        return bookTypeService.queryAllBookType();
    }

    @RequestMapping(value = "queryUsableBookTypeList")
    public @ResponseBody
    TablePage queryUsableBookTypeList(Model model,
                                      @RequestParam("pageSize") int pageSize,
                                      @RequestParam("pageCurrent") int pageCurrent) {
        List<BookType> bookTypeList = bookTypeService.
                queryUsableBookTypeList(PageUtil.getPage(pageCurrent, pageSize));
        return new TablePage(bookTypeList, pageCurrent, pageSize, bookTypeService.queryUsableBookTotal());
    }

    @RequestMapping(value = "queryUnusableBookTypeList")
    public @ResponseBody
    TablePage queryUnusableBookTypeList(Model model,
                                        @RequestParam("pageSize") int pageSize,
                                        @RequestParam("pageCurrent") int pageCurrent) {
        List<BookType> bookTypeList = bookTypeService.queryUnusableBookTypeList(PageUtil.getPage(pageCurrent, pageSize));
        return new TablePage(bookTypeList, pageCurrent, pageSize, bookTypeService.queryUnusableBookTotal());
    }

    @RequestMapping("addAllBookType")
    public @ResponseBody
    Result addAllBookType(Model model) {
        bookTypeService.addAllBookType();
        return new Result(200, "全部移动成功！");
    }

    @RequestMapping("removeAllBookType")
    public @ResponseBody
    Result removeAllBookType(Model model) {
        bookTypeService.removeAllBookType();
        return new Result(200, "全部移动成功！");
    }

    @RequestMapping(value = "setToUsable", method = RequestMethod.POST)
    public @ResponseBody
    Result setToUsable(Model model, @RequestParam("bookTypeIds") String bookTypeIds) {
        bookTypeService.setToUsable(bookTypeIds);
        return new Result(200, "全部移动成功！");
    }

    @RequestMapping(value = "setToUnusable", method = RequestMethod.POST)
    public @ResponseBody
    Result setToUnusable(Model model, @RequestParam("bookTypeIds") String bookTypeIds) {
        bookTypeService.setToUnusable(bookTypeIds);
        return new Result(200, "全部移动成功！");
    }
}
