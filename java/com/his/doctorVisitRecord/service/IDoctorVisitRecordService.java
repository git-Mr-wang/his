package com.qhit.doctorVisitRecord.service;

import java.util.List;
import com.qhit.doctorVisitRecord.pojo.DoctorVisitRecord;
/**
* Created by GeneratorCode on 2019/01/02
*/

public interface IDoctorVisitRecordService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    DoctorVisitRecord findById(Object id);

    List<DoctorVisitRecord> search(DoctorVisitRecord doctorVisitRecord);

}