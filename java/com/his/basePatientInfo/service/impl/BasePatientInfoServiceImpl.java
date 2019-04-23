package com.qhit.basePatientInfo.service.impl;

import com.qhit.basePatientInfo.service.IBasePatientInfoService;
import java.util.List;
import com.qhit.basePatientInfo.dao.IBasePatientInfoDao;
import com.qhit.basePatientInfo.pojo.BasePatientInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2018/12/26
*/

@Service 
public class BasePatientInfoServiceImpl  implements IBasePatientInfoService {

    @Resource 
    IBasePatientInfoDao dao;

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
        BasePatientInfo basePatientInfo = findById(id); 
        return dao.delete(basePatientInfo); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public BasePatientInfo findById(Object id) { 
        List<BasePatientInfo> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public List<BasePatientInfo> search(BasePatientInfo basePatientInfo) { 
        return dao.search(basePatientInfo); 
    }

    @Override
    public List<BasePatientInfo> ajaxSearch(BasePatientInfo basePatientInfo) {
        return dao.ajaxSearch(basePatientInfo);
    }


}