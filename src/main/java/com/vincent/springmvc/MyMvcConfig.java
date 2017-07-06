package com.vincent.springmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by renwu on 2017/5/12.
 *
 */
@EnableWebMvc//开启springMVC支持，若无此句，重写WebMvcConfigurerAdapter方法无效
@ComponentScan("com.vincent.springmvc")
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Bean //配置拦截器的bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }

    //addResourceLocations指的是文件放置的目录，addResourceHandler指的是对外暴露的访问路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("").addResourceLocations("");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) { //重写addInterceptors方法，注册拦截器
        registry.addInterceptor(demoInterceptor()).addPathPatterns("/**").excludePathPatterns("/login");
    }
}
