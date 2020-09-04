package com.product.sc.proto;

import java.io.Serializable;

/**
 * @version: V1.0
 * @author: wbb
 * @className: CfPage
 * @packageName: proto
 * @description: 这是页面类
 * @data: 2020年8月14日11:11:15
 */

public class CfPage implements Serializable {
    private int total;
    private int pageSize;
    private int currentPage;

    public CfPage(int pageSize, int currentPage, int total) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.total = total;
    }

    public CfPage(int pageSize, int pageNumber) {
        this.pageSize = pageSize;
        this.currentPage = pageNumber;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
