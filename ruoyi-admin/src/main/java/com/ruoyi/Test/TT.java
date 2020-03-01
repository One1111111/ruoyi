package com.ruoyi.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class TT {


    public static void main(String[] args) throws Exception {
        String url = "localhostoifjoaidjoif";
        url.replace("goodo.tk", "localh");
        System.out.println(url);
    }

    /**
     * @param i 生成几位数的随机数
     * @return
     */
    public static String getRandom(int i) {
        String src = new String();
        Random rand = new Random();
        while (i > 0) {
            src += String.valueOf(rand.nextInt(10));
            i--;
        }
        return src;
    }


    /**
     * 生成当前时间字符串
     *
     * @return String
     */
    public static String getDateString() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());//填入当前时间
        int year = c.get(Calendar.YEAR);    //获取年
        int month = c.get(Calendar.MONTH) + 1;   //获取月份，0表示1月份
        int day = c.get(Calendar.DAY_OF_MONTH);    //获取当前天数
        int first = c.getActualMinimum(c.DAY_OF_MONTH);    //获取本月最小天数
        int last = c.getActualMaximum(c.DAY_OF_MONTH);    //获取本月最大天数
        int time = c.get(Calendar.HOUR_OF_DAY);       //获取当前小时
        int min = c.get(Calendar.MINUTE);          //获取当前分钟
        int xx = c.get(Calendar.SECOND);          //获取当前秒
        SimpleDateFormat s = new SimpleDateFormat("yyyyMMddHHmmss");
        String curDate = s.format(c.getTime());  //当前日期
        return curDate;
    }


}
