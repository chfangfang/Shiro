package com.chxf.user.mapper;

import com.chxf.user.model.SysRole;

import java.util.List;

public interface RoleMapper {

    public List<SysRole> selectRoleList();

    public Integer insertRole(SysRole role);

    public SysRole selectRoleById(String id);

    public Integer deleteRoleById(String id);

    public Integer updateRoleById(SysRole role);

    public String selectRoleNameById(String id);

}
