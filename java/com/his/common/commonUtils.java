package com.qhit.common;

import com.qhit.baseUser.pojo.BaseUser;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

public class commonUtils {
    public static String dateStr(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }

    public static Integer getUserId(HttpSession session) {
        BaseUser baseUserLogin = (BaseUser) session.getAttribute("baseUserLogin");
        return baseUserLogin.getUserId();
    }
}
