package com.chxf.user.controller;

import com.chxf.user.model.SysPermissionVO;
import com.chxf.user.model.SysRolePermission;
import com.chxf.user.service.IPermissionService;
import com.chxf.user.service.IRolePermService;
import com.chxf.user.service.IRoleService;
import com.chxf.user.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("role")
public class RolePermController {

    @Autowired
    private IRolePermService rolePermService;

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("dorolepermadd")
    public String doinsert() {

        String roleid = request.getParameter("roleid");
        //获取原本就有的权限值的改动情况
        String[] oldpermid = request.getParameterValues("oldpermid");
        //获取新增的权限
        String[] permid = request.getParameterValues("permid");

        List<SysPermissionVO> rolePermList = permissionService.selectOldPermissionById(roleid);
        for (SysPermissionVO perm : rolePermList) {
            boolean flag = true;
            if(oldpermid != null){
                for (int i = 0; i < oldpermid.length; i++) {
                    if (oldpermid[i].equals(perm.getId())) {
                        System.out.println(oldpermid[i] + "========" + perm.getId());
                        System.out.println("pan"+!(oldpermid[i].equals(perm.getId())));
                        flag = false;
                        System.out.println("flag"+flag);
                        System.out.println("------------"+oldpermid.length);
                        continue;
                    }
                }
            }

            if (flag){

                //直接删除
                SysRolePermission rolePermission = new SysRolePermission();
                rolePermission.setRoleid(roleid);
                rolePermission.setPermid(perm.getId());

                rolePermService.deleteLorePerm(rolePermission);
            }
        }

        if (permid != null) {
            for (int i = 0; i < permid.length; i++) {
                SysRolePermission rolePermission = new SysRolePermission();
                rolePermission.setId(BaseUtil.gitUuid());
                rolePermission.setRoleid(roleid);
                rolePermission.setPermid(permid[i]);

                rolePermService.insertInfo(rolePermission);
            }
            System.out.println(">>>>>>>>>>" + request.getParameterValues("permid").length);
        }

        return "redirect:/role/rolelist.do";
    }
}
