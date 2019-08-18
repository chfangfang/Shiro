package com.chxf.user.model;

public class SysUserRole {
    private String id;

    private String userid;

    private String roleid;

    public SysUserRole() {
    }

    public SysUserRole(String id, String userid, String roleid) {
        this.id = id;
        this.userid = userid;
        this.roleid = roleid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "UserRoleMapper{" +
                "id='" + id + '\'' +
                ", userid='" + userid + '\'' +
                ", roleid='" + roleid + '\'' +
                '}';
    }
}
