package com.qhit.doctorMenuMedicine.service.impl;

import com.qhit.doctorMenuMedicine.service.IDoctorMenuMedicineService;
import java.util.List;
import com.qhit.doctorMenuMedicine.dao.IDoctorMenuMedicineDao;
import com.qhit.doctorMenuMedicine.dao.impl.DoctorMenuMedicineDaoImpl;
import com.qhit.doctorMenuMedicine.pojo.DoctorMenuMedicine;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* Created by GeneratorCode on 2018/12/19
*/
public class DoctorMenuMedicineServiceImpl  implements IDoctorMenuMedicineService {
    IDoctorMenuMedicineDao dao=new DoctorMenuMedicineDaoImpl();

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
        DoctorMenuMedicine doctorMenuMedicine = findById(id); 
        return dao.delete(doctorMenuMedicine); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public DoctorMenuMedicine findById(Object id) { 
        List<DoctorMenuMedicine> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public boolean freeUpdate(String sql) {
        return dao.freeUpdate(sql);
    }


    @Override 
    public List<DoctorMenuMedicine> search(DoctorMenuMedicine doctorMenuMedicine) {
            String sql = "select * from doctor_menu_medicine where 1=1 "; 
            if (doctorMenuMedicine.getMenuId()!=null && !"".equals(doctorMenuMedicine.getMenuId())){        
                sql+=" and menu_id like '%"+doctorMenuMedicine.getMenuId()+"%' ";        
            } 
            if (doctorMenuMedicine.getCodeId()!=null && !"".equals(doctorMenuMedicine.getCodeId())){        
                sql+=" and code_id like '%"+doctorMenuMedicine.getCodeId()+"%' ";        
            } 
            if (doctorMenuMedicine.getAmt()!=null && !"".equals(doctorMenuMedicine.getAmt())){        
                sql+=" and amt like '%"+doctorMenuMedicine.getAmt()+"%' ";        
            } 
            List<DoctorMenuMedicine> list = dao.freeFind(sql);        
            return list;        
    }

    @Override
    public boolean deleteMenuId(String menuId) {
        String sql="select * from doctor_menu_medicine WHERE menu_id="+menuId+";";
        List<DoctorMenuMedicine> list = null;
        List list1 = dao.freeFind(sql);
        if (list1!=null&&list1.size()>0){
            list=list1;
        }
        boolean delete=false;
        if (list!=null&&list.size()>0){
            for (int i=0;i<list.size();i++){
                delete = dao.delete(list.get(i));
                if (!delete){
                    delete=false;
                    break;
                }
            }
        }
        return delete;
    }


}