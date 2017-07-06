package com.vincent.sourceCode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * springmvc的相关源码研究学习
 * 1、@c
 * Created by renwu on 2017/6/16.
 */
@Controller
@RequestMapping("/request")
public class MvcAnnotationTestController {

    @RequestMapping(value = "/testRequestBody",method = RequestMethod.POST)
    @ResponseBody
    public Map testRequestBody(@RequestBody Map<String,String> map){
        System.out.println(map);
        return map;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        String aaa = "1231";
        return aaa;
    }

    @RequestMapping("/responseBodyTest")
    @ResponseBody
    public TestBean responseBodyTest(){
        TestBean testBean = new TestBean();
        testBean.setAge(123);
        testBean.setName("asdfasd");
        return testBean;
    }


}
