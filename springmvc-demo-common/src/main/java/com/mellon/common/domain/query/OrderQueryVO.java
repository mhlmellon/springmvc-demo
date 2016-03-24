package com.mellon.common.domain.query;

import java.io.Serializable;

/**
 * 
 * 排序参数封装类<br> 
 * 封装排序参数，重写了equals和hashCode和compareTo方法，
 *
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class OrderQueryVO implements Comparable<OrderQueryVO>, Serializable {
    /**
     */
    private static final long serialVersionUID = 1L;
    /**
     * 排序的字段，是数据库表中的字段
     */
    private String field;
    /**
     * 排序的先后顺序，数字越小，就优先排序。
     */
    private Integer index;
    /**
     * 排序的顺逆，0代表desc，其它就是asc
     */
    private Integer order;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public int compareTo(OrderQueryVO o) {
        return this.index - o.getIndex();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((field == null) ? 0 : field.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OrderQueryVO other = (OrderQueryVO) obj;
        if (field == null) {
            if (other.field != null) {
                
                return false;
            }
        } else if (!field.equals(other.field)) {
            
            return false;
        }
        return true;
    }

}
