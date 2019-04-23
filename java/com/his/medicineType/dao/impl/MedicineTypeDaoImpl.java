package com.qhit.medicineType.dao.impl;

import com.qhit.medicineType.dao.IMedicineTypeDao;
import com.qhit.utils.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Created by GeneratorCode on 2018/12/03
*/
public class MedicineTypeDaoImpl extends BaseDao implements IMedicineTypeDao {

    @Override
    public List findAll() { 
        String sql = "select * from medicine_type"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findById(Object id) { 
        String sql = "select * from medicine_type where type_id='"+id+"'"; 
        return freeFind(sql); 
    }


    @Override 
    public List findByTypeName(Object typeName) { 
        String sql = "select * from medicine_type where type_name='"+typeName+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByRemark(Object remark) { 
        String sql = "select * from medicine_type where remark='"+remark+"'"; 
        return freeFind(sql); 
    } 




}