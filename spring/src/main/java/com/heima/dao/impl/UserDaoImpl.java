package com.heima.dao.impl;

import com.heima.dao.UserDao;

public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        System.out.println("create UserDao for singleton....");
    }

    public void save() {
        System.out.println("save running");
    }

    public void init(){
        System.out.println("start when init...");
    }

    public void destroy(){
        System.out.println("start when destory...");
    }


}
