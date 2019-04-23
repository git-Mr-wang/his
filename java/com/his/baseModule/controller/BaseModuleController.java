package com.qhit.baseModule.controller;


import com.alibaba.fastjson.JSONObject;
import com.qhit.baseModule.pojo.BaseModule;
import com.qhit.baseModule.service.IBaseModuleService;
import com.qhit.baseModule.service.impl.BaseModuleServiceImpl;
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
@RequestMapping("/baseModule")
public class BaseModuleController {
    private IBaseModuleService baseModuleService=new BaseModuleServiceImpl();

    //模块表遍历
    @RequestMapping("/baseModuleList")
    public void baseModuleList(HttpServletResponse response){
        List<BaseModule> all = baseModuleService.findAll();
        JSONObject jsonObject = new JSONObject();
        try {
            response.getWriter().write(jsonObject.toJSONString(all));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/list")
    public String list(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
//        BaseUser baseUserLogin = (BaseUser) session.getAttribute("baseUserLogin");
        List<BaseModule> all = baseModuleService.findAll();
        model.addAttribute("list",all);
        return "baseModule/list";
    }
    @RequestMapping("/query")
    public String query(BaseModule baseModule,Model model){
       List<BaseModule> list = baseModuleService.findByMname(baseModule.getMname());
       model.addAttribute("list",list);
       model.addAttribute("mname",baseModule.getMname());
        return "baseModule/list";
    }

    //增加baseUser
    @RequestMapping("/insert")

    public String insert(BaseModule baseModule){
        boolean insert = baseModuleService.insert(baseModule);
        return "forward:list.action";
    }

    //执行删除操作
    @RequestMapping("/delete")
    public String delete(BaseModule baseModule){
        boolean delete = baseModuleService.delete(baseModule.getMid());
        return "forward:list.action";
    }

    //根据指定数据查找数据，并返回数据到指定页面
    @RequestMapping("/load")
    public String load(BaseModule baseModule,Model model){
        BaseModule byId = baseModuleService.findById(baseModule.getMid());
        model.addAttribute("baseModule",byId);
        return "baseModule/edit";
    }

    //执行更新操作
    @RequestMapping("/update")
    public String update(BaseModule baseModule){
        boolean update = baseModuleService.update(baseModule);
        return "forward:list.action";
    }

}
