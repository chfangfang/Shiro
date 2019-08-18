package com.chxf.user.service;

import com.chxf.user.model.SysRole;

import java.util.List;

public interface IRoleService {

    public List<SysRole> selectRoleList();

    public Integer insertRole(SysRole role);

    public Integer deleteRoleById(String id);

    public SysRole selectRoleById(String id);

    public Integer updateRoleById(SysRole role);

    public String selectRoleNameById(String id);

}
