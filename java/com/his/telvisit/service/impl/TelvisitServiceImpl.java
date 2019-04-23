package com.qhit.telvisit.service.impl;

import com.qhit.telvisit.service.ITelvisitService;
import java.util.List;
import com.qhit.telvisit.dao.ITelvisitDao;
import com.qhit.telvisit.pojo.Telvisit;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2018/12/24
*/
@Service
public class TelvisitServiceImpl  implements ITelvisitService {
    @Resource
    ITelvisitDao dao;

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
        Telvisit telvisit = findById(id); 
        return dao.delete(telvisit); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public Telvisit findById(Object id) { 
        List<Telvisit> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public List<Telvisit> search(Telvisit telvisit) { 
        return dao.search(telvisit); 
    } 


}