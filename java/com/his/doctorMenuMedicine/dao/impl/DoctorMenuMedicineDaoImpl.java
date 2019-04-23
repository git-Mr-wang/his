package com.qhit.doctorMenuMedicine.dao.impl;

import com.qhit.doctorMenuMedicine.dao.IDoctorMenuMedicineDao;
import com.qhit.utils.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Created by GeneratorCode on 2018/12/19
*/
public class DoctorMenuMedicineDaoImpl extends BaseDao implements IDoctorMenuMedicineDao {

    @Override 
    public List findAll() { 
        String sql = "select * from doctor_menu_medicine"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findById(Object id) { 
        String sql = "select * from doctor_menu_medicine where md_id='"+id+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByMenuId(Object menuId) { 
        String sql = "select * from doctor_menu_medicine where menu_id='"+menuId+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByCodeId(Object codeId) { 
        String sql = "select * from doctor_menu_medicine where code_id='"+codeId+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByAmt(Object amt) { 
        String sql = "select * from doctor_menu_medicine where amt='"+amt+"'"; 
        return freeFind(sql); 
    } 




}