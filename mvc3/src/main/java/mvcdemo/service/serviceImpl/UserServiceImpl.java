package mvcdemo.service.serviceImpl;

import mvcdemo.dao.UserDao;
import mvcdemo.service.service;

public class UserServiceImpl implements service {
    private UserDao userDao;
    public void save() {
        userDao.save();
        System.out.println("Service is running ....");
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
