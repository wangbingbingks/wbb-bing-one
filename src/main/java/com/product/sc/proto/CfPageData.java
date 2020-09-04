package com.product.sc.proto;

import java.io.Serializable;
import java.util.List;

/**
 * @version: V1.0
 * @author: wbb
 * @className: CfPageData
 * @packageName: proto
 * @description: 这是页面数据类
 * @data: 2020-8-14 11:11:52
 */

public class CfPageData implements Serializable {
    private CfPage page;
    private List<?> list;

    public CfPage getPage() {
        return page;
    }

    public void setPage(CfPage page) {
        this.page = page;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
