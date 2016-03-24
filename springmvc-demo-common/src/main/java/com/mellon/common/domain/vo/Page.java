package com.mellon.common.domain.vo;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public class Page<E> extends ArrayList<E> {
    private static final long serialVersionUID = 1L;
    private static final int NO_SQL_COUNT = -1;
    private static final int SQL_COUNT = 0;
    private int pageNum;
    private int pageSize;
    private int startRow;
    private int endRow;
    private long total;
    private int pages;
    private String orderBy;
    private Boolean reasonable;
    private Boolean pageSizeZero;

    public Page() {
    }

    public Page(int pageNum, int pageSize) {
        this(pageNum, pageSize, 0, (Boolean)null);
    }

    public Page(int pageNum, int pageSize, boolean count) {
        this(pageNum, pageSize, count?0:-1, (Boolean)null);
    }

    private Page(int pageNum, int pageSize, int total, Boolean reasonable) {
        super(pageSize > -1?pageSize:0);
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = (long)total;
        this.calculateStartAndEndRow();
        this.setReasonable(reasonable);
    }

    public Page(RowBounds rowBounds, boolean count) {
        this(rowBounds, count?0:-1);
    }

    public Page(RowBounds rowBounds, int total) {
        super(rowBounds.getLimit() > -1?rowBounds.getLimit():0);
        this.pageSize = rowBounds.getLimit();
        this.startRow = rowBounds.getOffset();
        this.total = (long)total;
        this.endRow = this.startRow + this.pageSize;
    }

    public List<E> getResult() {
        return this;
    }

    public int getPages() {
        return this.pages;
    }

    public int getEndRow() {
        return this.endRow;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = this.reasonable != null && this.reasonable.booleanValue() && pageNum <= 0?1:pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartRow() {
        return this.startRow;
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
        if(this.pageSize > 0) {
            this.pages = (int)(total / (long)this.pageSize + (long)(total % (long)this.pageSize == 0L?0:1));
        } else {
            this.pages = 0;
        }

        if(this.reasonable != null && this.reasonable.booleanValue() && this.pageNum > this.pages) {
            this.pageNum = this.pages;
            this.calculateStartAndEndRow();
        }

    }

    public void setReasonable(Boolean reasonable) {
        if(reasonable != null) {
            this.reasonable = reasonable;
            if(this.reasonable.booleanValue() && this.pageNum <= 0) {
                this.pageNum = 1;
                this.calculateStartAndEndRow();
            }

        }
    }

    public Boolean getReasonable() {
        return this.reasonable;
    }

    public Boolean getPageSizeZero() {
        return this.pageSizeZero;
    }

    public void setPageSizeZero(Boolean pageSizeZero) {
        this.pageSizeZero = pageSizeZero;
    }

    public String getOrderBy() {
        return this.orderBy;
    }

    private void calculateStartAndEndRow() {
        this.startRow = this.pageNum > 0?(this.pageNum - 1) * this.pageSize:0;
        this.endRow = this.startRow + this.pageSize * (this.pageNum > 0?1:0);
    }

    public boolean isCount() {
        return this.total > -1L;
    }

    public Page<E> pageNum(int pageNum) {
        this.pageNum = this.reasonable != null && this.reasonable.booleanValue() && pageNum <= 0?1:pageNum;
        return this;
    }

    public Page<E> pageSize(int pageSize) {
        this.pageSize = pageSize;
        this.calculateStartAndEndRow();
        return this;
    }

    public Page<E> count(Boolean count) {
        this.total = count.booleanValue()?0L:-1L;
        return this;
    }

    public Page<E> orderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public Page<E> reasonable(Boolean reasonable) {
        this.setReasonable(reasonable);
        return this;
    }

    public Page<E> pageSizeZero(Boolean pageSizeZero) {
        this.setPageSizeZero(pageSizeZero);
        return this;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("Page{");
        sb.append("pageNum=").append(this.pageNum);
        sb.append(", pageSize=").append(this.pageSize);
        sb.append(", startRow=").append(this.startRow);
        sb.append(", endRow=").append(this.endRow);
        sb.append(", total=").append(this.total);
        sb.append(", pages=").append(this.pages);
        sb.append(", orderBy=\'").append(this.orderBy).append('\'');
        sb.append(", reasonable=").append(this.reasonable);
        sb.append(", pageSizeZero=").append(this.pageSizeZero);
        sb.append('}');
        return sb.toString();
    }
}

