package com.qhit.companyinfo.service.impl;

import com.qhit.companyinfo.service.ICompanyinfoService;
import java.util.List;
import com.qhit.companyinfo.dao.ICompanyinfoDao;
import com.qhit.companyinfo.dao.impl.CompanyinfoDaoImpl;
import com.qhit.companyinfo.pojo.Companyinfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* Created by GeneratorCode on 2018/12/04
*/
public class CompanyinfoServiceImpl  implements ICompanyinfoService {
    ICompanyinfoDao dao=new CompanyinfoDaoImpl();

    @Override 
    public boolean insert(Object object) { 
        return dao.insert(object); 
    } 


    @Override 
    public boolean update(Object object) { 
        return dao.update(object); 
    } 


    @Override 
    public boolean updateSelective(Object object) { 
        return dao.updateSelective(object); 
    } 


    @Override 
    public boolean delete(Object id) { 
        Companyinfo companyinfo = findById(id); 
        return dao.delete(companyinfo); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public Companyinfo findById(Object id) { 
        List<Companyinfo> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public boolean freeUpdate(String sql) {
        return dao.freeUpdate(sql);
    }


    @Override 
    public List<Companyinfo> search(Companyinfo companyinfo) {
            String sql = "select * from companyinfo where 1=1 "; 
            if (companyinfo.getCompname()!=null && !"".equals(companyinfo.getCompname())){        
                sql+=" and compname like '%"+companyinfo.getCompname()+"%' ";        
            } 
            if (companyinfo.getOwnername()!=null && !"".equals(companyinfo.getOwnername())){        
                sql+=" and ownername like '%"+companyinfo.getOwnername()+"%' ";        
            } 
            if (companyinfo.getOwnertel()!=null && !"".equals(companyinfo.getOwnertel())){        
                sql+=" and ownertel like '%"+companyinfo.getOwnertel()+"%' ";        
            } 
            if (companyinfo.getCompinfo()!=null && !"".equals(companyinfo.getCompinfo())){        
                sql+=" and compinfo like '%"+companyinfo.getCompinfo()+"%' ";        
            } 
            List<Companyinfo> list = dao.freeFind(sql);        
            return list;        
    }


}