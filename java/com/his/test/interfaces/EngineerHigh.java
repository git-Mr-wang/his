package com.qhit.test.interfaces;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/5/1 0001.
 */
public class EngineerHigh implements  Engineer {

    public void judge(int i) {
        char[] arr  = (i+"").toCharArray();
        char[] left = new char[arr.length/2];
        char[] right = new char[arr.length/2];
        for (int j = 0; j <arr.length/2 ; j++) {
            left[j] = arr[j];
            right[j] = arr[arr.length-1-j];
        }
        Arrays.sort(left);
        Arrays.sort(right);
        if(left[left.length-1]<right[0]){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
