package com.mellon.platform.goods.domain.goods.po;

import com.mellon.common.domain.query.PagingQuery;

import java.io.Serializable;
import java.util.Date;

public class GoodsPO implements Serializable {
    private Long id;

    private String code;

    private String name;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    private PagingQuery pagingQuery;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public PagingQuery getPagingQuery() {
        return pagingQuery;
    }
}