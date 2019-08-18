package com.chxf.user.controller;

import com.chxf.user.model.SysPermission;
import com.chxf.user.service.IPermissionService;
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
@RequestMapping("perm")
public class PermController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("permissionlist")
    @RequiresPermissions("perm:select")
    public String premissionlist(Model model){
        List<SysPermission> permlist = permissionService.selectAllPermission();

        model.addAttribute("permlist",permlist);

        return "permissionlist";
    }

    @RequestMapping("permissionadd")
    @RequiresPermissions("perm:insert")
    public String permissionadd(){
        return "permissionadd";
    }

    @RequestMapping("dopermissionadd")
    public String dopermissionadd(){
        SysPermission permission = null;

        try {
            permission = (SysPermission) BaseUtil.toBean(SysPermission.class,request);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String uuid = BaseUtil.gitUuid();
        permission.setId(uuid);
        permission.setCreatetime(DateUtil.toString(new Date(),DateUtil.YYYY_MM_DD_HH_MM));

        System.out.println(permission.toString());

        permissionService.insertPermission(permission);


        return "redirect:/perm/permissionlist.do"  ;
    }

    @RequestMapping("permissiondelete")
    @RequiresPermissions("perm:delete")
    public String deletePermissionById(){
        String uuid = request.getParameter("id");

        permissionService.deletePermissionById(uuid);

        return "redirect:/perm/permissionlist.do";
    }

    @RequestMapping("permissionupdate")
    @RequiresPermissions("perm:update")
    public String updatePermissionById(Model model){
        String uuid = request.getParameter("id");

        SysPermission permission = permissionService.selectPermissionById(uuid);

        System.out.println(permission);
        model.addAttribute("perm",permission);
        return "permissionupdate";
    }

    @RequestMapping("doupdate")
    public String doPermissionUpdate(){
        SysPermission permission = null;
        try {
            permission = (SysPermission) BaseUtil.toBean(SysPermission.class,request);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println(permission);
        permissionService.updatePermissionById(permission);
        return "redirect:/perm/permissionlist.do";
    }
}
