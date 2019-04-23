package com.qhit.recursion;

public class Demo1 {
    private static Integer sum=0;
    private static Integer n=1;

    private static Integer one=1;
    private static Integer two=1;

    private static Integer s=3;

    public static void main(String[] args) {
//        cacl(10);
//        caclSum(10);
//        System.out.println(sum);
//        boolean palindrome = palindrome(23);
//        System.out.println(palindrome);
//        int i = FibonacciSequence(6);
//        System.out.println(i);
        for (int i=9;i>=1;i--){
            for (int j=i;j>0;j--){
                System.out.print(j+"*"+i+"="+(j*i)+"\t");
            }
            System.out.println();
        }


    }
    public static void cacl(int i){
        if (n<=i){
            sum+=n;
            n++;
            cacl(i);
        }
    }
    public static void caclSum(int i){
        if (i>0){
            sum+=i;
            i--;
            caclSum(i);
        }
    }
    public static boolean palindrome(Integer i){
        String s=i+"";
        if (s.length()>2){
            if (s.charAt(0)==s.charAt(s.length()-1)){
                palindrome(Integer.parseInt(s.substring(1,(s.length()-1))));
            }else {
                return false;
            }
        }else if (s.length()==2){
            if (s.charAt(0)==s.charAt(s.length()-1)){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
        return true;
    }
    public static int FibonacciSequence(int i){
        if (i==0){
            return 0;
        }else if (i==1||i==2){
            return 1;
        }else if (i>=3){
            if (s<=i){
                s++;
                int emp=one;
                one=two;
                two+=emp;
                FibonacciSequence(i);
            }
        }
        return two;
    }
}
