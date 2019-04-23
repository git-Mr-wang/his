package com.qhit.doctorVisitRecord.controller; 

import com.qhit.doctorVisitRecord.pojo.DoctorVisitRecord; 
import com.qhit.doctorVisitRecord.service.IDoctorVisitRecordService; 
import com.qhit.doctorVisitRecord.service.impl.DoctorVisitRecordServiceImpl; 
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
* Created by GeneratorCode on 2019/01/02
*/ 

@Controller 
@RequestMapping("/doctorVisitRecord") 
public class DoctorVisitRecordController { 

    @Resource 
    IDoctorVisitRecordService doctorVisitRecordService; 

    @RequestMapping("/insert") 
    public String insert(DoctorVisitRecord doctorVisitRecord) { 
        doctorVisitRecordService.insert(doctorVisitRecord); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer vrId, HttpServletResponse response) throws IOException { 
        doctorVisitRecordService.delete(vrId); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(DoctorVisitRecord doctorVisitRecord) { 
        doctorVisitRecordService.update(doctorVisitRecord); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(DoctorVisitRecord doctorVisitRecord) { 
        doctorVisitRecordService.updateSelective(doctorVisitRecord); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer vrId, Model model) { 
        DoctorVisitRecord doctorVisitRecord = doctorVisitRecordService.findById(vrId); 
        model.addAttribute("doctorVisitRecord",doctorVisitRecord); 
        return "doctorVisitRecord/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<DoctorVisitRecord> list = doctorVisitRecordService.findAll(); 
        model.addAttribute("list",list); 
        return "doctorVisitRecord/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<DoctorVisitRecord> list = doctorVisitRecordService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(DoctorVisitRecord doctorVisitRecord,Model model) { 
        List<DoctorVisitRecord> list = doctorVisitRecordService.search(doctorVisitRecord); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",doctorVisitRecord); 
        return "doctorVisitRecord/list"; 
    } 
 
} 
