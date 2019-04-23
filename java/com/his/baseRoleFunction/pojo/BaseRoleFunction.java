package com.qhit.baseRoleFunction.pojo;


import com.qhit.baseFunction.pojo.BaseFunction;
import com.sun.org.glassfish.gmbal.Description;

/**
* Created by GeneratorCode on 2018/11/29
*/

public class BaseRoleFunction {

    private Integer rmid;    //主键
    private Integer rid;    //角色id
    private Integer fid;    //功能id

    @Description("bean")
    private BaseFunction baseFunction;

    public BaseFunction getBaseFunction() {
        return baseFunction;
    }

    public void setBaseFunction(BaseFunction baseFunction) {
        this.baseFunction = baseFunction;
    }

    public Integer getRmid() {
        return rmid;
    }
 
    public void setRmid(Integer rmid) { 
        this.rmid = rmid;
    }
 
    public Integer getRid() { 
        return rid;
    }
 
    public void setRid(Integer rid) { 
        this.rid = rid;
    }
 
    public Integer getFid() { 
        return fid;
    }
 
    public void setFid(Integer fid) { 
        this.fid = fid;
    }

    @Override
    public String toString() {
        return "BaseRoleFunction{" +
                "rmid=" + rmid +
                ", rid=" + rid +
                ", fid=" + fid +
                ", baseFunction=" + baseFunction +
                '}';
    }
}