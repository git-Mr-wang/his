package com.qhit.baseRole.service;

import java.util.List;

import com.qhit.baseFunction.pojo.BaseFunction;
import com.qhit.baseRole.pojo.BaseRole;
import com.qhit.baseUserRole.pojo.BaseUserRole;

/**
* Created by GeneratorCode on 2018/11/29
*/

public interface IBaseRoleService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    BaseRole findById(Object id);

    BaseRole findByRname(String rname);

    List<BaseRole> findByName(String rname);

    List<BaseRole> notIn(Integer userId);

    List<BaseRole> findAll2(Integer userId);

    List<BaseFunction> distributeLeft(BaseRole baseRole);

    List<BaseFunction> distributeRight(BaseRole baseRole);

    void distributeUpdate(Integer rid, String[] fid);

    String findLogin(Integer userId);
}