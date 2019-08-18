package com.chxf.user.model;

public class SysRole {
    private String id;

    private String rolename;

    private String islocked;

    private String createtime;

    private String roledesc;

    public SysRole() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getIslocked() {
        return islocked;
    }

    public void setIslocked(String islocked) {
        this.islocked = islocked;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id='" + id + '\'' +
                ", rolename='" + rolename + '\'' +
                ", islocked='" + islocked + '\'' +
                ", createtime='" + createtime + '\'' +
                ", roledesc='" + roledesc + '\'' +
                '}';
    }
}
