package com.heima.dao.impl;

import com.heima.dao.UserDao;

public class AddInProperty implements UserDao {
    String name;
    int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void save() {

    }
}
