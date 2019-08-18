package com.chxf.user.controller;

import com.chxf.user.model.ActiveUser;
import com.chxf.user.model.SysLog;
import com.chxf.user.service.ILogService;
import com.chxf.user.util.BaseUtil;
import com.chxf.user.util.DateUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class IndexController {

    @Autowired
    private ILogService logService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("index")
    public String toindex(Model model)throws Exception{
        //从shiro中获取activeUser
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        //取出身份信息
        ActiveUser activeUser = (ActiveUser) subject.getPrincipal();

        //通过model传到页面
        model.addAttribute("activeUser",activeUser);
        return "index";
    }
}
