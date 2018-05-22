package com.graduate.bsms.mapper;

import java.util.List;

import com.graduate.bsms.pojo.BookType;
import com.graduate.bsms.pojo.Page;

public interface BookTypeMapper {
    void addBookType(BookType bookType);        //添加图书类型

    List<BookType> queryUsableBookTypeList(Page page);    //获得可用的图书类型列表

    List<BookType> queryUnusableBookTypeList(Page page);        //获得所有的图书类型列表

    void removeBookTypeById(int bookTypeId);    //根据id移除图书类型

    int queryUsableBookTotal();    //查询可用类型记录数

    int queryUnusableBookTotal();//查询不可用类型记录数

    void removeAllBookType();//将所有的类型的状态设置为不使用

    void addAllBookType();//将所有的类型的状态设置为可以使用

    void setToUsable(int bookTypeId);//将指定的类型的状态设置为可以使用

    void setToUnusable(int bookTypeIds);//将指定的类型的状态设置为不可以使用

    List<BookType> queryAllBookType();//查找所有的图书类型
}
