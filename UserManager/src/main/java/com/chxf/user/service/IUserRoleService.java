package com.chxf.user.service;

import com.chxf.user.model.SysUserRole;
import org.springframework.stereotype.Service;

public interface IUserRoleService {

    public Integer insertInfo(SysUserRole userRole);

    public SysUserRole selectUserRoleById(String userid);

    public Integer updateUserLore(SysUserRole userRole);
}
