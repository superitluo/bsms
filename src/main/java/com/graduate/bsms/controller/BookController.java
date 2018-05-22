package com.graduate.bsms.controller;


import java.util.Date;

import java.util.List;

import com.graduate.bsms.pojo.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.graduate.bsms.service.BookService;
import com.graduate.bsms.util.PageUtil;
import com.graduate.bsms.util.UUIDFactory;

/**
 * 图书控制器
 *
 * @author lmj
 */

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    BookService bookService;

    //查询图书列表
    @RequestMapping(value = "queryBookListJson")
    public @ResponseBody
    TablePage queryBookListJson(Model model,
                                @RequestParam("pageSize") int pageSize,
                                @RequestParam("pageCurrent") int pageCurrent, String bookName) {
        Page page = PageUtil.getPage(pageCurrent, pageSize);
        List<Book> list = bookService.queryBookList(page, bookName);
        int totalRow = bookService.queryBookTotal();
        return new TablePage<>(list, pageCurrent, pageSize, totalRow);
    }

    //图书管理页面
    @RequestMapping("index")
    public String index(Model model) {
        return "book/index";
    }

    //编辑图书页面
    @RequestMapping(value = "updateBook", method = RequestMethod.GET)
    public String updateBook(Model model, @RequestParam("bookId") String bookId) {
        System.out.println(bookService.queryBookById(bookId));
        model.addAttribute("book", bookService.queryBookById(bookId));
        return "book/addBook";
    }

    //查看图书页面
    @RequestMapping("detailBookJsp")
    public String detailBookJsp(Model model, @RequestParam("bookId") String bookId) {
        model.addAttribute("book", bookService.queryBookById(bookId));
        return "book/detailBook";
    }

    //删除图书
    @RequestMapping(value = "deleteBook", method = RequestMethod.POST)
    public @ResponseBody
    String deleteBook(Model model, String ids) {
        bookService.deleteBook(ids);
        return "{\"status\":1}";
    }

    @RequestMapping("addBookJsp")
    public String addBookJsp(Model model) {
        return "book/addBook";
    }

    //添加图书和编辑图书
    @RequestMapping(value = "addBook", method = RequestMethod.POST)
    public @ResponseBody
    Result addBook(Model model,
                   @RequestParam("bookId") String bookId,
                   @RequestParam("isbn") String isbn,
                   @RequestParam("bookName") String bookName,
                   @RequestParam("author") String author,
                   @RequestParam("publishId") String publishId,
                   @RequestParam("typeId") String typeId,
                   @RequestParam("bookPrice") String bookPrice,
                   @RequestParam("blurb") String blurb,
                   @RequestParam("imageUrl1") String imageUrl1,
                   @RequestParam("imageUrl2") String imageUrl2,
                   @RequestParam("imageUrl3") String imageUrl3
    ) {
        Book book = new Book(bookId, null, author, blurb, bookName, Double.valueOf(bookPrice), imageUrl1, imageUrl2,
                imageUrl3, isbn, Integer.valueOf(publishId), new Date(), 0, Integer.valueOf(typeId));
        System.out.println(book);
        if (bookId.equals(null) || bookId == "") {
            book.setBookId(UUIDFactory.getUUID());
            bookService.addBook(book);
            return (new Result(200, "添加图书成功!"));
        } else {
            book.setBookId(bookId);
            bookService.updateBook(book);
            return new Result(200, "修改图书信息成功!");
        }
    }

    @RequestMapping(value = "queryNameById", method = RequestMethod.GET)
    public @ResponseBody
    List<KeyAndValue> queryNameById() {
        return bookService.queryNameById();
    }

    @RequestMapping(value = "queryBookById", method = RequestMethod.GET)
    public @ResponseBody
    Book queryBookById(String id) {
        return bookService.queryBookById(id);
    }
}
