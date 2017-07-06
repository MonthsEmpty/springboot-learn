package com.vincent;

import com.vincent.auth.AuthHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/5/10.
 * SpringBootApplication组合了@SpringBootConfiguration、@EnableAutoConfiguration、@ComponentScan
 * EnableAutoConfiguration让Spring Boot根据类路径中的jar包依赖为当前项目进行自动配置，例如，添加了spring-boot-starter-web依赖
 * 会自动添加Tomcat和Spring MVC的依赖，那么Spring Boot 会对Tomcat和Spring MVC 进行自动配置。
 * Spring Boot会自动扫描@SpringBootApplication所在类的同级包以及下级包里的Bean
 * 关闭特定的自动配置使用@SpringBootApplication注解的exclude参数，例如@SpringBootApplication(exclude = {xxxx.class})
 */
@RestController
@SpringBootApplication
public class Application {

    //只需在application.properties中定义属性，直接使用@Value注入即可
    @Value("${learner.name}")
    private String name;

    @Value("${learner.age}")
    private Integer age;

    @RequestMapping("/")
    String index() {
        return "Hello spring boot,i'm " + name + ",and i'm " + age + " years old!";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String TestLogin(HttpServletRequest request, HttpServletResponse response) {
        AuthHelper.setCookie(response,"vincent", "123", "test", 8 * 60 * 60 * 1000, AuthHelper.base64Security, "asdfads");
        return "asdf";
    }

    @RequestMapping("/testAftetLogin")
    @ResponseBody
    public String testAftetLogin(){
        return "testAftetLogin";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
