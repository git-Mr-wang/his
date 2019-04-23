package com.qhit.telvisit.pojo;


/**
* Created by GeneratorCode on 2018/12/24
*/

public class Telvisit {

    private Integer tvid;    //回访编号
    private String telname;    //回访人姓名
    private String teltime;    //回访时间
    private String visitreason;    //回访分类
    private String visitreturn;    //回访结果
    private String visittype;    //回访方式
    private Integer cid;    //所属公司编号

    public Integer getTvid() { 
        return tvid;
    }
 
    public void setTvid(Integer tvid) { 
        this.tvid = tvid;
    }
 
    public String getTelname() { 
        return telname;
    }
 
    public void setTelname(String telname) { 
        this.telname = telname;
    }
 
    public String getTeltime() { 
        return teltime;
    }
 
    public void setTeltime(String teltime) { 
        this.teltime = teltime;
    }
 
    public String getVisitreason() { 
        return visitreason;
    }
 
    public void setVisitreason(String visitreason) { 
        this.visitreason = visitreason;
    }
 
    public String getVisitreturn() { 
        return visitreturn;
    }
 
    public void setVisitreturn(String visitreturn) { 
        this.visitreturn = visitreturn;
    }
 
    public String getVisittype() { 
        return visittype;
    }
 
    public void setVisittype(String visittype) { 
        this.visittype = visittype;
    }
 
    public Integer getCid() { 
        return cid;
    }
 
    public void setCid(Integer cid) { 
        this.cid = cid;
    }
 

 }