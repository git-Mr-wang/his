package com.qhit.inPatient.service;

import java.util.List;
import com.qhit.inPatient.pojo.InPatient;
/**
* Created by GeneratorCode on 2019/01/15
*/

public interface IInPatientService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    InPatient findById(Object id);

    List<InPatient> search(InPatient inPatient);

    List<InPatient> search2(Integer status);

    List<InPatient> findAllSort(String sql);

    List<InPatient> findAllSort2(String asc);
}