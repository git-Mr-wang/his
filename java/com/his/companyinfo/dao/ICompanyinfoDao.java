package com.qhit.companyinfo.dao;

import com.qhit.utils.BaseDao;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/04
*/

public interface ICompanyinfoDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List findByCompname(Object compname);

    List findByOwnername(Object ownername);

    List findByOwnertel(Object ownertel);

    List findByCompinfo(Object compinfo);

}