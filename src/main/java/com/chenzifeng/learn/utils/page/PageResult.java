package com.chenzifeng.learn.utils.page;

import java.util.List;

/**
 * @program: com.chenzifeng.learn.utils
 * @author: chenzifeng
 * @description:
 * @create: 2020-06-01 08:31
 **/

public class PageResult {

    /**
     * 当前有页码
     */
    private int pageNum;

    /**
     * 每页行数
     */
    private int pageRow;
    /**
     * 记录总数
     */
    private int totalNum;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 使用List作为存放记录的数据结构
     */
    private List<?> contents;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageRow() {
        return pageRow;
    }

    public void setPageRow(int pageRow) {
        this.pageRow = pageRow;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<?> getContents() {
        return contents;
    }

    public void setContents(List<?> contents) {
        this.contents = contents;
    }
}
