package com.qhit.inPatient.dao;

import org.springframework.stereotype.Repository;
import com.qhit.inPatient.pojo.InPatient;
import java.util.List;

/**
* Created by GeneratorCode on 2019/01/15
*/

@Repository  
public interface IInPatientDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List<InPatient> search(InPatient inPatient);

    List findByPatientName(Object patientName);

    List findBySex(Object sex);

    List findByBirth(Object birth);

    List findByBedNum(Object bedNum);

    List findByAmount(Object amount);

    List findByStatus(Object status);

    List<InPatient> search2(Integer status);

    List<InPatient> findAllSort(String sql);

    List<InPatient> findAllSort2(String asc);
}