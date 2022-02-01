package com.heima.service.impl;

import com.heima.dao.UserDao;
import com.heima.service.UserService;

public class UseContractorService implements UserService {
    UserDao userDao;

    public UseContractorService() {
    }

    public UseContractorService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("+++++++++++++++using constructor for creating");
        userDao.save();
    }
}
