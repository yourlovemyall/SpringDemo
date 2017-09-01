package com.rainxu.api.main;

import com.rainxu.api.service.GxqUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xuxiaoyu on 17/8/23.
 */
public final class Main {
    private Main(){

    }
    public static void main(String[] args){
        new ClassPathXmlApplicationContext("application-context.xml");
        System.out.println("=======");
        GxqUserService userService = (GxqUserService) SpringContext.getBean("userService");
        System.out.print(userService.getUserListByUid(3499690L).toString());
    }
}
