package com.qhit.baseRole.pojo;


import com.qhit.baseRoleFunction.pojo.BaseRoleFunction;
import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.baseUserRole.pojo.BaseUserRole;
import com.sun.org.glassfish.gmbal.Description;

import java.util.Objects;

/**
* Created by GeneratorCode on 2018/11/29
*/

public class BaseRole {

    private Integer rid;    //角色ID
    private String rname;    //角色名称
    @Description("bean")
    private BaseUserRole baseUserRole;

    @Description("bean")
    private BaseRoleFunction baseRoleFunction;

    @Description("bean")
    private BaseUser baseUser;

    public BaseUserRole getBaseUserRole() {
        return baseUserRole;
    }

    public void setBaseUserRole(BaseUserRole baseUserRole) {
        this.baseUserRole = baseUserRole;
    }

    public BaseUser getBaseUser() {
        return baseUser;
    }

    public void setBaseUser(BaseUser baseUser) {
        this.baseUser = baseUser;
    }

    public BaseRoleFunction getBaseRoleFunction() {
        return baseRoleFunction;
    }

    public void setBaseRoleFunction(BaseRoleFunction baseRoleFunction) {
        this.baseRoleFunction = baseRoleFunction;
    }

    public Integer getRid() {
        return rid;
    }
 
    public void setRid(Integer rid) { 
        this.rid = rid;
    }
 
    public String getRname() { 
        return rname;
    }
 
    public void setRname(String rname) { 
        this.rname = rname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseRole baseRole = (BaseRole) o;
        return Objects.equals(rid, baseRole.rid) &&
                Objects.equals(rname, baseRole.rname) &&
                Objects.equals(baseUserRole, baseRole.baseUserRole) &&
                Objects.equals(baseRoleFunction, baseRole.baseRoleFunction) &&
                Objects.equals(baseUser, baseRole.baseUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rid, rname, baseUserRole, baseRoleFunction, baseUser);
    }
}