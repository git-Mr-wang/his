package com.qhit.baseUser.dao;

import org.springframework.stereotype.Repository;
import com.qhit.baseUser.pojo.BaseUser;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/27
*/

@Repository  
public interface IBaseUserDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List<BaseUser> search(BaseUser baseUser);

    List findByUserName(Object userName);

    List findByPassword(Object password);

    List findByCname(Object cname);

    List findBySex(Object sex);

    List findByDeptId(Object deptId);

    List findByPostId(Object postId);

    List<BaseUser> login(BaseUser baseUser);

    List<BaseUser> query(String cname, String sex);

//    List<BaseUser> ajaxSerch(String deptId);
}