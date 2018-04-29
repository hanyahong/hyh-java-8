package com.hyh.chapter_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther: HYH
 * @Date: 2018/4/29 17:47
 * @Description:
 */
public class AClass {

    /**
     * 排序旧版写法
     */
    public void sort() {

        Collections.sort(createDemoList(), new Comparator<Pig>() {
            public int compare(Pig o1, Pig o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });

    }

    /**
     * java 8 函数式编程写法
     */
    public void sort_2() {

       createDemoList().sort(Comparator.comparing(Pig::getAge));
    }

    /**
     * 构造一个List实验使用
     *
     * @return
     */
    public List<Pig> createDemoList() {
        List x = new ArrayList<String>();
        Pig pig = new Pig();
        pig.setName("A");
        pig.setAge(10);
        pig.setColor("red");
        x.add(pig);
        pig.setName("B");
        pig.setAge(10);
        pig.setColor("blank");
        x.add(pig);
        pig.setName("C");
        pig.setAge(10);
        pig.setColor("yellow");
        x.add(pig);
        return x;
    }
}


class Pig {
    private String name;
    private Integer age;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}