package com.qhit.baseManufacturer.service;

import java.util.List;
import com.qhit.baseManufacturer.pojo.BaseManufacturer;
/**
* Created by GeneratorCode on 2018/12/03
*/

public interface IBaseManufacturerService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    BaseManufacturer findById(Object id);

    boolean freeUpdate(String sql);

    List<BaseManufacturer> search(BaseManufacturer baseManufacturer);

}