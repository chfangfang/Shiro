package com.chxf.user.service.impl;

import com.chxf.user.mapper.RolePermMapper;
import com.chxf.user.model.SysRolePermission;
import com.chxf.user.service.IRolePermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolePermServiceImpl implements IRolePermService {

    @Autowired
    private RolePermMapper rolePermMapper;

    @Override
    public Integer insertInfo(SysRolePermission rolePermission) {
        return rolePermMapper.insertLorePerm(rolePermission);
    }

    @Override
    public Integer updateLorePerm(SysRolePermission rolePermission) {
        return rolePermMapper.updateLorePerm(rolePermission);
    }

    @Override
    public Integer deleteLorePerm(SysRolePermission rolePermission) {
        return rolePermMapper.deleteLorePerm(rolePermission);
    }
}
