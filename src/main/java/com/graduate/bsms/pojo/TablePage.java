package com.graduate.bsms.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 创建时间：2018年3月28日 下午9:30:26
 * 项目名称：bsms
 *
 * @param <E>
 * @author luomingjian
 * @version 1.0
 * @since JDK 1.6.0_21
 * 文件名称：TablePage.java
 * 类说明：  表单分页类
 */
public class TablePage<E> implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<E> list;
    private int pageCurrent;
    private int pageSize;
    private int totalRow;

    public TablePage() {
        super();
        // TODO Auto-generated constructor stub
    }

    public TablePage(List<E> list, int pageCurrent, int pageSize, int totalRow) {
        super();
        this.list = list;
        this.pageCurrent = pageCurrent;
        this.pageSize = pageSize;
        this.totalRow = totalRow;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public int getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(int pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "TablePage [list=" + list + ", pageCurrent=" + pageCurrent + ", pageSize=" + pageSize + ", totalRow="
                + totalRow + "]";
    }


}
