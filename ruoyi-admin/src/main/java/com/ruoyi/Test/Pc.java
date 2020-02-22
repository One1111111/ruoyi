package com.ruoyi.Test;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Pc {


    public static String[] getAddress(){
        String url = "http://www.hotelaah.com/lvyou/";
        Connection connect = Jsoup.connect(url);
        try{
            Document document = connect.get();
            String s = document.select("table").get(9).text();
            String[] s1 = s.split(" ");
            return  s1;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取地址失败");
            return null;
        }
    }

    public static void main(String[] args) {
        String[] address = getAddress();
        for (int i = 0; i <getAddress().length ; i++) {

        }
    }
}
