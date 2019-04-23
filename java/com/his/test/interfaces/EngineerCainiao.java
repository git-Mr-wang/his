package com.qhit.test.interfaces;

/**
 * Created by Administrator on 2018/5/1 0001.
 */
public class EngineerCainiao  implements Engineer{
    public void judge(int i) {
        char[] arr =(i+"").toCharArray();
        int max = 0;
        boolean flag = true;
        for (int j = 0; j < arr.length; j++) {
            if(j<arr.length/2){
                if(max<arr[j]){
                    max=arr[j];
                }
            }else if(j>=arr.length/2.0){
                if(max>=arr[j]){
                    flag=false;
                    break;
                }
            }
        }
        System.out.println(flag);
    }
}
