package com.qhit.medicinePurchaseInfo.dao.impl;

import com.qhit.medicinePurchaseInfo.dao.IMedicinePurchaseInfoDao;
import com.qhit.utils.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Created by GeneratorCode on 2018/12/04
*/
public class MedicinePurchaseInfoDaoImpl extends BaseDao implements IMedicinePurchaseInfoDao {

    @Override
    public List findAll() { 
        String sql = "select * from medicine_purchase_info"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findById(Object id) { 
        String sql = "select * from medicine_purchase_info where PCH_ID='"+id+"'"; 
        return freeFind(sql); 
    }


    @Override 
    public List findByMedicineCodeid(Object medicineCodeid) { 
        String sql = "select * from medicine_purchase_info where MEDICINE_CODEID='"+medicineCodeid+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByManCode(Object manCode) { 
        String sql = "select * from medicine_purchase_info where MAN_CODE='"+manCode+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByPchAmt(Object pchAmt) { 
        String sql = "select * from medicine_purchase_info where PCH_AMT='"+pchAmt+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByPchPrice(Object pchPrice) { 
        String sql = "select * from medicine_purchase_info where PCH_PRICE='"+pchPrice+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByPchTotal(Object pchTotal) { 
        String sql = "select * from medicine_purchase_info where PCH_TOTAL='"+pchTotal+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByStatus(Object status) { 
        String sql = "select * from medicine_purchase_info where STATUS='"+status+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByPchUserid(Object pchUserid) { 
        String sql = "select * from medicine_purchase_info where PCH_USERID='"+pchUserid+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByPchDate(Object pchDate) { 
        String sql = "select * from medicine_purchase_info where PCH_DATE='"+pchDate+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByApprvUserid(Object apprvUserid) { 
        String sql = "select * from medicine_purchase_info where APPRV_USERID='"+apprvUserid+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByApprvDate(Object apprvDate) { 
        String sql = "select * from medicine_purchase_info where APPRV_DATE='"+apprvDate+"'"; 
        return freeFind(sql); 
    } 




}