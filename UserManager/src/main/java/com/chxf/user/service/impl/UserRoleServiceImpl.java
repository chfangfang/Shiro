package com.chxf.user.service.impl;

import com.chxf.user.mapper.UserRoleMapper;
import com.chxf.user.model.SysUserRole;
import com.chxf.user.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements IUserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public Integer insertInfo(SysUserRole userRole) {
        return userRoleMapper.insertUserLore(userRole);
    }

    @Override
    public SysUserRole selectUserRoleById(String userid) {
        return userRoleMapper.selectUserRoleById(userid);
    }

    @Override
    public Integer updateUserLore(SysUserRole userRole) {
        return userRoleMapper.updateUserLore(userRole);
    }

}
