package com.qhit.baseManufacturer.pojo;


/**
* Created by GeneratorCode on 2018/12/03
*/

public class BaseManufacturer {

    private Integer manCode;    //生产厂商ID
    private String note;    //备注
    private String py1;    //拼音
    private String manChnName;    //生产厂商名称
    private String manEngDesc;    //英文名称
    private String manAbsName;    //生产厂商简称
    private String address;    //地址
    private String faxNo;    //传真号
    private String nationCode;    //国籍代码
    private String postCode;    //邮编编码
    private String telNo;    //电话
    private String website;    //网址
    private String email;    //电子邮箱
    private String stateCode;    //省/直辖市
    private String cityCode;    //县/市

    public Integer getManCode() { 
        return manCode;
    }
 
    public void setManCode(Integer manCode) { 
        this.manCode = manCode;
    }
 
    public String getNote() { 
        return note;
    }
 
    public void setNote(String note) { 
        this.note = note;
    }
 
    public String getPy1() { 
        return py1;
    }
 
    public void setPy1(String py1) { 
        this.py1 = py1;
    }
 
    public String getManChnName() { 
        return manChnName;
    }
 
    public void setManChnName(String manChnName) { 
        this.manChnName = manChnName;
    }
 
    public String getManEngDesc() { 
        return manEngDesc;
    }
 
    public void setManEngDesc(String manEngDesc) { 
        this.manEngDesc = manEngDesc;
    }
 
    public String getManAbsName() { 
        return manAbsName;
    }
 
    public void setManAbsName(String manAbsName) { 
        this.manAbsName = manAbsName;
    }
 
    public String getAddress() { 
        return address;
    }
 
    public void setAddress(String address) { 
        this.address = address;
    }
 
    public String getFaxNo() { 
        return faxNo;
    }
 
    public void setFaxNo(String faxNo) { 
        this.faxNo = faxNo;
    }
 
    public String getNationCode() { 
        return nationCode;
    }
 
    public void setNationCode(String nationCode) { 
        this.nationCode = nationCode;
    }
 
    public String getPostCode() { 
        return postCode;
    }
 
    public void setPostCode(String postCode) { 
        this.postCode = postCode;
    }
 
    public String getTelNo() { 
        return telNo;
    }
 
    public void setTelNo(String telNo) { 
        this.telNo = telNo;
    }
 
    public String getWebsite() { 
        return website;
    }
 
    public void setWebsite(String website) { 
        this.website = website;
    }
 
    public String getEmail() { 
        return email;
    }
 
    public void setEmail(String email) { 
        this.email = email;
    }
 
    public String getStateCode() { 
        return stateCode;
    }
 
    public void setStateCode(String stateCode) { 
        this.stateCode = stateCode;
    }
 
    public String getCityCode() { 
        return cityCode;
    }
 
    public void setCityCode(String cityCode) { 
        this.cityCode = cityCode;
    }

    @Override
    public String toString() {
        return "BaseManufacturer{" +
                "manCode=" + manCode +
                ", note='" + note + '\'' +
                ", py1='" + py1 + '\'' +
                ", manChnName='" + manChnName + '\'' +
                ", manEngDesc='" + manEngDesc + '\'' +
                ", manAbsName='" + manAbsName + '\'' +
                ", address='" + address + '\'' +
                ", faxNo='" + faxNo + '\'' +
                ", nationCode='" + nationCode + '\'' +
                ", postCode='" + postCode + '\'' +
                ", telNo='" + telNo + '\'' +
                ", website='" + website + '\'' +
                ", email='" + email + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                '}';
    }
}