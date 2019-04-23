package com.qhit.inPatient.pojo;


/**
* Created by GeneratorCode on 2019/01/15
*/

public class InPatient {

    private Integer patientId;    //主键
    private String patientName;    //病人姓名
    private String sex;    //性别
    private String birth;    //出生日期
    private String bedNum;    //床号
    private Double amount;    //消费金额
    private Integer status;    //1:在院2:出院

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
 
    public String getSex() { 
        return sex;
    }
 
    public void setSex(String sex) { 
        this.sex = sex;
    }
 
    public String getBirth() { 
        return birth;
    }
 
    public void setBirth(String birth) { 
        this.birth = birth;
    }
 
    public String getBedNum() { 
        return bedNum;
    }
 
    public void setBedNum(String bedNum) { 
        this.bedNum = bedNum;
    }
 
    public Double getAmount() { 
        return amount;
    }
 
    public void setAmount(Double amount) { 
        this.amount = amount;
    }
 
    public Integer getStatus() { 
        return status;
    }
 
    public void setStatus(Integer status) { 
        this.status = status;
    }
 

 }