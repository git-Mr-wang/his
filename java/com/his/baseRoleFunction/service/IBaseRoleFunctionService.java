package com.qhit.baseRoleFunction.service;

import java.util.List;
import com.qhit.baseRoleFunction.pojo.BaseRoleFunction;
/**
* Created by GeneratorCode on 2018/12/19
*/

public interface IBaseRoleFunctionService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    BaseRoleFunction findById(Object id);

    boolean freeUpdate(String sql);

    List<BaseRoleFunction> search(BaseRoleFunction baseRoleFunction);

    List<BaseRoleFunction> findByRid(Integer rid);
}