package com.qhit.inPatient.controller; 

import com.qhit.inPatient.pojo.InPatient; 
import com.qhit.inPatient.service.IInPatientService; 
import com.qhit.inPatient.service.impl.InPatientServiceImpl; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping; 
import javax.annotation.Resource; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.List;

/** 
* Created by GeneratorCode on 2019/01/15
*/ 

@Controller 
@RequestMapping("/inPatient") 
public class InPatientController { 

    @Resource 
    IInPatientService inPatientService; 

    @RequestMapping("/insert") 
    public String insert(InPatient inPatient) { 
        inPatientService.insert(inPatient); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer patientId, HttpServletResponse response) throws IOException { 
        inPatientService.delete(patientId); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(InPatient inPatient) { 
        inPatientService.update(inPatient); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(InPatient inPatient) { 
        inPatientService.updateSelective(inPatient); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer patientId, Model model) { 
        InPatient inPatient = inPatientService.findById(patientId); 
        model.addAttribute("inPatient",inPatient); 
        return "inPatient/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException { 
        List<InPatient> list = inPatientService.findAll();
        diaoyong(list);
        double maxAmount=list.get(0).getAmount();
        for (InPatient i:list){
            if (i.getAmount()>maxAmount){
                maxAmount=i.getAmount();
            }
        }
        model.addAttribute("list",list); 
        model.addAttribute("maxAmount",maxAmount);
        return "inPatient/list";
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<InPatient> list = inPatientService.findAll();
        diaoyong(list);
        String s = JSON.toJSONString(list); 
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(InPatient inPatient,Model model) { 
        List<InPatient> list = inPatientService.search(inPatient);
        diaoyong(list);
        model.addAttribute("list",list); 
        model.addAttribute("searchObject",inPatient); 
        return "inPatient/list"; 
    }

    @RequestMapping("/search2")
    public String search2(String status,Model model) {
        List<InPatient> list = inPatientService.search2(Integer.parseInt(status));
        diaoyong(list);
        double maxAmount=list.get(0).getAmount();
        for (InPatient i:list){
            if (i.getAmount()>maxAmount){
                maxAmount=i.getAmount();
            }
        }
        model.addAttribute("list",list);
        model.addAttribute("maxAmount",maxAmount);
        return "inPatient/list";
    }

    @RequestMapping("/batchChange")
    public String batchChange(HttpServletRequest request,Model model) {
        String[] patientIds = request.getParameterValues("patientId");
        if (patientIds.length>0&&patientIds!=null){
            for (String s:patientIds){
                InPatient byId = inPatientService.findById(Integer.parseInt(s));
                byId.setStatus(2);
                inPatientService.update(byId);
            }
        }
        return "forward:list.action";
    }

    @RequestMapping("/output")
    public String output() {
        //在院
        double Hospitalization=0;
        //出院
        double Discharged=0;

        //在院
        List<InPatient> inPatients = inPatientService.search2(1);
        for (InPatient s:inPatients){
            Hospitalization+=s.getAmount();
        }
        //出院
        List<InPatient> inPatients2 = inPatientService.search2(2);
        for (InPatient s:inPatients2){
            Discharged+=s.getAmount();
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\info.txt"));
            bw.write("出院病人金额合计："+Discharged+"元");
            bw.newLine();
            bw.write("在院病人金额合计："+Hospitalization+"元");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "forward:list.action";
    }

    int i=1;
    @RequestMapping("/sort")
    public String sort(Model model) {
        List<InPatient> list=null;
        if (i%2!=0){
            //升序
            list = inPatientService.findAllSort2("asc");
        }else {
            //倒序
            list = inPatientService.findAllSort("desc");
        }
        double maxAmount=list.get(0).getAmount();
        for (InPatient i:list){
            if (i.getAmount()>maxAmount){
                maxAmount=i.getAmount();
            }
        }
        model.addAttribute("maxAmount",maxAmount);
        model.addAttribute("list",list);
        i++;
        return "inPatient/list";
    }

    public static void diaoyong(List<InPatient> list){
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j <list.size(); j++) {
                InPatient s1=list.get(i);
                InPatient s2=list.get(j);
                String i1=s1.getBedNum().substring(2,(list.get(i).getBedNum().length()-1));
                String j1=s2.getBedNum().substring(2,(list.get(j).getBedNum().length()-1));
                if (Integer.parseInt(i1)>Integer.parseInt(j1)){
                    InPatient inPatient=s1;
                    list.set(i,s2);
                    list.set(j,inPatient);
                }
            }
        }
    }
 
} 
