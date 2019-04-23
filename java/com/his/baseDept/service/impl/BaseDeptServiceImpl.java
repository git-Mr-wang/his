package com.qhit.baseDept.service.impl;

import com.qhit.baseDept.service.IBaseDeptService;
import java.util.List;
import com.qhit.baseDept.dao.IBaseDeptDao;
import com.qhit.baseDept.pojo.BaseDept;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2018/12/27
*/

@Service 
public class BaseDeptServiceImpl  implements IBaseDeptService {

    @Resource 
    IBaseDeptDao dao;

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
        BaseDept baseDept = findById(id); 
        return dao.delete(baseDept); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public BaseDept findById(Object id) { 
        List<BaseDept> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public List<BaseDept> search(BaseDept baseDept) { 
        return dao.search(baseDept); 
    } 


}