package com.qhit.baseUserRole.controller;

import com.alibaba.fastjson.JSONObject;
import com.qhit.baseRole.pojo.BaseRole;
import com.qhit.baseRole.service.IBaseRoleService;
import com.qhit.baseRole.service.impl.BaseRoleServiceImpl;
import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.baseUserRole.pojo.BaseUserRole;
import com.qhit.baseUserRole.service.IBaseUserRoleService;
import com.qhit.baseUserRole.service.impl.BaseUserRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/baseUserRole")
public class BaseUserRoleController {
    private IBaseUserRoleService iurs=new BaseUserRoleServiceImpl();
    private IBaseRoleService is=new BaseRoleServiceImpl();

    @RequestMapping("/notIn")
    public void details(BaseUser baseUser, HttpServletResponse response) throws IOException {
        List<BaseRole> all =is.notIn(baseUser.getUserId());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("notIn", all);
        response.getWriter().write(jsonObject.toJSONString());
    }
    @RequestMapping("/yes")
    public void yes(BaseUser baseUser, HttpServletResponse response) throws IOException {
        List<BaseRole> all =is.findAll2(baseUser.getUserId());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("yes", all);
        response.getWriter().write(jsonObject.toJSONString());
    }
    @RequestMapping("/detailsUpdate")
    public void detailsUpdate(String rid,Integer uid,HttpServletResponse response) throws IOException {
        boolean delete = iurs.deleteUid(uid);
        String[] split = rid.split(",");
        boolean flag=false;
        for (String s:split){
            BaseUserRole bur=new BaseUserRole();
            bur.setUid(uid);
            bur.setRid(Integer.parseInt(s));
            flag = iurs.insert(bur);
            if (!flag){
                break;
            }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag",flag);
        response.getWriter().write(jsonObject.toJSONString());
    }
}
