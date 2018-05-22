package com.graduate.bsms.pojo;

import java.io.Serializable;

public class Page implements Serializable {
    private static final long serialVersionUID = 1L;
    private int pageStart;
    private int pageSize;

    public Page() {
        super();
    }

    public Page(int pageNumber, int pageSize) {
        super();
        this.pageSize = pageSize;
        this.pageStart = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageStart;
    }

    public void setPageNumber(int pageNumber) {
        this.pageStart = pageNumber;
    }

    @Override
    public String toString() {
        return "Page [pageSize=" + pageSize + ", pageNumber=" + pageStart + "]";
    }

}
