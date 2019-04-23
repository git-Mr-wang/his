package com.qhit.baseFunction.pojo;


import com.qhit.baseModule.pojo.BaseModule;
import com.sun.org.glassfish.gmbal.Description;

/**
* Created by GeneratorCode on 2018/11/27
*/

public class BaseFunction {

    private Integer fid;    //功能ID
    private String fname;    //功能名称
    private Integer mid;    //模块ID
    private String url;    //url地址

    @Description("bean")
    private BaseModule baseModule;

    public BaseModule getBaseModule() {
        return baseModule;
    }

    public void setBaseModule(BaseModule baseModule) {
        this.baseModule = baseModule;
    }

    public Integer getFid() {
        return fid;
    }
 
    public void setFid(Integer fid) { 
        this.fid = fid;
    }
 
    public String getFname() { 
        return fname;
    }
 
    public void setFname(String fname) { 
        this.fname = fname;
    }
 
    public Integer getMid() { 
        return mid;
    }
 
    public void setMid(Integer mid) { 
        this.mid = mid;
    }
 
    public String getUrl() { 
        return url;
    }
 
    public void setUrl(String url) { 
        this.url = url;
    }

    @Override
    public String toString() {
        return "BaseFunction{" +
                "fid=" + fid +
                ", fname='" + fname + '\'' +
                ", mid=" + mid +
                ", url='" + url + '\'' +
                ", baseModule=" + baseModule +
                '}';
    }
}