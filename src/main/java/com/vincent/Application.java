package com.vincent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/10.
 */
@RestController
@SpringBootApplication
public class Application {

    @RequestMapping("/")
    String index(){
        return "Hello spring boot";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
