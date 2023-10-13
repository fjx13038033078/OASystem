package com.sjjs;

import com.sjjs.oasystem.entity.User;
import com.sjjs.oasystem.mapper.UserMapper;
import com.sjjs.oasystem.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

    }
    
    @Test
    void jwttest(){
        User user = new User();
        user.setUid(1);
        user.setUaccount("fanjiaxing");
        user.setUpassword("123456");
        String token = JwtUtil.createToken(user);
        System.out.println(token);

    }

}
