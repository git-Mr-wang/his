package com.qhit.patientRegisterRecord.dao;

import org.springframework.stereotype.Repository;
import com.qhit.patientRegisterRecord.pojo.PatientRegisterRecord;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/26
*/

@Repository  
public interface IPatientRegisterRecordDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List<PatientRegisterRecord> search(PatientRegisterRecord patientRegisterRecord);

    List findByPatientId(Object patientId);

    List findByDeptId(Object deptId);

    List findByRegisterDate(Object registerDate);

    List findByRecordUser(Object recordUser);

    List findByDoctorId(Object doctorId);

    List findByStatus(Object status);

    List<PatientRegisterRecord> FindList(Integer userId);
}