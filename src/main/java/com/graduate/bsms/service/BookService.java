package com.graduate.bsms.service;

import java.util.List;

import com.graduate.bsms.pojo.Book;
import com.graduate.bsms.pojo.KeyAndValue;
import com.graduate.bsms.pojo.Page;

public interface BookService {
    List<Book> queryBookList(Page page, String book);

    Integer queryBookTotal();

    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(String bookIds);

    Book queryBookById(String bookId);

    List<KeyAndValue> queryNameById();
}
