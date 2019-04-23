package com.qhit.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class InsertSort {
    public static void main(String[] args) {
        int[] ints = ArrayGeneration(10, 20);
        System.out.println("生成的数组"+Arrays.toString(ints));
        SelectSort(ints);
        System.out.println("选择排序后的数组"+Arrays.toString(ints));
        System.out.println("递归法找到的数据下标为："+RecursiveLookup(ints,5,0,ints.length-1));
    }
    //生成数组  n：数组长度, m：数组数值范围 1~m;
    public static int [] ArrayGeneration(int n,int m){
        Set<Integer>set=new HashSet<Integer>();
        Random r=new Random();
        while (set.size()<n){
            set.add(r.nextInt(m)+1);
        }
        Object[] objects = set.toArray();
        int [] i=new int[n];
        for (int s=0;s<objects.length;s++){
            i[s]=(Integer) objects[s];
        }
        return i;
    }
    //选择排序
    public static void SelectSort(int [] i){
        for (int j = 0; j <i.length; j++) {
            int min=j;
            for (int k = j+1; k <i.length ; k++) {
                if (i[k]<i[min]){
                    min=k;
                }
            }
            if (min!=j){
                int emp=i[min];
                i[min]=i[j];
                i[j]=emp;
            }
        }
    }
    //递归形式查找
    public static int RecursiveLookup(int [] i,int key, int min,int max){
        int middle=(min+max)/2;
        if (min>middle){
            return -1;
        }
        if (key==i[middle]){
            return middle;
        }else if (key<i[middle]){
            return RecursiveLookup(i,key,min,middle-1);
        }else {
            return RecursiveLookup(i,key,middle+1,max);
        }
    }

}
