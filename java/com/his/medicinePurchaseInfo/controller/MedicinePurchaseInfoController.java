package com.qhit.medicinePurchaseInfo.controller; 

import com.qhit.baseRole.service.IBaseRoleService;
import com.qhit.baseRole.service.impl.BaseRoleServiceImpl;
import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.medicinePurchaseInfo.pojo.MedicinePurchaseInfo;
import com.qhit.medicinePurchaseInfo.service.IMedicinePurchaseInfoService; 
import com.qhit.medicinePurchaseInfo.service.impl.MedicinePurchaseInfoServiceImpl;
import com.qhit.medicineReqPlan.pojo.MedicineReqPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping; 
import javax.annotation.Resource; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON; 
import java.io.IOException; 
import java.util.List; 

/**
* Created by GeneratorCode on 2018/12/04
*/
@Controller 
@RequestMapping("/medicinePurchaseInfo") 
public class MedicinePurchaseInfoController {
    IMedicinePurchaseInfoService medicinePurchaseInfoService=new MedicinePurchaseInfoServiceImpl();
    IBaseRoleService baseRoleService=new BaseRoleServiceImpl();

    @RequestMapping("/insert") 
    public String insert(MedicinePurchaseInfo medicinePurchaseInfo) { 
        medicinePurchaseInfoService.insert(medicinePurchaseInfo); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer pchId, HttpServletResponse response) throws IOException { 
        medicinePurchaseInfoService.delete(pchId); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(MedicinePurchaseInfo medicinePurchaseInfo) {
        medicinePurchaseInfo.setPchTotal(medicinePurchaseInfo.getPchPrice()*medicinePurchaseInfo.getPchAmt());
        medicinePurchaseInfoService.update(medicinePurchaseInfo); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(MedicinePurchaseInfo medicinePurchaseInfo) { 
        medicinePurchaseInfoService.updateSelective(medicinePurchaseInfo); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer pchId, Model model) { 
        MedicinePurchaseInfo medicinePurchaseInfo = medicinePurchaseInfoService.findById(pchId);
//        System.out.println(medicinePurchaseInfo.toString());
        model.addAttribute("medicinePurchaseInfo",medicinePurchaseInfo); 
        return "medicinePurchaseInfo/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model,HttpSession session) throws IOException {
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUserLogin");
        //根据登录者信息查询登录者角色
        String url="";
        List<MedicinePurchaseInfo> list=null;
        String rname = baseRoleService.findLogin(baseUser.getUserId());
        if ("超级管理员".equals(rname)||"采购主管".equals(rname)){
            list=medicinePurchaseInfoService.findAll();
            url="medicinePurchaseInfo/psList";
        }
        else {
            list=medicinePurchaseInfoService.getAllId(baseUser.getUserId());
            url="medicinePurchaseInfo/list";
        }
        if (list!=null){
            for (MedicinePurchaseInfo m:list){
                System.out.println(m.toString());
            }
        }
        model.addAttribute("list",list); 
        return url;
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<MedicinePurchaseInfo> list = medicinePurchaseInfoService.findAll(); 
        String s = JSON.toJSONString(list);
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(MedicinePurchaseInfo medicinePurchaseInfo,Model model) { 
        List<MedicinePurchaseInfo> list = medicinePurchaseInfoService.search(medicinePurchaseInfo); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",medicinePurchaseInfo); 
        return "medicinePurchaseInfo/list"; 
    }

    @RequestMapping("/collect")
    public String collect(HttpSession session) {
        medicinePurchaseInfoService.collect(session);
        return "forward:list.action";
    }
    @RequestMapping("/purchase")
    public String purchase(String[] checked) {
        String s="";
        for (String i:checked){
            s+=i;
        }
        String[] split = s.split(",");
        for (String s2:split){
            String sql="UPDATE medicine_purchase_info SET STATUS=2 WHERE pch_id="+s2+"";
            boolean b = medicinePurchaseInfoService.freeUpdate(sql);
        }
        return "forward:list.action";
    }
 
} 
