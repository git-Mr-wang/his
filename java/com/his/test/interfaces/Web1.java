package com.qhit.test.interfaces;

import com.qhit.test.EngineerFactory;

/**
 * Created by Administrator on 2018/5/1 0001.
 */
public class Web1 {

    public static void main(String[] args) {
        Engineer engineer = EngineerFactory.getEngineer(1);
        engineer.judge(12345);
    }

}
