package com.qhit.baseFunction.controller;


import com.alibaba.fastjson.JSONObject;
import com.qhit.baseFunction.pojo.BaseFunction;
import com.qhit.baseFunction.service.IBaseFunctionService;
import com.qhit.baseFunction.service.impl.BaseFunctionServiceImpl;
import com.qhit.baseModule.pojo.BaseModule;
import com.qhit.baseUser.pojo.BaseUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/baseFunction")
public class BaseFunctionController {
    IBaseFunctionService is=new BaseFunctionServiceImpl();

    //功能表遍历
    @RequestMapping("/baseFunctionList")
    public void baseModuleList(BaseFunction baseFunction, HttpServletResponse response,HttpServletRequest request){
        HttpSession session = request.getSession();
        BaseUser baseUserLogin = (BaseUser) session.getAttribute("baseUserLogin");
        List<BaseFunction> all =null;
        if (baseFunction.getMid()!=null&&!baseFunction.getMid().equals("")){
            all = is.findByMid(baseFunction.getMid() + "",baseUserLogin);
        }else {
            all = is.findAll2(baseUserLogin);
        }
        JSONObject jsonObject = new JSONObject();
        try {
            response.getWriter().write(jsonObject.toJSONString(all));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/findByMid")
    public String findByMid(String mid, HttpServletRequest request){
        HttpSession session = request.getSession();
        BaseUser baseUserLogin = (BaseUser) session.getAttribute("baseUserLogin");
        List<BaseFunction> list = is.findByMid(mid,baseUserLogin);
        request.setAttribute("baseFunction",list);
        return "/index/left";
    }

    @RequestMapping("/list")
    public String list(Model model){
        List<BaseFunction> all = is.findAll();
        model.addAttribute("list",all);
        return "baseFunction/list";
    }

    //增加BaseFunction
    @RequestMapping("/insert")

    public String insert(BaseFunction baseFunction){
        boolean insert = is.insert(baseFunction);
        return "forward:list.action";
    }

    //根据指定数据查找数据，并返回数据到指定页面
    @RequestMapping("/load")
    public String load(BaseFunction baseFunction,Model model){
        BaseFunction byId = is.findById(baseFunction.getFid());
        model.addAttribute("baseFunction",byId);
        return "baseFunction/edit";
    }

    //执行更新操作
    @RequestMapping("/update")
    public String update(BaseFunction baseFunction){
        boolean update = is.update(baseFunction);
        return "forward:list.action";
    }

    //执行删除操作
    @RequestMapping("/delete")
    public String delete(BaseFunction baseFunction){
        boolean delete = is.delete(baseFunction.getFid());
        return "forward:list.action";
    }
    @RequestMapping("/query")
    public String query(BaseFunction baseFunction, BaseModule baseModule,Model model){
        List<BaseFunction> list = is.findByName(baseModule.getMname(),baseFunction.getFname());
        model.addAttribute("list",list);
        model.addAttribute("mname",baseModule.getMname());
        model.addAttribute("fname",baseFunction.getFname());
        return "baseFunction/list";
    }

}
