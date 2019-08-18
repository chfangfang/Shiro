package com.chxf.user.service.impl;

import com.chxf.user.mapper.LogMapper;
import com.chxf.user.model.SysLog;
import com.chxf.user.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements ILogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public List<SysLog> selectLogList() {
        return logMapper.selectLogList();
    }

    @Override
    public Integer insertLog(SysLog log) {
        return logMapper.insertLog(log);
    }
}
