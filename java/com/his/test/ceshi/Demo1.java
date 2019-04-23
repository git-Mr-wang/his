package com.qhit.test.ceshi;

import com.qhit.test.DongTaiDaiLi;
import com.qhit.test.FanDian;
import com.qhit.test.impl.ZhongCan;

public class Demo1 {
    public static void main(String[] args) {
        FanDian fanDian=new ZhongCan();
        DongTaiDaiLi dongTaiDaiLi = new DongTaiDaiLi();
        FanDian band = (FanDian) dongTaiDaiLi.band(fanDian);
        band.tiGongFaCai();
    }
}
