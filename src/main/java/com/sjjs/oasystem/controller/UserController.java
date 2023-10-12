package com.sjjs.oasystem.controller;

import com.sjjs.oasystem.common.vo.Result;
import com.sjjs.oasystem.entity.User;
import com.sjjs.oasystem.service.UserService;
import com.sjjs.oasystem.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author fanjiaxing
 * @since 2023-09-20
 */
//@CrossOrigin开发时临时解决跨域问题
@CrossOrigin(origins = "http://localhost:8080",maxAge = 3600)
@RestController
@Api(value = "用户登录及注册", tags = {"用户登录及注册"})
@RequestMapping("/user")
public class UserController {
    private Set<String> tokenBlacklist = new HashSet<>();
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/all")
    public Result<List<User>> getAllUser() {
        List<User> list = userService.list();
        return Result.success("查询成功", list);
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result<Map<String, Object>> login(@RequestBody User user) {
        Map<String, Object> responseData = userService.login(user);
        User userLogin = userService.getByAccount(user);
        if (userLogin == null) {
            return Result.fail(20004, "该用户不存在");
        } else if (responseData == null){
            return Result.fail(20003,"密码错误");
        } else {
            return Result.success("登录成功", responseData);
        }
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Result<Map<String, Object>> register(@RequestBody User user) {
        User checkUser = userService.getByAccount(user);
        if (checkUser != null) {
            return Result.fail(20003, "该用户已存在");
        }
        // 对密码进行哈希加密
        String hashedPassword = passwordEncoder.encode(user.getUpassword());
        user.setUpassword(hashedPassword);

        userService.addUser(user);
        return Result.success("用户添加成功", null);
    }

    @PostMapping("/logout")
    public Result<String> logout() {
        // 清除当前用户的会话
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(null);
        }

        // 可选：执行其他注销操作，例如清除令牌，记录退出时间等

        return Result.success("注销成功", null);
    }

    @GetMapping("/current")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }

}
