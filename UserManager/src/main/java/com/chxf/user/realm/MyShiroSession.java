package com.chxf.user.realm;

import com.chxf.user.mapper.LogMapper;
import com.chxf.user.model.ActiveUser;
import com.chxf.user.model.SysLog;
import com.chxf.user.service.ILogService;
import com.chxf.user.util.BaseUtil;
import com.chxf.user.util.DateUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class MyShiroSession {

    public static SysLog getActiveUser(String logname, HttpServletRequest request, String permcode, String methed){
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        //取出身份信息
        ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
        //添加日志记录
        String logtime = DateUtil.toString(new Date(),DateUtil.YYYY_MM_DD_HH_MM);
        SysLog log = new SysLog(activeUser.getUsername(),logname, BaseUtil.getIpAddr(request) ,"user:select","POST",logtime);

        return log;
    }
}
