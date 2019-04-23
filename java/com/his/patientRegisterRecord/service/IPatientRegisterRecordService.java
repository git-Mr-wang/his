package com.qhit.patientRegisterRecord.service;

import java.util.List;
import com.qhit.patientRegisterRecord.pojo.PatientRegisterRecord;
/**
* Created by GeneratorCode on 2018/12/26
*/

public interface IPatientRegisterRecordService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    PatientRegisterRecord findById(Object id);

    List<PatientRegisterRecord> search(PatientRegisterRecord patientRegisterRecord);

    List<PatientRegisterRecord> FindList(Integer userId);
}