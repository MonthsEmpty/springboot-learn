package com.vincent.springmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by renwu on 2017/5/12.
 *
 */
@EnableWebMvc//开启springMVC支持，若无此句，重写WebMvcConfigurerAdapter方法无效
@ComponentScan("com.vincent.springmvc")
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    //addResourceLocations指的是文件放置的目录，addResourceHandler指的是对外暴露的访问路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("").addResourceLocations("");
    }
}
