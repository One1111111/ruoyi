package com.ruoyi.Test;

import java.util.LinkedList;
import java.util.List;

public class Util {

    public static void main(String[] args){
        List list = new LinkedList();

        System.out.println(list.isEmpty());

        list.add("a66666");
        list.add("a33333");
        list.add("a688");
        list.add("a6667");
        list.add(1,"a22222");

        for (Object obj:list) {

            list.remove(obj);
        }
    }
}
