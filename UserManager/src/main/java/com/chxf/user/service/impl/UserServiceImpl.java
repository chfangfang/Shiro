package com.chxf.user.service.impl;

import com.chxf.user.mapper.UserMappper;
import com.chxf.user.model.SysRole;
import com.chxf.user.model.SysUser;
import com.chxf.user.model.SysUserVO;
import com.chxf.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMappper userMappper;

    @Override
    public List<SysUser> selectAllUser() {
        return userMappper.selectAllUser();
    }

    @Override
    public Integer insertUser(SysUser user) {
        return userMappper.insertUser(user);
    }

    @Override
    public SysUserVO selectUserById(String id) {
        return userMappper.selectUserById(id);
    }

    @Override
    public Integer updateUser(SysUserVO user) {
        return userMappper.updateUser(user);
    }

    @Override
    public Integer deleteUserById(String id) {
        return userMappper.deleteUserById(id);
    }

    @Override
    public String selectUserNameById(String id) {
        return userMappper.selectUserNameById(id);
    }

    @Override
    public SysUser selectUserByName(String username) {
        return userMappper.selectUserByName(username);
    }

    @Override
    public SysRole selectRoleName(String id) {
        return userMappper.selectRoleName(id);
    }
}
