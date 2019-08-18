package com.chxf.user.service.impl;

import com.chxf.user.mapper.PermissionMapper;
import com.chxf.user.model.SysPermission;
import com.chxf.user.model.SysPermissionVO;
import com.chxf.user.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Integer insertPermission(SysPermission permission) {
        return permissionMapper.insertPermission(permission);
    }

    @Override
    public List<SysPermission> selectAllPermission() {
        return permissionMapper.selectAllPermission();
    }

    @Override
    public List<SysPermissionVO> selectPermissionName(String id) {
        return permissionMapper.selectPermissionName(id);
    }

    @Override
    public List<SysPermissionVO> selectOldPermissionById(String id) {
        return permissionMapper.selectOldPermissionById(id);
    }

    @Override
    public Integer deletePermissionById(String id) {
        return permissionMapper.deletePermissionById(id);
    }

    @Override
    public SysPermission selectPermissionById(String id) {
        return permissionMapper.selectPermissionById(id);
    }

    @Override
    public Integer updatePermissionById(SysPermission permission) {
        return permissionMapper.updatePermissionById(permission);
    }

    @Override
    public List<SysPermission> findMenuByUserId(String id) {
        return permissionMapper.findMenuByUserId(id);
    }

    @Override
    public List<SysPermission> findPermByUserId(String id) {
        return permissionMapper.findPermissionByUserId(id);
    }
}
