package com.qhit.medicineCode.pojo;


import com.qhit.doctorMenu.pojo.DoctorMenu;
import com.qhit.doctorMenuMedicine.pojo.DoctorMenuMedicine;
import com.sun.org.glassfish.gmbal.Description;

/**
* Created by GeneratorCode on 2018/12/03
*/

public class MedicineCode {

    private Integer codeId;    //药品ID
    private String medicineName;    //药品名
    private String aliasName;    //别名名称
    private String specification;    //规格
    private String manCode;    //生产厂商ID
    private String manChnName;    //生产厂商名称
    private String typeName;    //药品分类名称(W 西药 C 中成药 G 中草药)
    private String typeCode;    //药品分类代码
    private String stockUnit;    //库存单位
    private String retailPrice;    //零售价
    private String stockPrice;    //库存平均价 (加权平均成本)
    private String drugNotesPatient;    //用药注意事项
    private String drugNote;    //药袋说明
    private String drugForm;    //药品外形说明

    @Description("bean")
    private DoctorMenuMedicine doctorMenuMedicine;

    public DoctorMenuMedicine getDoctorMenuMedicine() {
        return doctorMenuMedicine;
    }

    public void setDoctorMenuMedicine(DoctorMenuMedicine doctorMenuMedicine) {
        this.doctorMenuMedicine = doctorMenuMedicine;
    }

    public Integer getCodeId() {
        return codeId;
    }
 
    public void setCodeId(Integer codeId) { 
        this.codeId = codeId;
    }
 
    public String getMedicineName() { 
        return medicineName;
    }
 
    public void setMedicineName(String medicineName) { 
        this.medicineName = medicineName;
    }
 
    public String getAliasName() { 
        return aliasName;
    }
 
    public void setAliasName(String aliasName) { 
        this.aliasName = aliasName;
    }
 
    public String getSpecification() { 
        return specification;
    }
 
    public void setSpecification(String specification) { 
        this.specification = specification;
    }
 
    public String getManCode() { 
        return manCode;
    }
 
    public void setManCode(String manCode) { 
        this.manCode = manCode;
    }
 
    public String getManChnName() { 
        return manChnName;
    }
 
    public void setManChnName(String manChnName) { 
        this.manChnName = manChnName;
    }
 
    public String getTypeName() { 
        return typeName;
    }
 
    public void setTypeName(String typeName) { 
        this.typeName = typeName;
    }
 
    public String getTypeCode() { 
        return typeCode;
    }
 
    public void setTypeCode(String typeCode) { 
        this.typeCode = typeCode;
    }
 
    public String getStockUnit() { 
        return stockUnit;
    }
 
    public void setStockUnit(String stockUnit) { 
        this.stockUnit = stockUnit;
    }
 
    public String getRetailPrice() { 
        return retailPrice;
    }
 
    public void setRetailPrice(String retailPrice) { 
        this.retailPrice = retailPrice;
    }
 
    public String getStockPrice() { 
        return stockPrice;
    }
 
    public void setStockPrice(String stockPrice) { 
        this.stockPrice = stockPrice;
    }
 
    public String getDrugNotesPatient() { 
        return drugNotesPatient;
    }
 
    public void setDrugNotesPatient(String drugNotesPatient) { 
        this.drugNotesPatient = drugNotesPatient;
    }
 
    public String getDrugNote() { 
        return drugNote;
    }
 
    public void setDrugNote(String drugNote) { 
        this.drugNote = drugNote;
    }
 
    public String getDrugForm() { 
        return drugForm;
    }
 
    public void setDrugForm(String drugForm) { 
        this.drugForm = drugForm;
    }

    @Override
    public String toString() {
        return "MedicineCode{" +
                "codeId=" + codeId +
                ", medicineName='" + medicineName + '\'' +
                ", aliasName='" + aliasName + '\'' +
                ", specification='" + specification + '\'' +
                ", manCode='" + manCode + '\'' +
                ", manChnName='" + manChnName + '\'' +
                ", typeName='" + typeName + '\'' +
                ", typeCode='" + typeCode + '\'' +
                ", stockUnit='" + stockUnit + '\'' +
                ", retailPrice='" + retailPrice + '\'' +
                ", stockPrice='" + stockPrice + '\'' +
                ", drugNotesPatient='" + drugNotesPatient + '\'' +
                ", drugNote='" + drugNote + '\'' +
                ", drugForm='" + drugForm + '\'' +
                ", doctorMenuMedicine=" + doctorMenuMedicine +
                '}';
    }
}