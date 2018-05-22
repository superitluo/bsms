package com.graduate.bsms.pojo;

import java.io.Serializable;

/**
 * Created by Admin on 2018/5/22.
 */
public class BookNameAndId implements Serializable {
    private String bookId;
    private String bookName;

    public BookNameAndId() {
    }

    public BookNameAndId(String bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "BookNameAndId{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
