package com.chxf.user.service.impl;

import com.chxf.user.mapper.RoleMapper;
import com.chxf.user.model.SysRole;
import com.chxf.user.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<SysRole> selectRoleList() {
        return roleMapper.selectRoleList();
    }

    @Override
    public Integer insertRole(SysRole role) {
        return roleMapper.insertRole(role);
    }

    @Override
    public Integer deleteRoleById(String id) {
        return roleMapper.deleteRoleById(id);
    }

    @Override
    public SysRole selectRoleById(String id) {
        return roleMapper.selectRoleById(id);
    }

    @Override
    public Integer updateRoleById(SysRole role) {
        return roleMapper.updateRoleById(role);
    }

    @Override
    public String selectRoleNameById(String id) {
        return roleMapper.selectRoleNameById(id);
    }


}
