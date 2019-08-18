package com.chxf.user.mapper;

import com.chxf.user.model.SysUserRole;

public interface UserRoleMapper {

    public Integer insertUserLore(SysUserRole userRole);

    public Integer updateUserLore(SysUserRole userRole);

    public SysUserRole selectUserRoleById(String userid);
}
