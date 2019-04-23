package com.qhit.medicineType.pojo;


/**
* Created by GeneratorCode on 2018/12/03
*/

public class MedicineType {

    private Integer typeId;    //生产厂商ID
    private String typeName;    //类别名称
    private String remark;    //备注

    public Integer getTypeId() { 
        return typeId;
    }
 
    public void setTypeId(Integer typeId) { 
        this.typeId = typeId;
    }
 
    public String getTypeName() { 
        return typeName;
    }
 
    public void setTypeName(String typeName) { 
        this.typeName = typeName;
    }
 
    public String getRemark() { 
        return remark;
    }
 
    public void setRemark(String remark) { 
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "MedicineType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}