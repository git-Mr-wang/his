package com.qhit.baseManufacturer.controller; 

import com.qhit.baseManufacturer.pojo.BaseManufacturer; 
import com.qhit.baseManufacturer.service.IBaseManufacturerService; 
import com.qhit.baseManufacturer.service.impl.BaseManufacturerServiceImpl;
import com.qhit.baseModule.pojo.BaseModule;
import com.qhit.utils.ZhongWenToPinYin;
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
@RequestMapping("/baseManufacturer") 
public class BaseManufacturerController {
    IBaseManufacturerService baseManufacturerService=new BaseManufacturerServiceImpl();

    @RequestMapping("/insert") 
    public String insert(BaseManufacturer baseManufacturer) {
        String pinyin = ZhongWenToPinYin.getPinyin(baseManufacturer.getManChnName());
        baseManufacturer.setPy1(pinyin);
        baseManufacturerService.insert(baseManufacturer); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer manCode, HttpServletResponse response) throws IOException { 
        baseManufacturerService.delete(manCode); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(BaseManufacturer baseManufacturer) {
        String pinyin = ZhongWenToPinYin.getPinyin(baseManufacturer.getManChnName());
        baseManufacturer.setPy1(pinyin);
        baseManufacturerService.update(baseManufacturer); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(BaseManufacturer baseManufacturer) {
//        String pinyin = ZhongWenToPinYin.getPinyin(baseManufacturer.getManChnName());
//        baseManufacturer.setPy1(pinyin);
        baseManufacturerService.updateSelective(baseManufacturer); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer manCode, Model model) { 
        BaseManufacturer baseManufacturer = baseManufacturerService.findById(manCode); 
        model.addAttribute("baseManufacturer",baseManufacturer); 
        return "baseManufacturer/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<BaseManufacturer> list = baseManufacturerService.findAll(); 
        model.addAttribute("list",list); 
        return "baseManufacturer/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<BaseManufacturer> list = baseManufacturerService.findAll();
//        for (BaseManufacturer b:list){
//            System.out.println(b.toString());
//        }
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(BaseManufacturer baseManufacturer,Model model) { 
        List<BaseManufacturer> list = baseManufacturerService.search(baseManufacturer); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",baseManufacturer); 
        return "baseManufacturer/list"; 
    } 
 
} 
