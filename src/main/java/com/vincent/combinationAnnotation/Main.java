package com.vincent.combinationAnnotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by renwu on 2017/5/12.
 *
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        DemoService demoService = context.getBean(DemoService.class);
        demoService.outputResult();
        context.close();
    }
}
