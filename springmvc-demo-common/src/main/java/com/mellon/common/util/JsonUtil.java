package com.mellon.common.util;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@SuppressWarnings("rawtypes") 
public class JsonUtil {
    /**
     * 将java对象转换成json字符串
     * 
     * @param javaObj
     * @return
     */
    public static String getJsonString4JavaPOJO(Object javaObj) {
        JSONObject json;
        json = JSONObject.fromObject(javaObj);
        return json.toString();
    }
    
    public static Object getObject4JsonString(String jsonString, Class pojoCalss) {
        Object pojo;
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        pojo = JSONObject.toBean(jsonObject, pojoCalss);
        return pojo;
    }
    
    @SuppressWarnings("unchecked")
    public static List getList4Json(String jsonString, Class pojoClass) {
        JSONArray jsonArray = JSONArray.fromObject(jsonString);
        JSONObject jsonObject;
        Object pojoValue;
        List list = new ArrayList();
        for (int i = 0; i < jsonArray.size(); i++) {
            jsonObject = jsonArray.getJSONObject(i);
            pojoValue = JSONObject.toBean(jsonObject, pojoClass);
            list.add(pojoValue);
        }
        return list;
    }
    
    public static String getJsonArray4JavaList(List list) {
        JSONArray jsonArray;
        jsonArray = JSONArray.fromObject(list);
        String jsonArrayStr = jsonArray.toString();
        jsonArrayStr = jsonArrayStr.substring(jsonArrayStr.indexOf("["));
        return jsonArray.toString();
    }
}
