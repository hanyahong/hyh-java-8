package com.hyh.chapter_2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: HYH
 * @Date: 2018/4/30 21:29
 * @Description: 行为参数化
 */
public class BClass {

    //传统参数行行为，对于行为进行可变操作
    @Test
    public void testMain() {
        List<Bean> beans = Arrays.asList(
                new Bean("001", "Han"),
                new Bean("001", "Han"),
                new Bean("002", "Yan"),
                new Bean("002", "Han"));
        //第一次优化
        filterBean(beans, new PropertyGetOne());
        filterBean(beans, new PropertyGetTwo());
        //第二次优化
        filterBean(beans, new Property() {
            @Override
            public String some(Bean bean) {
                return "类名累不累！！";
        }
        });
        //第三次优化
        List<Bean> newB = filterBean(beans, (Bean bean) -> String.valueOf("Han".equals(bean.getName())));
    }

    public static List<Bean> filterBean(List<Bean> beans, Property property) {
        List<Bean> newBeans = new ArrayList<>();
        for (Bean b : beans) {
            b.getName().equals("Han Yahong");
            newBeans.add(b);
        }
        return newBeans;
    }

}

interface Property {
    String some(Bean bean);
}

//多种行为实现-第一种行为
class PropertyGetOne implements Property {
    @Override
    public String some(Bean bean) {
        return "This is One Method:" + bean.getName() + bean.getOid();
    }
}

//多种行为实现-第二种行为
class PropertyGetTwo implements Property {
    @Override
    public String some(Bean bean) {
        return "This is two Method:" + bean.getName() + bean.getOid();
    }
}

class Bean {
    private String oid;
    private String name;

    public Bean(String oid, String name) {
        this.oid = oid;
        this.name = name;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}