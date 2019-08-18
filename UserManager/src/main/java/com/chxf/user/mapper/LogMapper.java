package com.chxf.user.mapper;

import com.chxf.user.model.SysLog;
import com.chxf.user.model.SysRole;

import java.util.List;

public interface LogMapper {

    public List<SysLog> selectLogList();

    public Integer insertLog(SysLog log);

}
