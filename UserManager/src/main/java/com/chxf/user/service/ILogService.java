package com.chxf.user.service;

import com.chxf.user.model.SysLog;

import java.util.List;

public interface ILogService {

    public List<SysLog> selectLogList();

    public Integer insertLog(SysLog log);
}
