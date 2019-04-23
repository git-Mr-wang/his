package com.qhit.baseUserRole.service.impl;

import com.qhit.baseUserRole.service.IBaseUserRoleService;
import java.util.List;
import com.qhit.baseUserRole.dao.IBaseUserRoleDao;
import com.qhit.baseUserRole.dao.impl.BaseUserRoleDaoImpl;
import com.qhit.baseUserRole.pojo.BaseUserRole;
import com.qhit.utils.BaseDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* Created by GeneratorCode on 2018/11/29
*/
public class BaseUserRoleServiceImpl  implements IBaseUserRoleService {
    IBaseUserRoleDao dao=new BaseUserRoleDaoImpl();

    @Override 
    public boolean insert(Object object) { 
        return dao.insert(object); 
    } 


    @Override 
    public boolean update(Object object) { 
        return dao.update(object); 
    } 


    @Override 
    public boolean updateSelective(Object object) { 
        return dao.updateSelective(object); 
    } 


    @Override 
    public boolean delete(Object id) { 
        BaseUserRole baseUserRole = findById(id); 
        return dao.delete(baseUserRole); 
    } 


    @Override 
    public List findAll(Integer userId) {
        return dao.findAll();
    } 


    @Override 
    public BaseUserRole findById(Object id) { 
        List<BaseUserRole> list = dao.findById(id); 
        return  list.get(0); 
    }

    @Override
    public List<BaseUserRole> findAll2(Integer userId) {
        String sql="SELECT * from base_user_role bur JOIN base_role br ON bur.rid=br.rid WHERE uid="+userId+"";
        return dao.freeFind(sql);
    }

    @Override
    public List<BaseUserRole> notIn(Integer userId) {
        String sql="SELECT * from base_role br WHERE br.rname NOT IN " +
                "(SELECT br.rname from base_user_role bur JOIN base_role br ON bur.rid=br.rid WHERE uid="+userId+");";
        return dao.freeFind(sql);
    }

    @Override
    public boolean deleteUid(Integer uid) {
        String sql="DELETE from base_user_role WHERE uid="+uid+"";
        BaseDao dao = new BaseDao();
        boolean b = dao.freeUpdate(sql);
        return b;
    }


}