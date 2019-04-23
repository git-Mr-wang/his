package com.qhit.medicineType.service;

import java.util.List;
import com.qhit.medicineType.pojo.MedicineType;
/**
* Created by GeneratorCode on 2018/12/03
*/

public interface IMedicineTypeService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    MedicineType findById(Object id);

    boolean freeUpdate(String sql);

    List<MedicineType> search(MedicineType medicineType);

}