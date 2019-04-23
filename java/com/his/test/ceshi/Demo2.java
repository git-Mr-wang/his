package com.qhit.test.ceshi;


import com.qhit.test.DongTaiDaiLi2;
import com.qhit.test.FanDian;
import com.qhit.test.impl.XiCan;
import com.qhit.test.impl.ZhongCan;
import com.qhit.test.impl.ZiZhuCan;

public class Demo2 {
    public static void main(String[] args) {
        ZhongCan zhongCan=new ZhongCan();
        DongTaiDaiLi2 dongTaiDaiLi2 = new DongTaiDaiLi2();
        FanDian instance = (ZhongCan) dongTaiDaiLi2.getInstance(zhongCan);
        instance.tiGongFaCai();
    }
}
