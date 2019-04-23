package com.qhit.telvisit.service;

import java.util.List;
import com.qhit.telvisit.pojo.Telvisit;
/**
* Created by GeneratorCode on 2018/12/24
*/

public interface ITelvisitService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    Telvisit findById(Object id);

    List<Telvisit> search(Telvisit telvisit);

}