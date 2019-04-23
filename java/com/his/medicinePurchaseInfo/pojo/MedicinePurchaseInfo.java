package com.qhit.medicinePurchaseInfo.pojo;


import com.qhit.medicineCode.pojo.MedicineCode;
import com.sun.org.glassfish.gmbal.Description;

/**
* Created by GeneratorCode on 2018/12/04
*/

public class MedicinePurchaseInfo {

    private Integer pchId;    //采购编号
    private Integer medicineCodeid;    //药品
    private Integer manCode;    //供应商
    private Integer pchAmt;    //采购数量
    private Double pchPrice;    //采购单价
    private Double pchTotal;    //采购总价
    private Integer status;    //状态
    private Integer pchUserid;    //汇总人
    private String pchDate;    //汇总日期
    private Integer apprvUserid;    //审批人
    private String apprvDate;    //审批日期

    @Description("bean")
    private MedicineCode medicineCode;

    public MedicineCode getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(MedicineCode medicineCode) {
        this.medicineCode = medicineCode;
    }

    public Integer getPchId() {
        return pchId;
    }
 
    public void setPchId(Integer pchId) { 
        this.pchId = pchId;
    }
 
    public Integer getMedicineCodeid() { 
        return medicineCodeid;
    }
 
    public void setMedicineCodeid(Integer medicineCodeid) { 
        this.medicineCodeid = medicineCodeid;
    }
 
    public Integer getManCode() { 
        return manCode;
    }
 
    public void setManCode(Integer manCode) { 
        this.manCode = manCode;
    }
 
    public Integer getPchAmt() { 
        return pchAmt;
    }
 
    public void setPchAmt(Integer pchAmt) { 
        this.pchAmt = pchAmt;
    }
 
    public Double getPchPrice() { 
        return pchPrice;
    }
 
    public void setPchPrice(Double pchPrice) { 
        this.pchPrice = pchPrice;
    }
 
    public Double getPchTotal() { 
        return pchTotal;
    }
 
    public void setPchTotal(Double pchTotal) { 
        this.pchTotal = pchTotal;
    }
 
    public Integer getStatus() { 
        return status;
    }
 
    public void setStatus(Integer status) { 
        this.status = status;
    }
 
    public Integer getPchUserid() { 
        return pchUserid;
    }
 
    public void setPchUserid(Integer pchUserid) { 
        this.pchUserid = pchUserid;
    }
 
    public String getPchDate() { 
        return pchDate;
    }
 
    public void setPchDate(String pchDate) { 
        this.pchDate = pchDate;
    }
 
    public Integer getApprvUserid() { 
        return apprvUserid;
    }
 
    public void setApprvUserid(Integer apprvUserid) { 
        this.apprvUserid = apprvUserid;
    }
 
    public String getApprvDate() { 
        return apprvDate;
    }
 
    public void setApprvDate(String apprvDate) { 
        this.apprvDate = apprvDate;
    }

    @Override
    public String toString() {
        return "MedicinePurchaseInfo{" +
                "pchId=" + pchId +
                ", medicineCodeid=" + medicineCodeid +
                ", manCode=" + manCode +
                ", pchAmt=" + pchAmt +
                ", pchPrice=" + pchPrice +
                ", pchTotal=" + pchTotal +
                ", status=" + status +
                ", pchUserid=" + pchUserid +
                ", pchDate='" + pchDate + '\'' +
                ", apprvUserid=" + apprvUserid +
                ", apprvDate='" + apprvDate + '\'' +
                ", medicineCode=" + medicineCode +
                '}';
    }
}