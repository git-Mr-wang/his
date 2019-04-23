package com.qhit.medicineReqPlan.service;

import java.util.List;
import com.qhit.medicineReqPlan.pojo.MedicineReqPlan;
/**
* Created by GeneratorCode on 2018/12/04
*/

public interface IMedicineReqPlanService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll(Integer userId);

    MedicineReqPlan findById(Object id);

    boolean freeUpdate(String sql);

    List<MedicineReqPlan> search(MedicineReqPlan medicineReqPlan);

}