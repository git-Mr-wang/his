package com.qhit.baseUserRole.dao.impl;

import com.qhit.baseUserRole.dao.IBaseUserRoleDao;
import com.qhit.utils.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Created by GeneratorCode on 2018/11/29
*/

public class BaseUserRoleDaoImpl extends BaseDao implements IBaseUserRoleDao {

    @Override 
    public List findAll() { 
        String sql = "select * from base_user_role"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findById(Object id) { 
        String sql = "select * from base_user_role where urid='"+id+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByUid(Object uid) { 
        String sql = "select * from base_user_role where uid='"+uid+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByRid(Object rid) { 
        String sql = "select * from base_user_role where rid='"+rid+"'"; 
        return freeFind(sql); 
    } 




}