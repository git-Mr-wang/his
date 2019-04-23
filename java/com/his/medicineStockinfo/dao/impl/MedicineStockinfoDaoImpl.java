package com.qhit.medicineStockinfo.dao.impl;

import com.qhit.medicineStockinfo.dao.IMedicineStockinfoDao;
import com.qhit.utils.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Created by GeneratorCode on 2018/12/11
*/
public class MedicineStockinfoDaoImpl extends BaseDao implements IMedicineStockinfoDao {

    @Override 
    public List findAll() { 
        String sql = "select * from medicine_stockinfo"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findById(Object id) { 
        String sql = "select * from medicine_stockinfo where stockinfo_id='"+id+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByMedicinecodeId(Object medicinecodeId) { 
        String sql = "select * from medicine_stockinfo where medicinecode_id='"+medicinecodeId+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByAmt(Object amt) { 
        String sql = "select * from medicine_stockinfo where amt='"+amt+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByUnitprc(Object unitprc) { 
        String sql = "select * from medicine_stockinfo where unitprc='"+unitprc+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findBySaleunitprc(Object saleunitprc) { 
        String sql = "select * from medicine_stockinfo where saleunitprc='"+saleunitprc+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByZje(Object zje) { 
        String sql = "select * from medicine_stockinfo where zje='"+zje+"'"; 
        return freeFind(sql); 
    } 




}