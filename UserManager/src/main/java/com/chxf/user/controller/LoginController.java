package com.chxf.user.controller;

import com.chxf.user.exception.CustomException;
import com.chxf.user.service.ILogService;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    //用户登录方法
    //此方法不处理登录成功(认证成功)后要做的操作,认证成功的操作是由shiro跳转到上一个路径
    @RequestMapping("login")
    public String login(HttpServletRequest request) throws Exception {
        //如果登陆失败就从request中获取认证信息,shiroLoginFailure就是shiro的一场名称
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");

        //根据shiro返回的异常类的信息,抛出指定的异常信息
        if (exceptionClassName != null) {
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                throw new CustomException("账号不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
                throw new CustomException("用户名/密码错误");
            } else {
                //最终使用异常处理器生成未知错误
                throw new Exception();
            }
        }

        //登录失败,则返回到login页面

        return "login";
    }
}
