package com.qhit.medicineInstock.dao;

import com.qhit.utils.BaseDao;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/11
*/

public interface IMedicineInstockDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List findByInvno(Object invno);

    List findByMedicineCodeid(Object medicineCodeid);

    List findByInamt(Object inamt);

    List findByUnitprc(Object unitprc);

    List findByZje(Object zje);

    List findByInstockUserid(Object instockUserid);

    List findByInstockDate(Object instockDate);

    List findByManCode(Object manCode);

}