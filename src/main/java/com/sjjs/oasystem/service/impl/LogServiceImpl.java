package com.sjjs.oasystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjjs.oasystem.entity.Log;
import com.sjjs.oasystem.mapper.LogMapper;
import com.sjjs.oasystem.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl extends ServiceImpl<LogMapper,Log> implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    @Async
    public void insertLog(Log log) {
        logMapper.insert(log);
    }
}
