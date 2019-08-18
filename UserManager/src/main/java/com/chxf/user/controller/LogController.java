package com.chxf.user.controller;

import com.chxf.user.model.SysLog;
import com.chxf.user.service.ILogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("log")
public class LogController {

    @Autowired
    private ILogService logService;

    @RequestMapping("logselect")
    @RequiresPermissions("log:select")
    public String selectLog(Model model){
        List<SysLog> loglist = logService.selectLogList();
        model.addAttribute("loglist",loglist);
        return "loglist";
    }
}
