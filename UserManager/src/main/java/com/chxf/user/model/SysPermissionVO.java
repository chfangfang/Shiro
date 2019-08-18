package com.chxf.user.model;

public class SysPermissionVO {

    private String id;

    private String permname;

    private String permurl;

    public SysPermissionVO() {
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

    public String getPermurl() {
        return permurl;
    }

    public void setPermurl(String permurl) {
        this.permurl = permurl;
    }

    @Override
    public String toString() {
        return "SysPermissionVO{" +
                "id='" + id + '\'' +
                ", permname='" + permname + '\'' +
                ", permurl='" + permurl + '\'' +
                '}';
    }
}
