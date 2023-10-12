package com.sjjs.oasystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sjjs.oasystem.common.vo.Result;
import com.sjjs.oasystem.entity.User;
import com.sjjs.oasystem.mapper.UserMapper;
import com.sjjs.oasystem.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjjs.oasystem.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author fanjiaxing
 * @since 2023-09-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private JwtUtil jwtUtil;

    @Override
    public Map<String, Object> login(User user) {
        //根据用户名和密码进行查询
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUaccount, user.getUaccount());
        User loginUser = this.baseMapper.selectOne(wrapper);
        if (loginUser == null){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "用户不存在");
            return errorResponse;
        }else if (passwordEncoder.matches(user.getUpassword(), loginUser.getUpassword())) {
            // 密码验证成功，可以生成令牌或执行其他操作
            // 生成令牌的代码可以在这里添加
            String token = jwtUtil.createToken(loginUser);
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("token",token);
            return responseData;
        }
        // 密码错误，返回错误消息
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", "密码错误");
        return errorResponse;
    }

    @Override
    public User getByAccount(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUaccount, user.getUaccount());
        User registerUser = this.baseMapper.selectOne(wrapper);
        return registerUser;
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof User) {
            return (User) authentication.getPrincipal();
        }
        return null;
    }


}
