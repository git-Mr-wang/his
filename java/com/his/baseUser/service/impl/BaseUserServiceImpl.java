package com.qhit.baseUser.service.impl;

import com.qhit.baseUser.service.IBaseUserService;
import java.util.List;
import com.qhit.baseUser.dao.IBaseUserDao;
import com.qhit.baseUser.pojo.BaseUser;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2018/12/27
*/

@Service 
public class BaseUserServiceImpl  implements IBaseUserService {

    @Resource 
    IBaseUserDao dao;

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
        BaseUser baseUser = findById(id); 
        return dao.delete(baseUser); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public BaseUser findById(Object id) { 
        List<BaseUser> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public List<BaseUser> search(BaseUser baseUser) { 
        return dao.search(baseUser); 
    }

    @Override
    public List query(String cname, String sex) {
        String sql="SELECT * from base_user WHERE cname LIKE '%"+cname+"%' AND sex LIKE '%"+sex+"%'";
        List<BaseUser> list = dao.query(cname,sex);
        return list;
    }

    @Override
    public BaseUser login(BaseUser baseUser) {
//        String sql="SELECT * from base_user bu LEFT JOIN base_user_role bur ON bu.user_id=bur.uid" +
//                " LEFT JOIN base_role br ON br.rid=bur.rid" +
//                " LEFT JOIN base_role_function brf ON brf.rid=br.rid" +
//                " LEFT JOIN base_function bf ON bf.fid=brf.fid" +
//                " WHERE bu.user_name='"+baseUser.getUserName()+"' AND bu.password='"+baseUser.getPassword()+"'";
        List<BaseUser> list = dao.login(baseUser);
        return (list!=null&&list.size()>0)?list.get(0):null;
    }

    @Override
    public List<BaseUser> ajaxSearch(Integer deptId) {
        return dao.findByDeptId(deptId);
    }


}