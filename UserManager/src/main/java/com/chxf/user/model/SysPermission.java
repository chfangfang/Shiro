package com.chxf.user.model;

public class SysPermission {

    private String id;

    private String permname;

    private String permtype;

    private String permurl;

    private String permcode;

    private String parentid;

    private String permdesc;

    private String createtime;

    private String islocked;

    public SysPermission() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermname() {
        return permname;
    }

    public void setPermname(String permname) {
        this.permname = permname;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getPermtype() {
        return permtype;
    }

    public void setPermtype(String permtype) {
        this.permtype = permtype;
    }

    public String getPermurl() {
        return permurl;
    }

    public void setPermurl(String permurl) {
        this.permurl = permurl;
    }

    public String getPermcode() {
        return permcode;
    }

    public void setPermcode(String permcode) {
        this.permcode = permcode;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getPermdesc() {
        return permdesc;
    }

    public void setPermdesc(String permdesc) {
        this.permdesc = permdesc;
    }

    public String getIslocked() {
        return islocked;
    }

    public void setIslocked(String islocked) {
        this.islocked = islocked;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "id='" + id + '\'' +
                ", permname='" + permname + '\'' +
                ", permtype='" + permtype + '\'' +
                ", permurl='" + permurl + '\'' +
                ", permcode='" + permcode + '\'' +
                ", parentid='" + parentid + '\'' +
                ", permdesc='" + permdesc + '\'' +
                ", createtime='" + createtime + '\'' +
                ", islocked='" + islocked + '\'' +
                '}';
    }

}
