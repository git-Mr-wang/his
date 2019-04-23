package com.qhit.baseManufacturer.service.impl;

import com.qhit.baseManufacturer.service.IBaseManufacturerService;
import java.util.List;
import com.qhit.baseManufacturer.dao.IBaseManufacturerDao;
import com.qhit.baseManufacturer.dao.impl.BaseManufacturerDaoImpl;
import com.qhit.baseManufacturer.pojo.BaseManufacturer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* Created by GeneratorCode on 2018/12/03
*/
public class BaseManufacturerServiceImpl  implements IBaseManufacturerService {
    IBaseManufacturerDao dao=new BaseManufacturerDaoImpl();

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
        BaseManufacturer baseManufacturer = findById(id); 
        return dao.delete(baseManufacturer); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public BaseManufacturer findById(Object id) { 
        List<BaseManufacturer> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public boolean freeUpdate(String sql) {
        return dao.freeUpdate(sql);
    }


    @Override 
    public List<BaseManufacturer> search(BaseManufacturer baseManufacturer) {
            String sql = "select * from base_manufacturer where 1=1 "; 
            if (baseManufacturer.getNote()!=null && !"".equals(baseManufacturer.getNote())){        
                sql+=" and note like '%"+baseManufacturer.getNote()+"%' ";        
            } 
            if (baseManufacturer.getPy1()!=null && !"".equals(baseManufacturer.getPy1())){        
                sql+=" and py1 like '%"+baseManufacturer.getPy1()+"%' ";        
            } 
            if (baseManufacturer.getManChnName()!=null && !"".equals(baseManufacturer.getManChnName())){        
                sql+=" and man_chn_name like '%"+baseManufacturer.getManChnName()+"%' ";        
            } 
            if (baseManufacturer.getManEngDesc()!=null && !"".equals(baseManufacturer.getManEngDesc())){        
                sql+=" and man_eng_desc like '%"+baseManufacturer.getManEngDesc()+"%' ";        
            } 
            if (baseManufacturer.getManAbsName()!=null && !"".equals(baseManufacturer.getManAbsName())){        
                sql+=" and man_abs_name like '%"+baseManufacturer.getManAbsName()+"%' ";        
            } 
            if (baseManufacturer.getAddress()!=null && !"".equals(baseManufacturer.getAddress())){        
                sql+=" and address like '%"+baseManufacturer.getAddress()+"%' ";        
            } 
            if (baseManufacturer.getFaxNo()!=null && !"".equals(baseManufacturer.getFaxNo())){        
                sql+=" and fax_no like '%"+baseManufacturer.getFaxNo()+"%' ";        
            } 
            if (baseManufacturer.getNationCode()!=null && !"".equals(baseManufacturer.getNationCode())){        
                sql+=" and nation_code like '%"+baseManufacturer.getNationCode()+"%' ";        
            } 
            if (baseManufacturer.getPostCode()!=null && !"".equals(baseManufacturer.getPostCode())){        
                sql+=" and post_code like '%"+baseManufacturer.getPostCode()+"%' ";        
            } 
            if (baseManufacturer.getTelNo()!=null && !"".equals(baseManufacturer.getTelNo())){        
                sql+=" and tel_no like '%"+baseManufacturer.getTelNo()+"%' ";        
            } 
            if (baseManufacturer.getWebsite()!=null && !"".equals(baseManufacturer.getWebsite())){        
                sql+=" and website like '%"+baseManufacturer.getWebsite()+"%' ";        
            } 
            if (baseManufacturer.getEmail()!=null && !"".equals(baseManufacturer.getEmail())){        
                sql+=" and email like '%"+baseManufacturer.getEmail()+"%' ";        
            } 
            if (baseManufacturer.getStateCode()!=null && !"".equals(baseManufacturer.getStateCode())){        
                sql+=" and state_code like '%"+baseManufacturer.getStateCode()+"%' ";        
            } 
            if (baseManufacturer.getCityCode()!=null && !"".equals(baseManufacturer.getCityCode())){        
                sql+=" and city_code like '%"+baseManufacturer.getCityCode()+"%' ";        
            } 
            List<BaseManufacturer> list = dao.freeFind(sql);        
            return list;        
    }


}