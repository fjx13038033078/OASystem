package com.sjjs.oasystem.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.interfaces.Claim;
import com.sjjs.oasystem.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;


@WebFilter(filterName = "jwtFilter",urlPatterns = "/secure/*")
public class JwtFilterConfig implements Filter {
    private final Logger logger = LoggerFactory.getLogger(JwtFilterConfig.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setCharacterEncoding("UTF-8");
        //获取header里的token
        String token=request.getHeader("authorization");
//        // 如果token存在，则将其添加到Authorization标头中
//        if (token != null) {
//            request.setAttribute("Authorization", "Bearer " + token);
//        }
        if ("OPTIONS".equals(request.getMethod())) {              //除了 OPTIONS请求以外, 其它请求应该被JWT检查
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request, response);
        }else {
            if (token == null) {
                response.getWriter().write("没有token！");
                return;
            }
        }

        Map<String, Claim> userData = JwtUtil.verifyToken(token);

        if (userData==null){
            response.getWriter().write("token不合法！");
            return;
        }
        //Integer uid = userData.get("uid").asInt();
        String uname = userData.get("uname").asString();
        String uaccount = userData.get("uaccount").asString();
        //拦截器 拿到用户信息，放到request中
        //request.setAttribute("id", uid);
        request.setAttribute("uname", uname);
        request.setAttribute("uaccount", uaccount);
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
