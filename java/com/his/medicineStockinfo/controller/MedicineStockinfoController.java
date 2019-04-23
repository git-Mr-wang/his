package com.qhit.medicineStockinfo.controller; 

import com.qhit.medicineStockinfo.pojo.MedicineStockinfo; 
import com.qhit.medicineStockinfo.service.IMedicineStockinfoService; 
import com.qhit.medicineStockinfo.service.impl.MedicineStockinfoServiceImpl;
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
* Created by GeneratorCode on 2018/12/11
*/
@Controller 
@RequestMapping("/medicineStockinfo") 
public class MedicineStockinfoController {
    IMedicineStockinfoService medicineStockinfoService=new MedicineStockinfoServiceImpl();

    @RequestMapping("/insert") 
    public String insert(MedicineStockinfo medicineStockinfo) { 
        medicineStockinfoService.insert(medicineStockinfo); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer stockinfoId, HttpServletResponse response) throws IOException { 
        medicineStockinfoService.delete(stockinfoId); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(MedicineStockinfo medicineStockinfo) { 
        medicineStockinfoService.update(medicineStockinfo); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(MedicineStockinfo medicineStockinfo) { 
        medicineStockinfoService.updateSelective(medicineStockinfo); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer stockinfoId, Model model) { 
        MedicineStockinfo medicineStockinfo = medicineStockinfoService.findById(stockinfoId); 
        model.addAttribute("medicineStockinfo",medicineStockinfo); 
        return "medicineStockinfo/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<MedicineStockinfo> list = medicineStockinfoService.findAll(); 
        model.addAttribute("list",list); 
        return "medicineStockinfo/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<MedicineStockinfo> list = medicineStockinfoService.findAll(); 
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(MedicineStockinfo medicineStockinfo,Model model) { 
        List<MedicineStockinfo> list = medicineStockinfoService.search(medicineStockinfo); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",medicineStockinfo); 
        return "medicineStockinfo/list"; 
    } 
 
} 
