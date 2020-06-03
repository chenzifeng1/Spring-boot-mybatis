package com.chenzifeng.learn.utils.page;

/**
 * @program: com.chenzifeng.learn.utils
 * @author: chenzifeng
 * @description:
 * @create: 2020-06-01 08:29
 **/

public class PageRequest {

    private int pageName;

    private int pageSize;

    public int getPageName() {
        return pageName;
    }

    public void setPageName(int pageName) {
        this.pageName = pageName;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
