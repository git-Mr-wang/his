package com.qhit.doctorVisitRecord.service.impl;

import com.qhit.doctorVisitRecord.service.IDoctorVisitRecordService;
import java.util.List;
import com.qhit.doctorVisitRecord.dao.IDoctorVisitRecordDao;
import com.qhit.doctorVisitRecord.pojo.DoctorVisitRecord;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2019/01/02
*/

@Service 
public class DoctorVisitRecordServiceImpl  implements IDoctorVisitRecordService {

    @Resource 
    IDoctorVisitRecordDao dao;

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
        DoctorVisitRecord doctorVisitRecord = findById(id); 
        return dao.delete(doctorVisitRecord); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public DoctorVisitRecord findById(Object id) { 
        List<DoctorVisitRecord> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public List<DoctorVisitRecord> search(DoctorVisitRecord doctorVisitRecord) { 
        return dao.search(doctorVisitRecord); 
    } 


}