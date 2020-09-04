package com.product.sc.proto;

/**
 * @version: V1.0
 * @author: wbb
 * @className: PageBean
 * @packageName: proto
 * @description: 这是处理页数页面容量数据类
 * @data: 2020-8-14 11:12:31
 */

public class PageBean {
    private static final String TAG = "PageBean";

    /**
     * 页面容量：一页显示的记录数
     */
    private int pageSize = 10;
    /**
     * 当前页：当前页码
     */
    private int currentPage = 1;
    /**
     * 从第几行开始显示：起始行数
     */
    private int startIndex = 0;

    PageBean() {

    }

    public PageBean(int pageSize, int currentPage) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.setStartIndex();
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return currentPage;
    }

    public void setPageNumber(int pageNumber) {
        if (pageNumber > 0) {
            this.currentPage = pageNumber;
        } else {
            this.currentPage = 1;
        }
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex() {
        this.startIndex = (currentPage - 1) * pageSize;
    }
}
