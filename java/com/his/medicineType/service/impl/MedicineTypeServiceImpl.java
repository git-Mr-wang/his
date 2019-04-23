package com.qhit.medicineType.service.impl;

import com.qhit.medicineType.service.IMedicineTypeService;
import java.util.List;
import com.qhit.medicineType.dao.IMedicineTypeDao;
import com.qhit.medicineType.dao.impl.MedicineTypeDaoImpl;
import com.qhit.medicineType.pojo.MedicineType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* Created by GeneratorCode on 2018/12/03
*/
public class MedicineTypeServiceImpl  implements IMedicineTypeService {
    IMedicineTypeDao dao=new MedicineTypeDaoImpl();

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
        MedicineType medicineType = findById(id); 
        return dao.delete(medicineType); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public MedicineType findById(Object id) { 
        List<MedicineType> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public boolean freeUpdate(String sql) {
        return dao.freeUpdate(sql);
    }


    @Override 
    public List<MedicineType> search(MedicineType medicineType) {
            String sql = "select * from medicine_type where 1=1 "; 
            if (medicineType.getTypeName()!=null && !"".equals(medicineType.getTypeName())){        
                sql+=" and type_name like '%"+medicineType.getTypeName()+"%' ";        
            } 
            if (medicineType.getRemark()!=null && !"".equals(medicineType.getRemark())){        
                sql+=" and remark like '%"+medicineType.getRemark()+"%' ";        
            } 
            List<MedicineType> list = dao.freeFind(sql);        
            return list;        
    }


}