package com.qhit.medicineCode.controller; 

import com.qhit.medicineCode.pojo.MedicineCode; 
import com.qhit.medicineCode.service.IMedicineCodeService; 
import com.qhit.medicineCode.service.impl.MedicineCodeServiceImpl; 
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
* Created by GeneratorCode on 2018/12/26
*/ 

@Controller 
@RequestMapping("/medicineCode") 
public class MedicineCodeController { 

    @Resource 
    IMedicineCodeService medicineCodeService; 

    @RequestMapping("/insert") 
    public String insert(MedicineCode medicineCode) { 
        medicineCodeService.insert(medicineCode); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer codeId, HttpServletResponse response) throws IOException { 
        medicineCodeService.delete(codeId); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(MedicineCode medicineCode) { 
        medicineCodeService.update(medicineCode); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(MedicineCode medicineCode) { 
        medicineCodeService.updateSelective(medicineCode); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer codeId, Model model) { 
        MedicineCode medicineCode = medicineCodeService.findById(codeId); 
        model.addAttribute("medicineCode",medicineCode); 
        return "medicineCode/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<MedicineCode> list = medicineCodeService.findAll(); 
        model.addAttribute("list",list); 
        return "medicineCode/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<MedicineCode> list = medicineCodeService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(MedicineCode medicineCode,Model model) { 
        List<MedicineCode> list = medicineCodeService.search(medicineCode); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",medicineCode); 
        return "medicineCode/list"; 
    }

    @RequestMapping("/notOwned")
    public void notOwned(HttpServletResponse response,String menuId) throws IOException {
        List<MedicineCode> list = medicineCodeService.notOwned(menuId);
//        if (list!=null){
//            for (MedicineCode m:list){
//                System.out.println(m.toString());
//            }
//        }
        String s = JSON.toJSONString(list);
        response.getWriter().write(s);
    }

    @RequestMapping("/owned")
    public void owned(HttpServletResponse response,String menuId) throws IOException {
        List<MedicineCode> list = medicineCodeService.owned(menuId);
//        if (list!=null){
//            for (MedicineCode m:list){
//                System.out.println(m.toString());
//            }
//        }
        String s = JSON.toJSONString(list);
        response.getWriter().write(s);
    }
 
} 
