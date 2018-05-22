package com.graduate.bsms.mapper;

import java.util.List;


import com.graduate.bsms.pojo.Book;
import com.graduate.bsms.pojo.KeyAndValue;
import com.graduate.bsms.pojo.Page;
import org.apache.ibatis.annotations.Param;

/**
 * 创建时间：2018年3月31日 下午9:09:50
 * 项目名称：bsms
 *
 * @author luomingjian
 * @version 1.0
 * @since JDK 1.6.0_21
 * 文件名称：BookMapper.java
 * 类说明：  图书映射类
 */
public interface BookMapper {
    List<Book> queryBookList(@Param("page") Page page, @Param("bookName") String bookName);

    void deleteBook(String bookId);

    void addBook(Book book);

    Integer queryBookTotal();

    Book queryBookById(String bookId);

    void updateBook(Book book);

    List<KeyAndValue> queryNameById();

    Integer queryCustomerTotal();
}
