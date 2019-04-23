package com.qhit.test.interfaces;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/5/1 0001.
 */
public class EngineerMiddle implements Engineer {
    public void judge(int i) {
        String str = i+"";
        String before = str.substring(0,str.length()/2);
        int begin = str.length()%2==0?str.length()/2:str.length()/2+1;
        String end = str.substring(begin,str.length());
        char[] barr =before.toCharArray();
        char[] earr =end.toCharArray();
        Arrays.sort(barr);
        Arrays.sort(earr);
        if(earr[0]>barr[barr.length-1]){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

    }
}
