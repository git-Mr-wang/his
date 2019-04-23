package com.qhit.medicineReqPlan.dao.impl;

import com.qhit.medicineReqPlan.dao.IMedicineReqPlanDao;
import com.qhit.utils.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Created by GeneratorCode on 2018/12/04
*/
public class MedicineReqPlanDaoImpl extends BaseDao implements IMedicineReqPlanDao {

    @Override 
    public List findAll() { 
        String sql = "SELECT * from medicine_req_plan mrp " +
                "                   JOIN medicine_code mc ON mrp.MEDICINE_CODEID=mc.code_id " +
                "                   JOIN base_user bu ON bu.user_id=mrp.APP_USERID;";
        return freeFind(sql); 
    } 


    @Override 
    public List findById(Object id) { 
        String sql = "select * from medicine_req_plan where REQPLNNO='"+id+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByMedicineCodeid(Object medicineCodeid) { 
        String sql = "select * from medicine_req_plan where MEDICINE_CODEID='"+medicineCodeid+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByReqamt(Object reqamt) { 
        String sql = "select * from medicine_req_plan where REQAMT='"+reqamt+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByAppUserid(Object appUserid) { 
        String sql = "select * from medicine_req_plan where APP_USERID='"+appUserid+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByAppDate(Object appDate) { 
        String sql = "select * from medicine_req_plan where APP_DATE='"+appDate+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByPurpose(Object purpose) { 
        String sql = "select * from medicine_req_plan where PURPOSE='"+purpose+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByStatus(Object status) { 
        String sql = "select * from medicine_req_plan where STATUS='"+status+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByApprvUserid(Object apprvUserid) { 
        String sql = "select * from medicine_req_plan where APPRV_USERID='"+apprvUserid+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByApprvDate(Object apprvDate) { 
        String sql = "select * from medicine_req_plan where APPRV_DATE='"+apprvDate+"'"; 
        return freeFind(sql); 
    } 




}