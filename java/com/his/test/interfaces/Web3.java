package com.qhit.test.interfaces;

import com.qhit.test.EngineerFactory;

/**
 * Created by Administrator on 2018/5/1 0001.
 */
public class Web3 {

    public static void main(String[] args) {
        Engineer engineer = EngineerFactory.getEngineer(3);
        engineer.judge(3573);
    }

}
