package com.heima.factory;

import com.heima.dao.UserDao;
import com.heima.dao.impl.UserDaoImpl;

public class StaticFactory {
    public static UserDao getUserDao(){
        System.out.println("creating from static factory");
        return new UserDaoImpl();
    }
    public UserDao getUserDaoDynamic(){
        System.out.println("creating from dynamic factory");
        return new UserDaoImpl();
    }
}
