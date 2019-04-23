package com.qhit.companyinfo.pojo;


/**
* Created by GeneratorCode on 2018/12/04
*/

public class Companyinfo {

    private Integer cid;    //公司编号
    private String compname;    //公司名称
    private String ownername;    //法人姓名
    private String ownertel;    //法人电话
    private String compinfo;    //公司简介

    public Integer getCid() { 
        return cid;
    }
 
    public void setCid(Integer cid) { 
        this.cid = cid;
    }
 
    public String getCompname() { 
        return compname;
    }
 
    public void setCompname(String compname) { 
        this.compname = compname;
    }
 
    public String getOwnername() { 
        return ownername;
    }
 
    public void setOwnername(String ownername) { 
        this.ownername = ownername;
    }
 
    public String getOwnertel() { 
        return ownertel;
    }
 
    public void setOwnertel(String ownertel) { 
        this.ownertel = ownertel;
    }
 
    public String getCompinfo() { 
        return compinfo;
    }
 
    public void setCompinfo(String compinfo) { 
        this.compinfo = compinfo;
    }
 

 }