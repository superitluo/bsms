package com.graduate.bsms.service;

import java.util.List;

import com.graduate.bsms.pojo.BookType;
import com.graduate.bsms.pojo.Page;

/**
 * 创建时间：2018年3月28日 下午7:16:20
 * 项目名称：bsms
 *
 * @author luomingjian
 * @version 1.0
 * @since JDK 1.6.0_21
 * 文件名称：BookTypeService.java
 * 类说明：  图书类型业务接口类
 */
public interface BookTypeService {
    void addBookType(String bookTypeName);        //添加图书类型

    List<BookType> queryUsableBookTypeList(Page page);    //获得可用的图书类型列表

    List<BookType> queryUnusableBookTypeList(Page page);        //获得所有的图书类型列表

    void removeBookTypeById(int bookTypeId);                //根据id移除图书类型

    int queryUsableBookTotal();    //查询可用类型记录数

    int queryUnusableBookTotal();//查询不可用类型记录数

    void removeAllBookType();//将所有的类型的状态设置为不使用

    void addAllBookType();//将所有的类型的状态设置为可以使用

    void setToUsable(String bookTypeIds);//将指定的类型的状态设置为可以使用

    void setToUnusable(String bookTypeIds);//将指定的类型的状态设置为不可以使用

    List<BookType> queryAllBookType();//查找所有的图书类型
}
