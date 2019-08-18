package com.chxf.user.controller;

import com.chxf.user.model.SysPermissionVO;
import com.chxf.user.model.SysRole;
import com.chxf.user.service.IPermissionService;
import com.chxf.user.service.IRoleService;
import com.chxf.user.util.BaseUtil;
import com.chxf.user.util.DateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("rolelist")
    @RequiresPermissions("role:select")
    public String roleList(Model model){
        List<SysRole> rolelist = roleService.selectRoleList();
        model.addAttribute("rolelist",rolelist);
        return "rolelist";
    }

    @RequestMapping("roleadd")
    @RequiresPermissions("role:insert")
    public String roleadd(){
        return "roleadd";
    }

    @RequestMapping("doroleadd")
    public String doadd() {

        SysRole role = null;
        try {
            role = (SysRole) BaseUtil.toBean(SysRole.class,request);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String uuid = BaseUtil.gitUuid();

        role.setId(uuid);
        role.setCreatetime(DateUtil.toString(new Date(),DateUtil.YYYY_MM_DD_HH_MM));

        System.out.println(">>>>>"+role);
        roleService.insertRole(role);
        return "redirect:/role/rolelist.do";
    }

    @RequestMapping("roleupdate")
    @RequiresPermissions("role:update")
    public String roleupdate(Model model){
        String uuid = request.getParameter("id");
        SysRole role = roleService.selectRoleById(uuid);
        model.addAttribute("role",role);
        return "roleupdate";
    }

    @RequestMapping("doroleupdate")
    public String doRoleUpdate(){
        SysRole role = null;
        try {
            role = (SysRole) BaseUtil.toBean(SysRole.class,request);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(role);

        roleService.updateRoleById(role);
        return "redirect:/role/rolelist.do";
    }
    @RequestMapping("roledelete")
    @RequiresPermissions("role:delete")
    public String roledelete(){
        String uuid = request.getParameter("id");

        roleService.deleteRoleById(uuid);

        return "redirect:/role/rolelist.do";
    }

    @RequestMapping("rolepermission")
    @RequiresPermissions("role:roleperm")
    public String rolePermission(Model model){
        String id = request.getParameter("id");
        String rolename = roleService.selectRoleNameById(id);
        //查询所有已经添加了的
        List<SysPermissionVO> oldpermlist = permissionService.selectOldPermissionById(id);

        //查询权限的id以及权限名称
        List<SysPermissionVO> permlist = permissionService.selectPermissionName(id);

        model.addAttribute("id",id);
        model.addAttribute("rolename",rolename);
        model.addAttribute("permlist",permlist);
        model.addAttribute("oldpermlist",oldpermlist);
        return "rolepermission";
    }
}
