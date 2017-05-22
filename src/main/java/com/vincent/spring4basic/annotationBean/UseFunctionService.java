package com.vincent.spring4basic.annotationBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by renwu on 2017/5/12.
 */
@Service//声明当前UseFunctionService是spring管理的一个bean
public class UseFunctionService {
    @Autowired//将FuncitonService的实体bean注入到UseFunctionService中
    FuncitonService funcitonService;

    public String sayHello(String word){
        return funcitonService.sayHello(word);
    }
}
