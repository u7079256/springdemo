package com.heima.demo;

import com.heima.dao.UserDao;
import com.heima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demoForUserController {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationCOntext.xml");
        UserService userService = (UserService) app.getBean("UserService");
        userService.save();
        System.out.println("====================");
        UserService userService1 = (UserService) app.getBean("betterService");
        userService1.save();
        System.out.println("+++++++++++++++++++++++++||++++++++++++++++++");
        UserService userService2 = (UserService) app.getBean("constructorService");
        userService2.save();
    }
}
