package com.rentalhousing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: 赵博林
 * @Date:2020/4/12 22:23
 * @Description:
 * @Param：
 * @return ：
 */
@Controller
public class HelloController {

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String sayHello() throws Exception{
        System.out.println("我是测试代码！");
        return "hello";
    }

}