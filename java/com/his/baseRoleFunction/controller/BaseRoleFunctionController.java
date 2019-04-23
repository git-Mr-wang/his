package com.qhit.baseRoleFunction.controller; 

import com.qhit.baseRoleFunction.pojo.BaseRoleFunction;
import com.qhit.baseRoleFunction.service.IBaseRoleFunctionService; 
import com.qhit.baseRoleFunction.service.impl.BaseRoleFunctionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping; 
import javax.annotation.Resource; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import com.alibaba.fastjson.JSON; 
import java.io.IOException; 
import java.util.List; 

/**
* Created by GeneratorCode on 2018/12/19
*/
@Controller 
@RequestMapping("/baseRoleFunction") 
public class BaseRoleFunctionController {
    IBaseRoleFunctionService baseRoleFunctionService=new BaseRoleFunctionServiceImpl();

    @RequestMapping("/insert") 
    public String insert(BaseRoleFunction baseRoleFunction) { 
        baseRoleFunctionService.insert(baseRoleFunction); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer rmid, HttpServletResponse response) throws IOException { 
        baseRoleFunctionService.delete(rmid); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(BaseRoleFunction baseRoleFunction) { 
        baseRoleFunctionService.update(baseRoleFunction); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(BaseRoleFunction baseRoleFunction) { 
        baseRoleFunctionService.updateSelective(baseRoleFunction); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer rmid, Model model) { 
        BaseRoleFunction baseRoleFunction = baseRoleFunctionService.findById(rmid); 
        model.addAttribute("baseRoleFunction",baseRoleFunction); 
        return "baseRoleFunction/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<BaseRoleFunction> list = baseRoleFunctionService.findAll(); 
        model.addAttribute("list",list); 
        return "baseRoleFunction/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<BaseRoleFunction> list = baseRoleFunctionService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(BaseRoleFunction baseRoleFunction,Model model) { 
        List<BaseRoleFunction> list = baseRoleFunctionService.search(baseRoleFunction); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",baseRoleFunction); 
        return "baseRoleFunction/list"; 
    }

 
} 
