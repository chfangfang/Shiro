package com.chxf.user.model;

import java.util.List;

public class ActiveUser {
    //用户id(主键)
    private String userid;
    //用户账号
    private String username;
    //用户菜单列表
    private List<SysPermission> menus;
    //用户权限列表
    private List<SysPermission> permissions;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<SysPermission> getMenus() {
        return menus;
    }

    public void setMenus(List<SysPermission> menus) {
        this.menus = menus;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

}
