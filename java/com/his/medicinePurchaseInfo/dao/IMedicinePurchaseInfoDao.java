package com.qhit.medicinePurchaseInfo.dao;

import com.qhit.utils.BaseDao;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/04
*/

public interface IMedicinePurchaseInfoDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List findByMedicineCodeid(Object medicineCodeid);

    List findByManCode(Object manCode);

    List findByPchAmt(Object pchAmt);

    List findByPchPrice(Object pchPrice);

    List findByPchTotal(Object pchTotal);

    List findByStatus(Object status);

    List findByPchUserid(Object pchUserid);

    List findByPchDate(Object pchDate);

    List findByApprvUserid(Object apprvUserid);

    List findByApprvDate(Object apprvDate);

}