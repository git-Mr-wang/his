package com.qhit.patientRegisterRecord.pojo;


import com.qhit.baseDept.pojo.BaseDept;
import com.qhit.basePatientInfo.pojo.BasePatientInfo;
import com.qhit.baseUser.pojo.BaseUser;
import com.sun.org.glassfish.gmbal.Description;

/**
* Created by GeneratorCode on 2018/12/26
*/

public class PatientRegisterRecord {

    private Integer registerId;    //主键
    private Integer patientId;    //病人
    private Integer deptId;    //部门
    private String registerDate;    //挂号时间
    private Integer recordUser;    //挂号人
    private Integer doctorId;    //医生
    private Integer status;    //状态

    @Description("bean")
    private BaseUser baseUser;
    @Description("bean")
    private BaseUser baseUser2;
    @Description("bean")
    private BaseDept baseDept;
    @Description("bean")
    private BasePatientInfo basePatientInfo;

    public BaseUser getBaseUser2() {
        return baseUser2;
    }

    public void setBaseUser2(BaseUser baseUser2) {
        this.baseUser2 = baseUser2;
    }

    public BaseUser getBaseUser() {
        return baseUser;
    }

    public void setBaseUser(BaseUser baseUser) {
        this.baseUser = baseUser;
    }

    public BaseDept getBaseDept() {
        return baseDept;
    }

    public void setBaseDept(BaseDept baseDept) {
        this.baseDept = baseDept;
    }

    public BasePatientInfo getBasePatientInfo() {
        return basePatientInfo;
    }

    public void setBasePatientInfo(BasePatientInfo basePatientInfo) {
        this.basePatientInfo = basePatientInfo;
    }

    public Integer getRegisterId() {
        return registerId;
    }
 
    public void setRegisterId(Integer registerId) { 
        this.registerId = registerId;
    }
 
    public Integer getPatientId() { 
        return patientId;
    }
 
    public void setPatientId(Integer patientId) { 
        this.patientId = patientId;
    }
 
    public Integer getDeptId() { 
        return deptId;
    }
 
    public void setDeptId(Integer deptId) { 
        this.deptId = deptId;
    }
 
    public String getRegisterDate() { 
        return registerDate;
    }
 
    public void setRegisterDate(String registerDate) { 
        this.registerDate = registerDate;
    }
 
    public Integer getRecordUser() { 
        return recordUser;
    }
 
    public void setRecordUser(Integer recordUser) { 
        this.recordUser = recordUser;
    }
 
    public Integer getDoctorId() { 
        return doctorId;
    }
 
    public void setDoctorId(Integer doctorId) { 
        this.doctorId = doctorId;
    }
 
    public Integer getStatus() { 
        return status;
    }
 
    public void setStatus(Integer status) { 
        this.status = status;
    }

    @Override
    public String toString() {
        return "PatientRegisterRecord{" +
                "registerId=" + registerId +
                ", patientId=" + patientId +
                ", deptId=" + deptId +
                ", registerDate='" + registerDate + '\'' +
                ", recordUser=" + recordUser +
                ", doctorId=" + doctorId +
                ", status=" + status +
                ", baseUser=" + baseUser +
                ", baseUser2=" + baseUser2 +
                ", baseDept=" + baseDept +
                ", basePatientInfo=" + basePatientInfo +
                '}';
    }
}