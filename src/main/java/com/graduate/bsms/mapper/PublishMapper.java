package com.graduate.bsms.mapper;

import java.util.List;

import com.graduate.bsms.pojo.Publish;
import com.graduate.bsms.pojo.BookType;
import com.graduate.bsms.pojo.Page;

public interface PublishMapper {
    void addPublish(Publish Publish);        //添加图书类型

    List<Publish> queryUsablePublishList(Page page);    //获得可用的图书类型列表

    List<Publish> queryUnusablePublishList(Page page);        //获得所有的图书类型列表

    void removePublishById(int publishId);    //根据id移除图书类型

    int queryUsablePublishTotal();    //查询可用类型记录数

    int queryUnusablePublishTotal();//查询不可用类型记录数

    void removeAllPublish();//将所有的类型的状态设置为不使用

    void addAllPublish();//将所有的类型的状态设置为可以使用

    void setToUsable(int publishId);//将指定的类型的状态设置为可以使用

    void setToUnusable(int publishIds);//将指定的类型的状态设置为不可以使用

    List<Publish> queryAllPublish();//查找所有的图书出版社
}
