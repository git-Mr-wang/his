package com.qhit.medicineStockinfo.dao;

import com.qhit.utils.BaseDao;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/11
*/

public interface IMedicineStockinfoDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List findByMedicinecodeId(Object medicinecodeId);

    List findByAmt(Object amt);

    List findByUnitprc(Object unitprc);

    List findBySaleunitprc(Object saleunitprc);

    List findByZje(Object zje);

}