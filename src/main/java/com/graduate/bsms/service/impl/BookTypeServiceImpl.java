package com.graduate.bsms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduate.bsms.mapper.BookTypeMapper;
import com.graduate.bsms.pojo.BookType;
import com.graduate.bsms.pojo.Page;
import com.graduate.bsms.service.BookTypeService;

@Service
public class BookTypeServiceImpl implements BookTypeService {
    @Autowired
    BookTypeMapper bookTypeMapper;

    @Override
    public List<BookType> queryUsableBookTypeList(Page page) {
        return bookTypeMapper.queryUsableBookTypeList(page);
    }

    @Override
    public List<BookType> queryUnusableBookTypeList(Page page) {
        return bookTypeMapper.queryUnusableBookTypeList(page);
    }

    @Override
    public void removeBookTypeById(int bookTypeId) {
        bookTypeMapper.removeBookTypeById(bookTypeId);
    }

    @Override
    public void addBookType(String bookTypeName) {
        bookTypeMapper.addBookType(new BookType(0, null, bookTypeName, null, 0));
    }

    @Override
    public int queryUsableBookTotal() {
        return bookTypeMapper.queryUsableBookTotal();
    }

    @Override
    public int queryUnusableBookTotal() {
        return bookTypeMapper.queryUnusableBookTotal();
    }

    @Override
    public void removeAllBookType() {
        bookTypeMapper.removeAllBookType();
    }

    @Override
    public void addAllBookType() {
        bookTypeMapper.addAllBookType();
    }

    @Override
    public void setToUsable(String bookTypeIds) {
        String[] ids2 = bookTypeIds.split(",");
        for (int i = 0; i < ids2.length; i++) {
            bookTypeMapper.setToUsable(Integer.parseInt(ids2[i]));
        }
    }

    @Override
    public void setToUnusable(String bookTypeIds) {
        String[] ids2 = bookTypeIds.split(",");
        for (int i = 0; i < ids2.length; i++) {
            bookTypeMapper.setToUnusable(Integer.parseInt(ids2[i]));
        }
    }

    @Override
    public List<BookType> queryAllBookType() {
        return bookTypeMapper.queryAllBookType();
    }


}
