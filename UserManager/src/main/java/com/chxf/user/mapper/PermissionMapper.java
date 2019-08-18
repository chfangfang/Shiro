package com.chxf.user.mapper;

import com.chxf.user.model.SysPermission;
import com.chxf.user.model.SysPermissionVO;

import java.util.List;

public interface PermissionMapper {

    public Integer insertPermission(SysPermission permission);

    public List<SysPermission> selectAllPermission();

    public List<SysPermissionVO> selectPermissionName(String id);

    public Integer deletePermissionById(String id);

    public SysPermission selectPermissionById(String id);

    //所有已经添加了的权限
    public List<SysPermissionVO> selectOldPermissionById(String id);

    public Integer updatePermissionById(SysPermission permission);

    //查询所有的菜单选项
    public List<SysPermission> findMenuByUserId(String id);

    public List<SysPermission> findPermissionByUserId(String id);
}
