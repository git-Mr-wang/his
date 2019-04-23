package com.qhit.test;

public class MyString {
    public static char charAt(String s1,int i){
        char[] chars = s1.toCharArray();
        return chars[i];
    }
    public static String subString(String s,int begin,int end){
        char[] chars = s.toCharArray();
        String count="";
        for (int sub=begin;sub<end;sub++){
            count+=chars[sub];
        }
        return count;
    }

    public static void main(String[] args) {
        char ch = charAt("abcdefg", 4);
        System.out.println(ch);
        String sub = subString("abcdefg", 0, 5);
        System.out.println(sub);
    }
}
