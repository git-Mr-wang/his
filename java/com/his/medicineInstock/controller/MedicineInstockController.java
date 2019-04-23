package com.qhit.medicineInstock.controller; 

import com.qhit.common.commonUtils;
import com.qhit.medicineInstock.pojo.MedicineInstock;
import com.qhit.medicineInstock.service.IMedicineInstockService;
import com.qhit.medicineInstock.service.impl.MedicineInstockServiceImpl;
import com.qhit.medicinePurchaseInfo.pojo.MedicinePurchaseInfo;
import com.qhit.medicinePurchaseInfo.service.IMedicinePurchaseInfoService;
import com.qhit.medicinePurchaseInfo.service.impl.MedicinePurchaseInfoServiceImpl;
import com.qhit.medicineStockinfo.pojo.MedicineStockinfo;
import com.qhit.medicineStockinfo.service.IMedicineStockinfoService;
import com.qhit.medicineStockinfo.service.impl.MedicineStockinfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON; 
import java.io.IOException; 
import java.util.List; 

/**
* Created by GeneratorCode on 2018/12/11
*/
@Controller 
@RequestMapping("/medicineInstock") 
public class MedicineInstockController {
    IMedicineInstockService medicineInstockService=new MedicineInstockServiceImpl();
    IMedicinePurchaseInfoService medicinePurchaseInfoService=new MedicinePurchaseInfoServiceImpl();
    IMedicineStockinfoService medicineStockinfoService=new MedicineStockinfoServiceImpl();

    @RequestMapping("/insert") 
    public String insert(String checked, String text, HttpSession session) {
        String[] pchId=checked.split(",");
        String[] input=text.split(",");
        for (int i=0;i<pchId.length;i++){
            MedicinePurchaseInfo byId = medicinePurchaseInfoService.findById(pchId[i]);
            MedicineInstock medicineInstock = new MedicineInstock();
            medicineInstock.setInvno(input[i]);
            medicineInstock.setMedicineCodeid(byId.getMedicineCodeid());
            medicineInstock.setInamt(byId.getPchAmt());
            medicineInstock.setUnitprc(byId.getPchPrice());
            medicineInstock.setZje(byId.getPchTotal());
            medicineInstock.setInstockUserid(commonUtils.getUserId(session));
            medicineInstock.setInstockDate(commonUtils.dateStr());
            medicineInstock.setManCode(byId.getManCode());
            //往入库记录表中插入数据
            medicineInstockService.insert(medicineInstock);
            //更新采购信息表，状态为3(采购已入库)
            byId.setStatus(3);
            medicinePurchaseInfoService.update(byId);
            //更新库存表
            //如果库存表中没有该药品，则直接插入数据
            //如果库存表中有该药品，则添加药品数量和总金额，然后重新计算单价=总金额/药品数量,最后执行更新。
            /*计划使用集合进行以上三行操作，*/
            List<MedicineStockinfo> all = medicineStockinfoService.findAll();
            if (all==null){
                MedicineStockinfo medicineStockinfo = new MedicineStockinfo();
                medicineStockinfo.setMedicinecodeId(byId.getMedicineCodeid());
                medicineStockinfo.setAmt(byId.getPchAmt());
                medicineStockinfo.setUnitprc(byId.getPchPrice());
                medicineStockinfo.setSaleunitprc(byId.getPchPrice()*1.5);
                medicineStockinfo.setZje(byId.getPchTotal());
                medicineStockinfoService.insert(medicineStockinfo);
            }else {
                boolean flag=false;
                MedicineStockinfo ms=null;
                for (MedicineStockinfo m:all){
                    if (m.getMedicinecodeId()==byId.getMedicineCodeid()){
                        flag=true;
                        ms.setAmt(m.getAmt());
                        ms.setSaleunitprc(m.getSaleunitprc());
                        ms.setZje(m.getZje());
                        ms.setUnitprc(m.getUnitprc());
                        break;
                    }
                }
                if (flag){
                    MedicineStockinfo medicineStockinfo = medicineStockinfoService.findByMedicinecodeId(byId.getMedicineCodeid());
                    medicineStockinfo.setMedicinecodeId(byId.getMedicineCodeid());
                    medicineStockinfo.setAmt(ms.getAmt()+byId.getPchAmt());
                    medicineStockinfo.setSaleunitprc(ms.getSaleunitprc());
                    medicineStockinfo.setZje(ms.getZje()+byId.getPchTotal());
                    medicineStockinfo.setUnitprc((ms.getZje()+byId.getPchTotal())/(ms.getAmt()+byId.getPchAmt()));
                    medicineStockinfoService.update(medicineStockinfo);
                }else {
                    MedicineStockinfo medicineStockinfo = new MedicineStockinfo();
                    medicineStockinfo.setMedicinecodeId(byId.getMedicineCodeid());
                    medicineStockinfo.setAmt(byId.getPchAmt());
                    medicineStockinfo.setUnitprc(byId.getPchPrice());
                    medicineStockinfo.setSaleunitprc(byId.getPchPrice()*1.5);
                    medicineStockinfo.setZje(byId.getPchTotal());
                    boolean insert = medicineStockinfoService.insert(medicineStockinfo);
                }
            }
        }
        return "forward:list.action";
    } 
 
    @RequestMapping("/delete") 
    public String delete(Integer instockId, HttpServletResponse response) throws IOException { 
        medicineInstockService.delete(instockId); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/update") 
    public String update(MedicineInstock medicineInstock) { 
        medicineInstockService.update(medicineInstock); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/updateSelective") 
    public String updateSelective(MedicineInstock medicineInstock) { 
        medicineInstockService.updateSelective(medicineInstock); 
        return "forward:list.action"; 
    } 
 
    @RequestMapping("/load") 
    public String load(Integer instockId, Model model) { 
        MedicineInstock medicineInstock = medicineInstockService.findById(instockId); 
        model.addAttribute("medicineInstock",medicineInstock); 
        return "medicineInstock/edit"; 
    } 
 
    @RequestMapping("/list") 
    public String list(Model model) throws IOException {
        List<MedicinePurchaseInfo> list = medicinePurchaseInfoService.findByStatus();
//        List<MedicineInstock> list = medicineInstockService.findAll();
//        for (MedicinePurchaseInfo m:list){
//            System.out.println(m.toString());
//        }
        model.addAttribute("list",list); 
        return "medicineInstock/list"; 
    } 
 
    @RequestMapping("/ajaxList") 
    public void ajaxList(HttpServletResponse response) throws IOException { 
        List<MedicineInstock> list = medicineInstockService.findAll();
        String s = JSON.toJSONString(list);
        response.getWriter().write(s); 
    } 
 
    @RequestMapping("/search") 
    public String search(MedicineInstock medicineInstock,Model model) { 
        List<MedicineInstock> list = medicineInstockService.search(medicineInstock);
        model.addAttribute("list",list);
        model.addAttribute("searchObject",medicineInstock); 
        return "medicineInstock/list"; 
    } 
 
} 
