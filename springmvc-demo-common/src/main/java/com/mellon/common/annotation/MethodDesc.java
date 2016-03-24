package com.mellon.common.annotation;

import java.io.Serializable;
import java.util.List;

public class MethodDesc implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    // 资源名称
    String name;
    // 资源地址
    String urlPath;
    // 方法名称
    String methodName;
    // 参数名称
    List<String> args;

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
