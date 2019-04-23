package com.qhit.baseUserRole.pojo;

/**
* Created by GeneratorCode on 2018/11/29
*/

public class BaseUserRole {

    private Integer urid;    //主键
    private Integer uid;    //用户id
    private Integer rid;    //角色id

    public Integer getUrid() {
        return urid;
    }
 
    public void setUrid(Integer urid) { 
        this.urid = urid;
    }
 
    public Integer getUid() { 
        return uid;
    }
 
    public void setUid(Integer uid) { 
        this.uid = uid;
    }
 
    public Integer getRid() { 
        return rid;
    }
 
    public void setRid(Integer rid) { 
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "BaseUserRole{" +
                "urid=" + urid +
                ", uid=" + uid +
                ", rid=" + rid +
                '}';
    }
}