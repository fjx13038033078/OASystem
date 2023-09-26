package com.sjjs.oasystem.service;

import com.sjjs.oasystem.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fanjiaxing
 * @since 2023-09-20
 */
public interface IUserService extends IService<User> {

    Map<String, Object> login(User user);

    User getByAccount(User user);

    void addUser(User user);
}
