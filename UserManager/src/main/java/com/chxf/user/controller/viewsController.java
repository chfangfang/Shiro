package com.chxf.user.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class viewsController {

    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("systemselect")
    @RequiresPermissions("user:system")
    public String systemselect(){
        return "system";
    }

    /** 配置通用的页面跳转的方法 **/
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
}
