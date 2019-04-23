package com.qhit.baseDept.pojo;


/**
* Created by GeneratorCode on 2018/12/27
*/

public class BaseDept {

    private Integer deptId;    //主键
    private String deptName;    //部门名称

    public Integer getDeptId() { 
        return deptId;
    }
 
    public void setDeptId(Integer deptId) { 
        this.deptId = deptId;
    }
 
    public String getDeptName() { 
        return deptName;
    }
 
    public void setDeptName(String deptName) { 
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "BaseDept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}