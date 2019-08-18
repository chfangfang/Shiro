package com.chxf.user.controller;

import com.chxf.user.exception.CustomException;
import com.chxf.user.model.*;
import com.chxf.user.realm.MyShiroSession;
import com.chxf.user.service.ILogService;
import com.chxf.user.service.IRoleService;
import com.chxf.user.service.IUserService;
import com.chxf.user.util.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private ILogService logService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    /**
     * 获取用户列表
     * @return
     */
    @RequestMapping("userlist")
    @RequiresPermissions("user:select")
    public String userList(Model model) {

        //获取SysUser
        List<SysUser> user = userService.selectAllUser();
        //转换SysUser为对应的Vo
        List<SysUserVO> userVO = BeanUtil.copyList(user,SysUserVO.class);

        //添加日志记录
        SysLog log = MyShiroSession.getActiveUser("用户管理",request,"user:select","POST");
        logService.insertLog(log);

        model.addAttribute("userlist",userVO);
        return "userlist";
    }

    /**
     * 添加用户的访问
     * @return
     */
    @RequestMapping("useradd")
    @RequiresPermissions("user:insert")
    public String userAdd() {
        return "useradd";
    }

    @RequestMapping("doadd")
    public String doAdd() throws Exception {
        //获取输入的数据
        SysUser user = null;
        try {
            user = (SysUser) BaseUtil.toBean(SysUser.class,request);
        } catch (UnsupportedEncodingException e) {
             throw new CustomException("数据获取异常");
        }

        //产生用户唯一表示id
        String uuid = BaseUtil.gitUuid();
        //生成盐值
        String salt = RandomUtil.getItemName(8);
        //获取密码进行比对
        String password2 = request.getParameter("password2");

        if(user.getPassword().equals(password2)){
            System.out.println("ok"+password2);
            String password = BaseUtil.md51024Pwd(user.getPassword(),salt);
            user.setPassword(password);
        }else{
            throw new CustomException("密码不一致");
        }

        //添加用户信息
        user.setId(uuid);
        user.setSalt(salt);
        user.setCreatetime(DateUtil.toString(new Date(),DateUtil.YYYY_MM_DD_HH_MM));

        //LogUtil.info(user.toString());
        //添加日志记录
        SysLog log = MyShiroSession.getActiveUser("添加用户",request,"user:insert","POST");
        logService.insertLog(log);

        userService.insertUser(user);
        return "redirect:/user/userlist.do";
    }
    /**
     * 修改用户的操作
     * @return
     */
    @RequestMapping("userupdate")
    @RequiresPermissions("user:update")
    public String userUpdate(Model model) {
        String id = request.getParameter("id");
        SysUserVO vo = userService.selectUserById(id);
        System.out.println(" >>>>>>"+vo.toString());
        model.addAttribute("user",vo);
        return "userupdate";
    }

    @RequestMapping("doupdate")
    public String doUpdate() throws Exception{
        SysUserVO vo = null;
        try {
            vo = (SysUserVO) BaseUtil.toBean(SysUserVO.class,request);
        } catch (UnsupportedEncodingException e) {
            throw new CustomException("获取异常");
        }
        //System.out.println(vo.toString());

        //添加日志记录
        SysLog log = MyShiroSession.getActiveUser("修改用户",request,"user:update","POST");
        logService.insertLog(log);

        userService.updateUser(vo);
        return "redirect:/user/userlist.do";
    }

    /**
     * 根据用户唯一标识
     */
    @RequestMapping("deleteuser")
    @RequiresPermissions("user:delete")
    public String deleteUserById(){

        String id = request.getParameter("id");

        //添加日志记录
        SysLog log = MyShiroSession.getActiveUser("删除用户",request,"user:delete","POST");
        logService.insertLog(log);

        userService.deleteUserById(id);

        return "redirect:/user/userlist.do";
    }

    /**
     * 设置用户角色
     * @return
     */
    @RequestMapping("userrole")
    @RequiresPermissions("userrole:insert")
    public String userrole(Model model) {

        String id = request.getParameter("id");
        System.out.println(id);
        String username = userService.selectUserNameById(id);

        //获取用户现在的的角色信息
        SysRole isrole = userService.selectRoleName(id);

        //获取所有的角色信息
        List<SysRole> rolelist = roleService.selectRoleList();

        model.addAttribute("id",id);
        model.addAttribute("username",username);
        model.addAttribute("isrole",isrole);
        model.addAttribute("rolelist",rolelist);
        return "userrole";
    }
}
