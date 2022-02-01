package com.heima.service.impl;

import com.heima.dao.UserDao;
import com.heima.service.UserService;

public class betterUserServiceImpl implements UserService {
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("+++++++++++++++better service");
        userDao.save();
    }
}
