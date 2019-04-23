package com.qhit.companyinfo.controller; 

import com.qhit.companyinfo.pojo.Companyinfo; 
import com.qhit.companyinfo.service.ICompanyinfoService; 
import com.qhit.companyinfo.service.impl.CompanyinfoServiceImpl;
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
* Created by GeneratorCode on 2018/12/04
*/
@Controller 
@RequestMapping("/companyinfo") 
public class CompanyinfoController {
    ICompanyinfoService companyinfoService=new CompanyinfoServiceImpl();

    @RequestMapping("/insert") 
    public String insert(Companyinfo companyinfo) { 
        companyinfoService.insert(companyinfo); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer cid, HttpServletResponse response) throws IOException { 
        companyinfoService.delete(cid); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(Companyinfo companyinfo) { 
        companyinfoService.update(companyinfo); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(Companyinfo companyinfo) { 
        companyinfoService.updateSelective(companyinfo); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer cid, Model model) { 
        Companyinfo companyinfo = companyinfoService.findById(cid); 
        model.addAttribute("companyinfo",companyinfo); 
        return "companyinfo/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<Companyinfo> list = companyinfoService.findAll(); 
        model.addAttribute("list",list); 
        return "companyinfo/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<Companyinfo> list = companyinfoService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(Companyinfo companyinfo,Model model) { 
        List<Companyinfo> list = companyinfoService.search(companyinfo); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",companyinfo); 
        return "companyinfo/list"; 
    } 
 
} 
