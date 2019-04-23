package com.qhit.medicineInstock.pojo;


/**
* Created by GeneratorCode on 2018/12/11
*/

public class MedicineInstock {

    private Integer instockId;    //主键
    private String invno;    //发票号
    private Integer medicineCodeid;    //药品
    private Integer inamt;    //入库数量
    private Double unitprc;    //入库单价
    private Double zje;    //入库总金额
    private Integer instockUserid;    //入库人
    private String instockDate;    //入库日期
    private Integer manCode;    //供应商

    public Integer getInstockId() { 
        return instockId;
    }
 
    public void setInstockId(Integer instockId) { 
        this.instockId = instockId;
    }
 
    public String getInvno() { 
        return invno;
    }
 
    public void setInvno(String invno) { 
        this.invno = invno;
    }
 
    public Integer getMedicineCodeid() { 
        return medicineCodeid;
    }
 
    public void setMedicineCodeid(Integer medicineCodeid) { 
        this.medicineCodeid = medicineCodeid;
    }
 
    public Integer getInamt() { 
        return inamt;
    }
 
    public void setInamt(Integer inamt) { 
        this.inamt = inamt;
    }
 
    public Double getUnitprc() { 
        return unitprc;
    }
 
    public void setUnitprc(Double unitprc) { 
        this.unitprc = unitprc;
    }
 
    public Double getZje() { 
        return zje;
    }
 
    public void setZje(Double zje) { 
        this.zje = zje;
    }
 
    public Integer getInstockUserid() { 
        return instockUserid;
    }
 
    public void setInstockUserid(Integer instockUserid) { 
        this.instockUserid = instockUserid;
    }
 
    public String getInstockDate() { 
        return instockDate;
    }
 
    public void setInstockDate(String instockDate) { 
        this.instockDate = instockDate;
    }
 
    public Integer getManCode() { 
        return manCode;
    }
 
    public void setManCode(Integer manCode) { 
        this.manCode = manCode;
    }
 

 }