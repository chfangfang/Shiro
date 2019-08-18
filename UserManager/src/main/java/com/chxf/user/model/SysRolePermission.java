package com.chxf.user.model;

public class SysRolePermission {

    private String id;

    private String roleid;

    private String permid;

    public SysRolePermission() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getPermid() {
        return permid;
    }

    public void setPermid(String permid) {
        this.permid = permid;
    }

    @Override
    public String toString() {
        return "SysRolePermission{" +
                "id='" + id + '\'' +
                ", roleid='" + roleid + '\'' +
                ", permid='" + permid + '\'' +
                '}';
    }
}

