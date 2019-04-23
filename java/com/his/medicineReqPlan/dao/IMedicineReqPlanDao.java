package com.qhit.medicineReqPlan.dao;

import com.qhit.utils.BaseDao;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/04
*/

public interface IMedicineReqPlanDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List findByMedicineCodeid(Object medicineCodeid);

    List findByReqamt(Object reqamt);

    List findByAppUserid(Object appUserid);

    List findByAppDate(Object appDate);

    List findByPurpose(Object purpose);

    List findByStatus(Object status);

    List findByApprvUserid(Object apprvUserid);

    List findByApprvDate(Object apprvDate);

}