package com.qhit.test.interfaces;

import com.qhit.test.EngineerFactory;

/**
 * Created by Administrator on 2018/5/1 0001.
 */
public class Web2 {

    public static void main(String[] args) {
        Engineer engineer = EngineerFactory.getEngineer(2);
        engineer.judge(66785);
    }

}
