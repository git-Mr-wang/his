package com.qhit.doctorMenu.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Created by GeneratorCode on 2018/12/19
*/
@Repository
public interface IDoctorMenuDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List findByMenuName(Object menuName);

    List findByUserId(Object userId);

    List findByDescription(Object description);

    List findByType(Object type);

}