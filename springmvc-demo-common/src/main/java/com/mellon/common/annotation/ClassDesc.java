package com.mellon.common.annotation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClassDesc implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    //第一级分类
    String firstCate;
    //类的全路径名称
    String className;
    //资源名称列表
    List<MethodDesc> children = new ArrayList<MethodDesc>();
    
    public String getFirstCate() {
        return firstCate;
    }
    public void setFirstCate(String firstCate) {
        this.firstCate = firstCate;
    }
    public List<MethodDesc> getChildren() {
        return children;
    }
    public void setChildren(List<MethodDesc> children) {
        this.children = children;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
}
