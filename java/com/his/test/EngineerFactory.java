package com.qhit.test;

import com.qhit.test.interfaces.Engineer;
import com.qhit.test.interfaces.EngineerCainiao;
import com.qhit.test.interfaces.EngineerHigh;
import com.qhit.test.interfaces.EngineerMiddle;

public class EngineerFactory {
    public static Engineer getEngineer(Integer number){
        if (number==1){
            return new EngineerCainiao();
        }else if (number==2){
            return new EngineerMiddle();
        }else if (number==3){
            return new EngineerHigh();
        }
        return null;
    }
}
