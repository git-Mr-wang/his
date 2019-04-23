package com.qhit.baseManufacturer.dao.impl;

import com.qhit.baseManufacturer.dao.IBaseManufacturerDao;
import com.qhit.utils.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Created by GeneratorCode on 2018/12/03
*/
public class BaseManufacturerDaoImpl extends BaseDao implements IBaseManufacturerDao {

    @Override 
    public List findAll() { 
        String sql = "select * from base_manufacturer"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findById(Object id) { 
        String sql = "select * from base_manufacturer where man_Code='"+id+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByNote(Object note) { 
        String sql = "select * from base_manufacturer where note='"+note+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByPy1(Object py1) { 
        String sql = "select * from base_manufacturer where py1='"+py1+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByManChnName(Object manChnName) { 
        String sql = "select * from base_manufacturer where man_chn_name='"+manChnName+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByManEngDesc(Object manEngDesc) { 
        String sql = "select * from base_manufacturer where man_eng_desc='"+manEngDesc+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByManAbsName(Object manAbsName) { 
        String sql = "select * from base_manufacturer where man_abs_name='"+manAbsName+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByAddress(Object address) { 
        String sql = "select * from base_manufacturer where address='"+address+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByFaxNo(Object faxNo) { 
        String sql = "select * from base_manufacturer where fax_no='"+faxNo+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByNationCode(Object nationCode) { 
        String sql = "select * from base_manufacturer where nation_code='"+nationCode+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByPostCode(Object postCode) { 
        String sql = "select * from base_manufacturer where post_code='"+postCode+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByTelNo(Object telNo) { 
        String sql = "select * from base_manufacturer where tel_no='"+telNo+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByWebsite(Object website) { 
        String sql = "select * from base_manufacturer where website='"+website+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByEmail(Object email) { 
        String sql = "select * from base_manufacturer where email='"+email+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByStateCode(Object stateCode) { 
        String sql = "select * from base_manufacturer where state_code='"+stateCode+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByCityCode(Object cityCode) { 
        String sql = "select * from base_manufacturer where city_code='"+cityCode+"'"; 
        return freeFind(sql); 
    } 




}