package com.qhit.patientRegisterRecord.service.impl;

import com.qhit.patientRegisterRecord.service.IPatientRegisterRecordService;
import java.util.List;
import com.qhit.patientRegisterRecord.dao.IPatientRegisterRecordDao;
import com.qhit.patientRegisterRecord.pojo.PatientRegisterRecord;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2018/12/26
*/

@Service 
public class PatientRegisterRecordServiceImpl  implements IPatientRegisterRecordService {

    @Resource 
    IPatientRegisterRecordDao dao;

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
        PatientRegisterRecord patientRegisterRecord = findById(id); 
        return dao.delete(patientRegisterRecord); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public PatientRegisterRecord findById(Object id) { 
        List<PatientRegisterRecord> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public List<PatientRegisterRecord> search(PatientRegisterRecord patientRegisterRecord) { 
        return dao.search(patientRegisterRecord); 
    }

    @Override
    public List<PatientRegisterRecord> FindList(Integer userId) {
        return dao.FindList(userId);
    }


}