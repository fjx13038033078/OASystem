package com.sjjs.oasystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjjs.oasystem.entity.Log;



public interface LogService extends IService<Log> {
    void insertLog(Log log);
}
