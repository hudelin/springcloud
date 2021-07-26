package com.hu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hudelin
 * @date 2021/2/5
 */
public class Test {

    public static void main(String[] args) {
        List<String> dataList = new ArrayList<>();
        dataList.add("1");
        dataList.add("1001");
        dataList.add("1002");
        dataList.add("1003");
        dataList.add("2");
        dataList.add("2001");
        dataList.add("2002");
        dataList.add("2003");
        dataList.add("3");
        dataList.add("3001");
        dataList.add("3002");

        int s= 0;
        for (int i = 0; i < dataList.size(); i++) {
            String str=dataList.get(i);
            boolean conti = str.length() > 3;
            if(!conti){
                System.out.println("开始"+s+"结束"+(i-1));
                s=i;
            }
        }


    }
}
