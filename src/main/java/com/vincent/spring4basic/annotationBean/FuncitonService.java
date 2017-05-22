package com.vincent.spring4basic.annotationBean;

import org.springframework.stereotype.Service;

/**
 * Created by renwu on 2017/5/12.
 */
@Service
public class FuncitonService {
    public String sayHello(String word){
        return "Hello" + word + " !";
    }
}
