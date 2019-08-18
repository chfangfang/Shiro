package com.chxf.user.realm;

import com.chxf.user.model.ActiveUser;
import com.chxf.user.model.SysPermission;
import com.chxf.user.model.SysUser;
import com.chxf.user.service.IPermissionService;
import com.chxf.user.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private IPermissionService permissionService;

    // 设置realm的名称
    @Override
    public void setName(String name) {
        super.setName("customRealm");
    }
    //清除缓存
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//获取主身份信息
        ActiveUser activeUser = (ActiveUser) principalCollection.getPrimaryPrincipal();
        //模拟数据库获取数据
        List<SysPermission> permissionsList =null;
        try {
            permissionsList = permissionService.findPermByUserId(activeUser.getUserid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> permissions = new ArrayList<>();
        //遍历权限并为其复制
        if(permissionsList!=null){
            //将数据库中的权限标签填入集合
            for(SysPermission sysPermission : permissionsList){
                permissions.add(sysPermission.getPermcode());
            }
        }
        //查到权限数据
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //将授权信息填充到simp-中
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;

    }

    //token是认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("ok");
        //1.从token中取出身份信息
        String username = (String) token.getPrincipal();

        //System.out.println(userCode);
        //从数据库查询用户信息
        SysUser sysUser =null;
        try {
            sysUser = userService.selectUserByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(">>>>>>>"+sysUser.getUsername());
        //System.out.println(">>>>>>>"+sysUser.toString());
        //判断是否为空
        if(sysUser == null){
            return null;
        }
        //2.根据输入的user Code查询数据库信息,查询到的密码
        String password_db = sysUser.getPassword();
        //盐
        String salt = sysUser.getSalt();
        //如果认证通过,则将用户信息放入要保存的用户实体类中
        ActiveUser activeUser = new ActiveUser();
        activeUser.setUserid(sysUser.getId());
        activeUser.setUsername(sysUser.getUsername());
        //通过service取菜单
        List<SysPermission> menuList = null;
        try {
            menuList = permissionService.findMenuByUserId(sysUser.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        activeUser.setMenus(menuList);
        //System.out.println(">>>>>>"+menuList);
        //如果查询到返回加盐认证信息AuthenticationInfo
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                activeUser, password_db, ByteSource.Util.bytes(salt) , this.getName());

        return simpleAuthenticationInfo;

    }

}
