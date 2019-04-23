package com.qhit.baseDept.controller; 

import com.qhit.baseDept.pojo.BaseDept; 
import com.qhit.baseDept.service.IBaseDeptService; 
import com.qhit.baseDept.service.impl.BaseDeptServiceImpl; 
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
* Created by GeneratorCode on 2018/12/27
*/ 

@Controller 
@RequestMapping("/baseDept") 
public class BaseDeptController { 

    @Resource 
    IBaseDeptService baseDeptService; 

    @RequestMapping("/insert") 
    public String insert(BaseDept baseDept) { 
        baseDeptService.insert(baseDept); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer deptId, HttpServletResponse response) throws IOException { 
        baseDeptService.delete(deptId); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(BaseDept baseDept) { 
        baseDeptService.update(baseDept); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(BaseDept baseDept) { 
        baseDeptService.updateSelective(baseDept); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer deptId, Model model) { 
        BaseDept baseDept = baseDeptService.findById(deptId); 
        model.addAttribute("baseDept",baseDept); 
        return "baseDept/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<BaseDept> list = baseDeptService.findAll(); 
        model.addAttribute("list",list); 
        return "baseDept/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<BaseDept> list = baseDeptService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(BaseDept baseDept,Model model) { 
        List<BaseDept> list = baseDeptService.search(baseDept); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",baseDept); 
        return "baseDept/list"; 
    } 
 
} 
