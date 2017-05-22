package com.vincent.spring4basic.annotationBean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by renwu on 2017/5/12.
 */
@Configuration//声明当前类是一个配置类，相当于spring配置的xml文件
@ComponentScan("com.vincent.spring4basic.annotationBean")//自动扫描包名下所有使用@Service、@Component、@Repository、@Controller的类，并注册为bean
public class DiConfig {

}
