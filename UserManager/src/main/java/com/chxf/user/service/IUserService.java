package com.chxf.user.service;

import com.chxf.user.model.SysRole;
import com.chxf.user.model.SysUser;
import com.chxf.user.model.SysUserVO;

import java.util.List;

public interface IUserService {

    public List<SysUser> selectAllUser();

    public Integer insertUser(SysUser user);

    public SysUserVO selectUserById(String id);

    public Integer updateUser(SysUserVO user);

    public Integer deleteUserById(String id);

    public String selectUserNameById(String id);

    public SysUser selectUserByName(String username);

    public SysRole selectRoleName(String id);

}
