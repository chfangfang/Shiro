package com.chxf.user.controller;

import com.chxf.user.mapper.UserRoleMapper;
import com.chxf.user.model.SysLog;
import com.chxf.user.model.SysUserRole;
import com.chxf.user.realm.MyShiroSession;
import com.chxf.user.service.ILogService;
import com.chxf.user.service.IUserRoleService;
import com.chxf.user.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("user")
public class UserRoleController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ILogService logService;

    @Autowired
    private IUserRoleService userRoleService;

    @RequestMapping("useraddrole")
    public String useraddrole() throws UnsupportedEncodingException {
        SysUserRole userRole = (SysUserRole) BaseUtil.toBean(SysUserRole.class,request);
        System.out.println(userRole);
        //查询数据表中是否存在角色信息
        SysUserRole findUserRole = userRoleService.selectUserRoleById(userRole.getUserid());

        if(findUserRole != null){
            userRoleService.updateUserLore(userRole);
        }else{
            userRole.setId(BaseUtil.gitUuid());
            userRoleService.insertInfo(userRole);
        }

        //添加日志记录
        SysLog log = MyShiroSession.getActiveUser("设置角色",request,"userrole:insert","POST");
        logService.insertLog(log);

        return "redirect:/user/userlist.do";
    }

}
