package com.qhit.baseFunction.dao.impl;

import com.qhit.baseFunction.dao.IBaseFunctionDao;
import com.qhit.utils.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Created by GeneratorCode on 2018/11/27
*/
public class BaseFunctionDaoImpl extends BaseDao implements IBaseFunctionDao {

    @Override 
    public List findAll() { 
        String sql = "select * from base_function"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findById(Object id) { 
        String sql = "select * from base_function where fid='"+id+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByFname(Object fname) { 
        String sql = "select * from base_function where fname='"+fname+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByMid(Object mid) { 
        String sql = "select * from base_function where mid='"+mid+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByUrl(Object url) { 
        String sql = "select * from base_function where url='"+url+"'"; 
        return freeFind(sql); 
    } 




}