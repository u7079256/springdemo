package com.heima.demo;

import com.heima.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demoForBasicUse {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationCOntext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.save();
    }
}
