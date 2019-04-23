package com.qhit.medicineStockinfo.pojo;


/**
* Created by GeneratorCode on 2018/12/11
*/

public class MedicineStockinfo {

    private Integer stockinfoId;    //主键
    private Integer medicinecodeId;    //药品
    private Integer amt;    //库存数量
    private Double unitprc;    //库存单价
    private Double saleunitprc;    //销售单价(库存单价*1.5)
    private Double zje;    //库存总金额(库存单价*数量)

    public Integer getStockinfoId() { 
        return stockinfoId;
    }
 
    public void setStockinfoId(Integer stockinfoId) { 
        this.stockinfoId = stockinfoId;
    }
 
    public Integer getMedicinecodeId() { 
        return medicinecodeId;
    }
 
    public void setMedicinecodeId(Integer medicinecodeId) { 
        this.medicinecodeId = medicinecodeId;
    }
 
    public Integer getAmt() { 
        return amt;
    }
 
    public void setAmt(Integer amt) { 
        this.amt = amt;
    }
 
    public Double getUnitprc() { 
        return unitprc;
    }
 
    public void setUnitprc(Double unitprc) { 
        this.unitprc = unitprc;
    }
 
    public Double getSaleunitprc() { 
        return saleunitprc;
    }
 
    public void setSaleunitprc(Double saleunitprc) { 
        this.saleunitprc = saleunitprc;
    }
 
    public Double getZje() { 
        return zje;
    }
 
    public void setZje(Double zje) { 
        this.zje = zje;
    }
 

 }