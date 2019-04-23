package com.qhit.baseManufacturer.dao;

import com.qhit.utils.BaseDao;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/03
*/

public interface IBaseManufacturerDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List findByNote(Object note);

    List findByPy1(Object py1);

    List findByManChnName(Object manChnName);

    List findByManEngDesc(Object manEngDesc);

    List findByManAbsName(Object manAbsName);

    List findByAddress(Object address);

    List findByFaxNo(Object faxNo);

    List findByNationCode(Object nationCode);

    List findByPostCode(Object postCode);

    List findByTelNo(Object telNo);

    List findByWebsite(Object website);

    List findByEmail(Object email);

    List findByStateCode(Object stateCode);

    List findByCityCode(Object cityCode);

}