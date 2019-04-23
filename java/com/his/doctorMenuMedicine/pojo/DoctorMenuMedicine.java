package com.qhit.doctorMenuMedicine.pojo;


/**
* Created by GeneratorCode on 2018/12/19
*/

public class DoctorMenuMedicine {

    private Integer mdId;    //主键
    private Integer menuId;    //套餐
    private Integer codeId;    //药品
    private Integer amt;    //数量

    public Integer getMdId() { 
        return mdId;
    }
 
    public void setMdId(Integer mdId) { 
        this.mdId = mdId;
    }
 
    public Integer getMenuId() { 
        return menuId;
    }
 
    public void setMenuId(Integer menuId) { 
        this.menuId = menuId;
    }
 
    public Integer getCodeId() { 
        return codeId;
    }
 
    public void setCodeId(Integer codeId) { 
        this.codeId = codeId;
    }
 
    public Integer getAmt() { 
        return amt;
    }
 
    public void setAmt(Integer amt) { 
        this.amt = amt;
    }

    @Override
    public String toString() {
        return "DoctorMenuMedicine{" +
                "mdId=" + mdId +
                ", menuId=" + menuId +
                ", codeId=" + codeId +
                ", amt=" + amt +
                '}';
    }
}