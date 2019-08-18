package com.chxf.user.service;

import com.chxf.user.model.SysRolePermission;
import com.chxf.user.model.SysUserRole;

public interface IRolePermService {

    public Integer insertInfo(SysRolePermission rolePermission);

    public Integer updateLorePerm(SysRolePermission rolePermission);

    public Integer deleteLorePerm(SysRolePermission rolePermission);

}
