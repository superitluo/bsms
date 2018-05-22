package com.graduate.bsms.service;

import java.util.List;

import com.graduate.bsms.pojo.Publish;
import com.graduate.bsms.pojo.Page;

/**
 * 创建时间：2018年3月28日 下午7:16:20
 * 项目名称：bsms
 *
 * @author luomingjian
 * @version 1.0
 * @since JDK 1.6.0_21
 * 文件名称：PublishService.java
 * 类说明：  图书类型业务接口类
 */
public interface PublishService {
    void addPublish(String publishName);        //添加图书类型

    List<Publish> queryUsablePublishList(Page page);    //获得可用的图书类型列表

    List<Publish> queryUnusablePublishList(Page page);        //获得所有的图书类型列表

    void removePublishById(int publishId);                //根据id移除图书类型

    int queryUsablePublishTotal();    //查询可用类型记录数

    int queryUnusablePublishTotal();//查询不可用类型记录数

    void removeAllPublish();//将所有的类型的状态设置为不使用

    void addAllPublish();//将所有的类型的状态设置为可以使用

    void setToUsable(String publishIds);//将指定的类型的状态设置为可以使用

    void setToUnusable(String publishIds);//将指定的类型的状态设置为不可以使用

    List<Publish> queryAllPublish();//查找所有的图书出版社
}
