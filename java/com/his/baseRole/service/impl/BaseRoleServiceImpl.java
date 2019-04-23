package com.qhit.baseRole.service.impl;

import com.qhit.baseFunction.pojo.BaseFunction;
import com.qhit.baseRole.service.IBaseRoleService;
import java.util.List;
import com.qhit.baseRole.dao.IBaseRoleDao;
import com.qhit.baseRole.dao.impl.BaseRoleDaoImpl;
import com.qhit.baseRole.pojo.BaseRole;
import com.qhit.baseRoleFunction.pojo.BaseRoleFunction;
import com.qhit.baseRoleFunction.service.IBaseRoleFunctionService;
import com.qhit.baseRoleFunction.service.impl.BaseRoleFunctionServiceImpl;
import com.qhit.baseUserRole.pojo.BaseUserRole;
import com.qhit.utils.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* Created by GeneratorCode on 2018/11/29
*/

public class BaseRoleServiceImpl  implements IBaseRoleService {
    IBaseRoleDao dao=new BaseRoleDaoImpl();
    IBaseRoleFunctionService baseRoleFunctionService=new BaseRoleFunctionServiceImpl();

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
        BaseRole baseRole = findById(id); 
        return dao.delete(baseRole); 
    } 


    @Override 
    public List findAll() {
        return dao.findAll();
    } 


    @Override 
    public BaseRole findById(Object id) { 
        List<BaseRole> list = dao.findById(id); 
        return  list.get(0); 
    }

    @Override
    public List<BaseRole> findByName(String rname) {
        String sql="SELECT* from base_role WHERE rname LIKE '%"+rname+"%';";
        return dao.freeFind(sql);
    }

    @Override
    public List<BaseRole> notIn(Integer userId) {
        String sql="SELECT * from base_role br WHERE br.rname NOT IN " +
                "(SELECT br.rname from base_role br JOIN base_user_role bur ON bur.rid=br.rid " +
                "WHERE bur.uid="+userId+");";
        return dao.freeFind(sql);
    }

    @Override
    public List<BaseRole> findAll2(Integer userId) {
        String sql="SELECT * from base_role br JOIN base_user_role bur " +
                "ON bur.rid=br.rid WHERE bur.uid="+userId+"";
        return dao.freeFind(sql);
    }

    @Override
    public BaseRole findByRname(String rname) {
        List<BaseRole> list = dao.findByRname(rname);
        return list.get(0);
    }
    @Override
    public List<BaseFunction> distributeLeft(BaseRole baseRole) {
        String sql = "select * from base_function bf where bf.fid not in " +
                "(select brf.fid from base_role br join base_role_function brf on br.rid = brf.rid and br.rid = '"+baseRole.getRid()+"' )";
        return dao.freeFind(sql);
    }

    @Override
    public List<BaseFunction> distributeRight(BaseRole baseRole) {
        String sql = "select * from base_function bf where bf.fid  in " +
                "(select brf.fid from base_role br join base_role_function brf on br.rid = brf.rid and br.rid = '"+baseRole.getRid()+"' )";
        return dao.freeFind(sql);
    }

    @Override
    public void distributeUpdate(Integer rid, String[] fid) {
        //        删除base_role_function表中所有userId记录
        String  delSql = "delete from base_role_function where rid = "+rid;
        BaseDao baseDao=new BaseDao();
        baseDao.freeUpdate(delSql);
//        批量插入
        for(String s:fid){
            BaseRoleFunction baseRoleFunction = new BaseRoleFunction();
            baseRoleFunction.setFid(Integer.parseInt(s));
            baseRoleFunction.setRid(rid);
            baseRoleFunctionService.insert(baseRoleFunction);
        }
    }

    @Override
    public String findLogin(Integer userId) {
        String sql="SELECT * from base_role br JOIN base_user_role bur ON br.rid=bur.rid " +
                "                               JOIN base_user bu ON bu.user_id=bur.uid" +
                "                               WHERE bu.user_id="+userId+";";
        List<BaseRole> list = dao.freeFind(sql);
        return list.get(0).getRname();
    }


}