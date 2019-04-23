package com.qhit.baseDept.dao;

import org.springframework.stereotype.Repository;
import com.qhit.baseDept.pojo.BaseDept;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/27
*/

@Repository  
public interface IBaseDeptDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List<BaseDept> search(BaseDept baseDept);

    List findByDeptName(Object deptName);

}