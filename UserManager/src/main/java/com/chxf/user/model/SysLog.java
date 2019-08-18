package com.chxf.user.model;

public class SysLog {
    private long id;

    private String username;

    private String logname;

    private String addressip;

    private String permcode;

    private String methed;

    private String logtime;

    public SysLog() {
    }

    public SysLog(String username, String logname, String addressip, String permcode, String methed, String logtime) {
        this.username = username;
        this.logname = logname;
        this.addressip = addressip;
        this.permcode = permcode;
        this.methed = methed;
        this.logtime = logtime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLogname() {
        return logname;
    }

    public void setLogname(String logname) {
        this.logname = logname;
    }

    public String getAddressip() {
        return addressip;
    }

    public void setAddressip(String addressip) {
        this.addressip = addressip;
    }

    public String getPermcode() {
        return permcode;
    }

    public void setPermcode(String permcode) {
        this.permcode = permcode;
    }

    public String getRequest() {
        return methed;
    }

    public void setRequest(String methed) {
        this.methed = methed;
    }

    public String getLogtime() {
        return logtime;
    }

    public void setLogtime(String logtime) {
        this.logtime = logtime;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", logname='" + logname + '\'' +
                ", addressip='" + addressip + '\'' +
                ", permcode='" + permcode + '\'' +
                ", request='" + methed + '\'' +
                ", logtime='" + logtime + '\'' +
                '}';
    }

}
