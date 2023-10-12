package com.sjjs.oasystem.util;

import com.sjjs.oasystem.entity.Log;
import com.sjjs.oasystem.entity.User;
import com.sjjs.oasystem.service.LogService;
import com.sjjs.oasystem.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class ServiceLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(ServiceLogAspect.class);

    @Autowired
    LogService logService;
    @Autowired
    UserService userService;

    @Pointcut("execution(* com.sjjs.oasystem.service.*.*(..)) && !execution(* com.sjjs.oasystem.service.LogService.insertLog(..)) && !execution(* com.sjjs.oasystem.service.UserService.getCurrentUser(..)) ")
    public void pointcut(){
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        // 用户[1.2.3.4],在[xxx],访问了[com.nowcoder.community.service.xxx()].
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return;
        }
        HttpServletRequest request = attributes.getRequest();
//        String ip = request.getRemoteHost();
        String ip = IPUtils.getIp(request);
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String target = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        logger.info(String.format("用户[%s],在[%s],访问了[%s].", ip, now, target));

        User user = userService.getCurrentUser();


        String innerIp = IPUtils.innerIp(ip);
        String URL = request.getRequestURL().toString();
        String method = request.getMethod();
        String URI = request.getRequestURI();
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();

        String uaccount;
        String uname;
        if(user == null){
            uaccount = "Anonymous";
            uname = "Anonymous";
        }else{
            uaccount = user.getUaccount();
            uname = user.getUname();
        }
        Log log = new Log();
        //操作用户账号
        log.setUaccount(uaccount);
        //操作用户用户名
        log.setUname(uname);
        //请求方式
        log.setMethod(method);
        //URI 请求接口
        log.setUri(URI);
        //URL 请求地址
        log.setUrl(URL);
        //请求类
        log.setClassName(className);
        //请求函数
        log.setClassMethodName(methodName);
        //ip
        log.setIp(ip);

        //请求时间
        log.setRequestTime(now);

//        System.out.println(ip);
//        System.out.println(innerIp);

        logService.insertLog(log);
    }

}
