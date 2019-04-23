package com.qhit.baseUserRole.service;

import java.util.List;
import com.qhit.baseUserRole.pojo.BaseUserRole;
/**
* Created by GeneratorCode on 2018/11/29
*/

public interface IBaseUserRoleService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll(Integer userId);

    BaseUserRole findById(Object id);

    List<BaseUserRole> findAll2(Integer userId);

    List<BaseUserRole> notIn(Integer userId);

    boolean deleteUid(Integer uid);
}