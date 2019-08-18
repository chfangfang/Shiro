package com.chxf.user.mapper;

import com.chxf.user.model.SysRolePermission;
import com.chxf.user.model.SysUserRole;

public interface RolePermMapper {

    public Integer insertLorePerm(SysRolePermission rolePermission);

    public Integer updateLorePerm(SysRolePermission rolePermission);

    public Integer deleteLorePerm(SysRolePermission rolePermission);
}
