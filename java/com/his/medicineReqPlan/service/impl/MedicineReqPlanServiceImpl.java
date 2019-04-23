package com.qhit.medicineReqPlan.service.impl;

import com.qhit.medicineReqPlan.service.IMedicineReqPlanService;
import java.util.List;
import com.qhit.medicineReqPlan.dao.IMedicineReqPlanDao;
import com.qhit.medicineReqPlan.dao.impl.MedicineReqPlanDaoImpl;
import com.qhit.medicineReqPlan.pojo.MedicineReqPlan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* Created by GeneratorCode on 2018/12/04
*/
public class MedicineReqPlanServiceImpl  implements IMedicineReqPlanService {
    IMedicineReqPlanDao dao=new MedicineReqPlanDaoImpl();

    @Override 
    public boolean insert(Object object) {
        return dao.insert(object); 
    } 


    @Override 
    public boolean update(Object object) { 
        return dao.update(object); 
    } 


    @Override 
    public boolean updateSelective(Object object) { 
        return dao.updateSelective(object); 
    } 


    @Override 
    public boolean delete(Object id) { 
        MedicineReqPlan medicineReqPlan = findById(id); 
        return dao.delete(medicineReqPlan); 
    } 


    @Override 
    public List findAll(Integer userId) {
        String sql = "SELECT * from medicine_req_plan mrp JOIN medicine_code mc ON mrp.MEDICINE_CODEID=mc.code_id JOIN base_user bu ON bu.user_id=mrp.APP_USERID " +
                "AND mrp.APP_USERID = "+userId;
        return dao.freeFind(sql);
    } 


    @Override 
    public MedicineReqPlan findById(Object id) { 
        List<MedicineReqPlan> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public boolean freeUpdate(String sql) {
        return dao.freeUpdate(sql);
    }


    @Override 
    public List<MedicineReqPlan> search(MedicineReqPlan medicineReqPlan) {
            String sql = "select * from medicine_req_plan where 1=1 "; 
            if (medicineReqPlan.getMedicineCodeid()!=null && !"".equals(medicineReqPlan.getMedicineCodeid())){        
                sql+=" and MEDICINE_CODEID like '%"+medicineReqPlan.getMedicineCodeid()+"%' ";        
            } 
            if (medicineReqPlan.getReqamt()!=null && !"".equals(medicineReqPlan.getReqamt())){        
                sql+=" and REQAMT like '%"+medicineReqPlan.getReqamt()+"%' ";        
            } 
            if (medicineReqPlan.getAppUserid()!=null && !"".equals(medicineReqPlan.getAppUserid())){        
                sql+=" and APP_USERID like '%"+medicineReqPlan.getAppUserid()+"%' ";        
            } 
            if (medicineReqPlan.getAppDate()!=null && !"".equals(medicineReqPlan.getAppDate())){        
                sql+=" and APP_DATE like '%"+medicineReqPlan.getAppDate()+"%' ";        
            } 
            if (medicineReqPlan.getPurpose()!=null && !"".equals(medicineReqPlan.getPurpose())){        
                sql+=" and PURPOSE like '%"+medicineReqPlan.getPurpose()+"%' ";        
            } 
            if (medicineReqPlan.getStatus()!=null && !"".equals(medicineReqPlan.getStatus())){        
                sql+=" and STATUS like '%"+medicineReqPlan.getStatus()+"%' ";        
            } 
            if (medicineReqPlan.getApprvUserid()!=null && !"".equals(medicineReqPlan.getApprvUserid())){        
                sql+=" and APPRV_USERID like '%"+medicineReqPlan.getApprvUserid()+"%' ";        
            } 
            if (medicineReqPlan.getApprvDate()!=null && !"".equals(medicineReqPlan.getApprvDate())){        
                sql+=" and APPRV_DATE like '%"+medicineReqPlan.getApprvDate()+"%' ";        
            } 
            List<MedicineReqPlan> list = dao.freeFind(sql);        
            return list;        
    }


}