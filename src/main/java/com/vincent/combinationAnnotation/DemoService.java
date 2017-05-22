package com.vincent.combinationAnnotation;

import org.springframework.stereotype.Service;

/**
 * Created by renwu on 2017/5/12.
 *
 */
@Service
public class DemoService {

    public void outputResult(){
        System.out.println("从组合注解在获取bean");
    }
}
