package com.qhit.baseRoleFunction.dao.impl;

import com.qhit.baseRoleFunction.dao.IBaseRoleFunctionDao;
import com.qhit.utils.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Created by GeneratorCode on 2018/12/19
*/
public class BaseRoleFunctionDaoImpl extends BaseDao implements IBaseRoleFunctionDao {

    @Override
    public List findAll() { 
        String sql = "select * from base_role_function"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findById(Object id) { 
        String sql = "select * from base_role_function where rmid='"+id+"'"; 
        return freeFind(sql); 
    }


    @Override 
    public List findByRid(Object rid) { 
        String sql = "select * from base_role_function where rid='"+rid+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByFid(Object fid) { 
        String sql = "select * from base_role_function where fid='"+fid+"'"; 
        return freeFind(sql); 
    } 




}