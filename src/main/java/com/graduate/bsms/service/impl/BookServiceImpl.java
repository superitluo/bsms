package com.graduate.bsms.service.impl;

import java.util.List;

import com.graduate.bsms.mapper.BookMapper;
import com.graduate.bsms.pojo.KeyAndValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduate.bsms.pojo.Book;
import com.graduate.bsms.pojo.Page;
import com.graduate.bsms.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> queryBookList(Page page, String book) {
        return bookMapper.queryBookList(page, book);
    }

    @Override
    public Integer queryBookTotal() {
        return bookMapper.queryBookTotal();
    }

    @Override
    public void addBook(Book book) {
        bookMapper.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    @Override
    public void deleteBook(String bookIds) {
        String[] idsArray = bookIds.split(",");
        for (int i = 0; i < idsArray.length; i++) {
            bookMapper.deleteBook(idsArray[i]);
        }
    }

    @Override
    public Book queryBookById(String bookId) {
        return bookMapper.queryBookById(bookId);
    }

    @Override
    public  List<KeyAndValue> queryNameById(){
        return bookMapper.queryNameById();
    }


}
