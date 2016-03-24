package com.mellon.common.domain.query;

import org.assertj.core.util.Collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



public class OrderQueryUtil {
    
    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param orderBy 排序的列表。
     * @param fieldSet 可排序的字段的集合
     * @param defaultOrderString  默认排序字符串，一般使用 " create_time desc"
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getOrderByString(List<OrderQueryVO> orderBy,Set<String> fieldSet,String defaultOrderString) {
        // 1 校验字段是否可排序。
        // 2 多字段排序顺序由入参列表自然确定
        // 3 拼接sql
        if (Collections.isNullOrEmpty(orderBy)) {// 处理前判断
            return defaultOrderString;
        }
        // 生成排序字段的集合用于过滤入参，防止入参中的非法字段
//        Set<String> sortFields = Arrays.stream(SORT_FIEDS.split(",")).collect(Collectors.toSet());
        orderBy = orderBy.stream().filter(order -> fieldSet.stream().anyMatch(str->str.contains(order.getField()))).distinct()
                .collect(Collectors.toList());
        if (Collections.isNullOrEmpty(orderBy)) {// 处理后判断
            return defaultOrderString;
        }
//        orderBy.sort((OrderQueryVO a, OrderQueryVO b) -> a.compareTo(b));
        // 产生sql语句
        String orderSql = "";
        for (int i = 0; i < orderBy.size() - 1; i++) {
            OrderQueryVO o = orderBy.get(i);
            orderSql += o.getField() + (o.getOrder() == 0 ? " desc" : " asc") + ",";
        }
        OrderQueryVO last = orderBy.get(orderBy.size() - 1);
        orderSql += last.getField() + (last.getOrder() == null || last.getOrder()== 0? " desc" : " asc");
        orderSql = orderSql.trim();
        // 返回的字段用于mybatis的动态sql语句。可用null测试
        return orderSql.equals("") ? defaultOrderString : orderSql;

    }
    /**
     * 测试方法
     */
//    public static void main(String[] args) {
//        OrderQueryVO order1 = new OrderQueryVO();
//        order1.setField("create_time");
//        List<OrderQueryVO> orderBy = Arrays.asList(order1);
//        String str = getOrderByString(orderBy,new HashSet(Arrays.asList("temp.create_time","supplier_id")),null);
//        System.out.println(str);
//    }

}
