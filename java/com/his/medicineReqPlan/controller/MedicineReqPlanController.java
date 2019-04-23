package com.qhit.medicineReqPlan.controller; 

import com.qhit.baseRole.service.IBaseRoleService;
import com.qhit.baseRole.service.impl.BaseRoleServiceImpl;
import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.common.commonUtils;
import com.qhit.medicineReqPlan.dao.IMedicineReqPlanDao;
import com.qhit.medicineReqPlan.dao.impl.MedicineReqPlanDaoImpl;
import com.qhit.medicineReqPlan.pojo.MedicineReqPlan;
import com.qhit.medicineReqPlan.service.IMedicineReqPlanService; 
import com.qhit.medicineReqPlan.service.impl.MedicineReqPlanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON; 
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/04
*/
@Controller 
@RequestMapping("/medicineReqPlan")
public class MedicineReqPlanController {

    IMedicineReqPlanService medicineReqPlanService=new MedicineReqPlanServiceImpl();
    IBaseRoleService baseRoleService=new BaseRoleServiceImpl();

    @RequestMapping("/insert") 
    public String insert(MedicineReqPlan medicineReqPlan, HttpSession session) {
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUserLogin");
        //根据登录者信息查询登录者角色
        String rname = baseRoleService.findLogin(baseUser.getUserId());
        if ("药房主任".equals(rname)||"超级管理员".equals(rname)){
            medicineReqPlan.setStatus(2);
            medicineReqPlan.setApprvDate(commonUtils.dateStr());
            medicineReqPlan.setApprvUserid(baseUser.getUserId());
        }else {
            medicineReqPlan.setStatus(1);
        }
        medicineReqPlan.setAppUserid(baseUser.getUserId());
        medicineReqPlan.setAppDate(commonUtils.dateStr());
        boolean insert = medicineReqPlanService.insert(medicineReqPlan);
        return "forward:list.action";
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer reqplnno, HttpServletResponse response) throws IOException { 
        medicineReqPlanService.delete(reqplnno); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(MedicineReqPlan medicineReqPlan) { 
        medicineReqPlanService.update(medicineReqPlan); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(MedicineReqPlan medicineReqPlan) { 
        medicineReqPlanService.updateSelective(medicineReqPlan); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer reqplnno, Model model) { 
        MedicineReqPlan medicineReqPlan = medicineReqPlanService.findById(reqplnno);
        System.out.println(medicineReqPlan.toString());
        model.addAttribute("medicineReqPlan",medicineReqPlan); 
        return "medicineReqPlan/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model,HttpSession session) throws IOException {
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUserLogin");
        List<MedicineReqPlan> list;
        String url="";
        //根据登录者信息查询登录者角色
        String rname = baseRoleService.findLogin(baseUser.getUserId());
        if ("药房主任".equals(rname)||"超级管理员".equals(rname)){
            IMedicineReqPlanDao dao = new MedicineReqPlanDaoImpl();
            list = dao.findAll();
//            for (MedicineReqPlan m:list){
//                System.out.println(m.toString());
//            }
            url= "medicineReqPlan/apprvlist";
        }else {
            list = medicineReqPlanService.findAll(baseUser.getUserId());
//            for (MedicineReqPlan m:list){
//                System.out.println(m.toString());
//            }
            url="medicineReqPlan/list";
        }
        model.addAttribute("list",list);
        return url;

    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
//        List<MedicineReqPlan> list = medicineReqPlanService.findAll(baseUser.getUserId());
//        String s = JSON.toJSONString(list);
//        response.getWriter().write(s);
    } 
 
    @RequestMapping("/search") 
    public String search(MedicineReqPlan medicineReqPlan,Model model) { 
        List<MedicineReqPlan> list = medicineReqPlanService.search(medicineReqPlan); 
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",medicineReqPlan); 
        return "medicineReqPlan/list"; 
    }
    @RequestMapping("/apprv")
    public String apprv(String[] checked,HttpSession session) {
        BaseUser baseUser = (BaseUser) session.getAttribute("baseUserLogin");
        String date = commonUtils.dateStr();
        String s="";
        for (String i:checked){
            s+=i;
        }
        String[] split = s.split(",");
        MedicineReqPlan medicineReqPlan = new MedicineReqPlan();
        for(String reqplnno:split){
            medicineReqPlan.setReqplnno(Integer.parseInt(reqplnno));
            medicineReqPlan.setStatus(2);
            medicineReqPlan.setApprvUserid(commonUtils.getUserId(session));
            medicineReqPlan.setApprvDate(commonUtils.dateStr());
            medicineReqPlanService.updateSelective(medicineReqPlan);
        }
        return "forward:list.action";
    }

} 
