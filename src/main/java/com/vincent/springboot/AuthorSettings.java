package com.vincent.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *  见书本，pdf不全
 * Created by renwu on 2017/6/5.
 */
@Component
@ConfigurationProperties(prefix = "author")
public class AuthorSettings {

    private String name;
    private Long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
