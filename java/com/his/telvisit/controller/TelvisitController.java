package com.qhit.telvisit.controller; 

import com.qhit.telvisit.pojo.Telvisit; 
import com.qhit.telvisit.service.ITelvisitService; 
import com.qhit.telvisit.service.impl.TelvisitServiceImpl;
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
* Created by GeneratorCode on 2018/12/24
*/ 

@Controller 
@RequestMapping("/telvisit") 
public class TelvisitController {
    @Resource
    ITelvisitService telvisitService;

    @RequestMapping("/insert") 
    public String insert(Telvisit telvisit) { 
        telvisitService.insert(telvisit); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer tvid, HttpServletResponse response) throws IOException { 
        telvisitService.delete(tvid); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(Telvisit telvisit) { 
        telvisitService.update(telvisit); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(Telvisit telvisit) { 
        telvisitService.updateSelective(telvisit); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer tvid, Model model) { 
        Telvisit telvisit = telvisitService.findById(tvid); 
        model.addAttribute("telvisit",telvisit); 
        return "telvisit/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<Telvisit> list = telvisitService.findAll(); 
        model.addAttribute("list",list); 
        return "telvisit/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<Telvisit> list = telvisitService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(Telvisit telvisit,Model model) { 
        List<Telvisit> list = telvisitService.search(telvisit); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",telvisit); 
        return "telvisit/list"; 
    } 
 
} 
