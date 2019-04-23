package com.qhit.medicineInstock.dao.impl;

import com.qhit.medicineInstock.dao.IMedicineInstockDao;
import com.qhit.utils.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Created by GeneratorCode on 2018/12/11
*/
public class MedicineInstockDaoImpl extends BaseDao implements IMedicineInstockDao {

    @Override 
    public List findAll() { 
        String sql = "select * from medicine_instock"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findById(Object id) { 
        String sql = "select * from medicine_instock where instock_id='"+id+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByInvno(Object invno) { 
        String sql = "select * from medicine_instock where invno='"+invno+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByMedicineCodeid(Object medicineCodeid) { 
        String sql = "select * from medicine_instock where medicine_codeid='"+medicineCodeid+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByInamt(Object inamt) { 
        String sql = "select * from medicine_instock where inamt='"+inamt+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByUnitprc(Object unitprc) { 
        String sql = "select * from medicine_instock where unitprc='"+unitprc+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByZje(Object zje) { 
        String sql = "select * from medicine_instock where zje='"+zje+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByInstockUserid(Object instockUserid) { 
        String sql = "select * from medicine_instock where instock_userid='"+instockUserid+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByInstockDate(Object instockDate) { 
        String sql = "select * from medicine_instock where instock_date='"+instockDate+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByManCode(Object manCode) { 
        String sql = "select * from medicine_instock where man_code='"+manCode+"'"; 
        return freeFind(sql); 
    } 




}