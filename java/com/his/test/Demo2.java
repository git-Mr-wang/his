package com.qhit.test;

public class Demo2 {
    //        定义一个变量n=5
//        1 打印如下图形 (打印n个图形)
//                +-+-+
//                2 打印如下图形 (打印n行n列 + -)
//                +-+-+-
//                -+-+-+
//                        +-+-+-
//                                -+-+-+
//                                        +-+-+-
//                                                -+-+-+
//                                                        3 打印如下图形 (打印n行n列 + - * /)
//        +-*/+
//                -*/+-
//                */+-*
//  /+-*/
//        +-*/+
    public static void main(String[] args) {
        Demo3(21,2);
    }
    public static void Demo1(int s){
        for (int i = 1; i <=s; i++) {
            if (i%2!=0){
                System.out.print("+");
            }else {
                System.out.print("-");
            }
        }
    }
    public static void Demo2(int Row,int Column){
        for (int i = 1; i <=Column; i++) {
            for (int j = 1; j <=Row ; j++) {
                if (i%2!=0){
                    if (j%2!=0){
                        System.out.print("+");
                    }else {
                        System.out.print("-");
                    }
                }else {
                    if (j%2==0){
                        System.out.print("+");
                    }else {
                        System.out.print("-");
                    }
                }
            }
            System.out.println();
        }
    }
    public static void Demo3(int Row,int Column){
        String [] arr={"+","-","*","/"};
//        for (int i = 1; i <=Row ; i++) {
//            int t=i<=4?i:i%4;
//            if (t==0){
//                t=4;
//            }
//            for (int f = 1; f <=Column ; f++) {
//                System.out.print(arr[(t-1)+f]);
//
//
//            }
//            System.out.println();
//        }
    }
}
