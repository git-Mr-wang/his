package com.qhit.doctorMenuMedicine.service;

import java.util.List;
import com.qhit.doctorMenuMedicine.pojo.DoctorMenuMedicine;
/**
* Created by GeneratorCode on 2018/12/19
*/

public interface IDoctorMenuMedicineService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    DoctorMenuMedicine findById(Object id);

    boolean freeUpdate(String sql);

    List<DoctorMenuMedicine> search(DoctorMenuMedicine doctorMenuMedicine);

    boolean deleteMenuId(String menuId);
}