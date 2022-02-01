package com.heima.service.impl;

import com.heima.dao.UserDao;
import com.heima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("creating by service");
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationCOntext.xml");

        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.save();
    }
}
