package com.qhit.basePatientInfo.pojo;


/**
* Created by GeneratorCode on 2018/12/26
*/

public class BasePatientInfo {

    private Integer patientId;    //主键
    private String patientName;    //病人姓名
    private String birth;    //出生日期
    private String sex;    //性别
    private String address;    //家庭住址
    private String phonenum;    //电话号码
    private String personid;    //身份证号

    public Integer getPatientId() { 
        return patientId;
    }
 
    public void setPatientId(Integer patientId) { 
        this.patientId = patientId;
    }
 
    public String getPatientName() { 
        return patientName;
    }
 
    public void setPatientName(String patientName) { 
        this.patientName = patientName;
    }
 
    public String getBirth() { 
        return birth;
    }
 
    public void setBirth(String birth) { 
        this.birth = birth;
    }
 
    public String getSex() { 
        return sex;
    }
 
    public void setSex(String sex) { 
        this.sex = sex;
    }
 
    public String getAddress() { 
        return address;
    }
 
    public void setAddress(String address) { 
        this.address = address;
    }
 
    public String getPhonenum() { 
        return phonenum;
    }
 
    public void setPhonenum(String phonenum) { 
        this.phonenum = phonenum;
    }
 
    public String getPersonid() { 
        return personid;
    }
 
    public void setPersonid(String personid) { 
        this.personid = personid;
    }

    @Override
    public String toString() {
        return "BasePatientInfo{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", birth='" + birth + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", phonenum='" + phonenum + '\'' +
                ", personid='" + personid + '\'' +
                '}';
    }
}