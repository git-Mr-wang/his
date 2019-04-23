package com.qhit.medicineType.controller; 

import com.qhit.medicineType.pojo.MedicineType; 
import com.qhit.medicineType.service.IMedicineTypeService; 
import com.qhit.medicineType.service.impl.MedicineTypeServiceImpl;
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
* Created by GeneratorCode on 2018/12/03
*/
@Controller 
@RequestMapping("/medicineType") 
public class MedicineTypeController {
    IMedicineTypeService medicineTypeService=new MedicineTypeServiceImpl();

    @RequestMapping("/insert") 
    public String insert(MedicineType medicineType) { 
        medicineTypeService.insert(medicineType); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer typeId, HttpServletResponse response) throws IOException { 
        medicineTypeService.delete(typeId); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(MedicineType medicineType) { 
        medicineTypeService.update(medicineType); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(MedicineType medicineType) { 
        medicineTypeService.updateSelective(medicineType); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer typeId, Model model) { 
        MedicineType medicineType = medicineTypeService.findById(typeId); 
        model.addAttribute("medicineType",medicineType); 
        return "medicineType/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<MedicineType> list = medicineTypeService.findAll(); 
        model.addAttribute("list",list); 
        return "medicineType/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<MedicineType> list = medicineTypeService.findAll();
//        for (MedicineType m:list){
//            System.out.println(m.toString());
//        }
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(MedicineType medicineType,Model model) { 
        List<MedicineType> list = medicineTypeService.search(medicineType); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",medicineType); 
        return "medicineType/list"; 
    } 
 
} 
