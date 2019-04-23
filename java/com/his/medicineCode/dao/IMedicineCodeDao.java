package com.qhit.medicineCode.dao;

import org.springframework.stereotype.Repository;
import com.qhit.medicineCode.pojo.MedicineCode;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/26
*/

@Repository  
public interface IMedicineCodeDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    boolean freeUpdate(String sql);

    List findAll();

    List findById(Object id);


    List<MedicineCode> search(MedicineCode medicineCode);

    List findByMedicineName(Object medicineName);

    List findByAliasName(Object aliasName);

    List findBySpecification(Object specification);

    List findByManCode(Object manCode);

    List findByManChnName(Object manChnName);

    List findByTypeName(Object typeName);

    List findByTypeCode(Object typeCode);

    List findByStockUnit(Object stockUnit);

    List findByRetailPrice(Object retailPrice);

    List findByStockPrice(Object stockPrice);

    List findByDrugNotesPatient(Object drugNotesPatient);

    List findByDrugNote(Object drugNote);

    List findByDrugForm(Object drugForm);

    List<MedicineCode> notOwned(String menuId);

    List<MedicineCode> owned(String menuId);

}