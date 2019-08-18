package com.chxf.user.service;

import com.chxf.user.model.SysPermission;
import com.chxf.user.model.SysPermissionVO;

import java.util.List;

public interface IPermissionService {

    public Integer insertPermission(SysPermission permission);

    public List<SysPermission> selectAllPermission();

    public List<SysPermissionVO> selectPermissionName(String id);

    public List<SysPermissionVO> selectOldPermissionById(String id);

    public Integer deletePermissionById(String id);

    public SysPermission selectPermissionById(String id);

    public Integer updatePermissionById(SysPermission permission);

    public List<SysPermission> findMenuByUserId(String id);

    public List<SysPermission> findPermByUserId(String id);
}
