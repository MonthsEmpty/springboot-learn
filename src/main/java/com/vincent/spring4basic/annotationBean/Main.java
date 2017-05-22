package com.vincent.spring4basic.annotationBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by renwu on 2017/5/12.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);

        UseFunctionService useFunctionService = (UseFunctionService) context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello(" vincent"));
        context.close();
    }
}
