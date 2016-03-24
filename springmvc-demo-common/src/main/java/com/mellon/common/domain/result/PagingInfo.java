package com.mellon.common.domain.result;

import java.io.Serializable;

/**
 * The Class of paging result
 *
 * @author mellon
 * @version 1.0
 */
public class PagingInfo implements Serializable {

    /**
     * 缺省页大小
     */
    public static final int DEFAULT_PAGE_SIZE = 20;

    /**
     * 页大小
     */
    private int pageSize;
    /**
     * 总数
     */
    private int totalRecord;
    /**
     * 当前页
     */
    private int pageIndex;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 排序
     */
    private String orderBy;

    /**
     * 排序升降序
     */
    private Boolean desc;

    public int getPageSize() {
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalPage = (totalRecord + getPageSize() - 1) / getPageSize();
        this.totalRecord = totalRecord;
    }

    public int getPageIndex() {
        if (pageIndex < 1) {
            pageIndex = 1;
        } else if (pageIndex > getTotalPage()) {
            pageIndex = getTotalPage();
        }

        return pageIndex;
    }

    /**
     * 获取传进来的原始的pageIndex
     * @return int
     */
    public int getOriginalPageIndex() {
        return pageIndex;
    }

    public boolean hasNextPage() {
        if (pageIndex <= getTotalPage()) {
            return true;
        } else {
            return false;
        }
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * oracleDB开始位置
     *
     * @return
     */
    public int getStartPos() {
        int cPage = getPageIndex();

        if (cPage <= 1) {
            return 1;
        }

        cPage--;

        int pgSize = getPageSize();

        return (pgSize * cPage) + 1;
    }

    /**
     * mysqlDB开始位置
     *
     * @return
     */
    public int getStartPosForMysql() {
        int cPage = getPageIndex();

        if (cPage <= 1) {
            return 0;
        }

        cPage--;

        int pgSize = getPageSize();

        return (pgSize * cPage);
    }

    /**
     * 结束位置
     *
     * @return
     */
    public int getEndPos() {
        if (getPageIndex() * getPageSize() < getTotalRecord()) {
            return getPageIndex() * getPageSize();
        } else {
            return getTotalRecord();
        }
    }

    /**
     * 总页数
     * @return
     */
    public int getTotalPage() {
        return totalPage;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Boolean getDesc() {
        return desc;
    }

    public void setDesc(Boolean desc) {
        this.desc = desc;
    }
}
