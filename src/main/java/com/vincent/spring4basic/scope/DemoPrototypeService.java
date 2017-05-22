package com.vincent.spring4basic.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by renwu on 2017/5/12.
 *
 */
@Service
@Scope("prototype")
public class DemoPrototypeService {

}
