package com.vincent.springmvc;

import com.vincent.auth.AuthHelper;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by renwu on 2017/5/12.
 * 继承HandlerInterceptorAdapter类来实现自定义拦截器
 *
 */
public class DemoInterceptor extends HandlerInterceptorAdapter{



    //在请求发生前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        Cookie tokenCookie = null;
        for(Cookie cookie : cookies){
            if("JSESSTOKEN".equals(cookie.getName())){
                tokenCookie = cookie;
                break;
            }
        }
        if(tokenCookie != null){
            String token = tokenCookie.getValue();
            Claims claims = AuthHelper.parseJWT(token,AuthHelper.base64Security);
            String name = (String) claims.get("userName");

        }

        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return true;
    }

    //在请求发生后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.println("本次请求处理时间为：" + new Long(endTime - startTime) + "ms");
        request.setAttribute("handleTime",endTime - startTime);
    }
}
