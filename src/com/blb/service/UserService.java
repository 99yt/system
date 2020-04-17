package com.blb.service;

import com.blb.dao.UserDao;
import com.blb.dao.impl.UserDaoImpl;
import com.blb.entily.User;

public class UserService {

    UserDao dao;

    public UserService() {
        dao=new UserDaoImpl();
    }

    private User queryService(User user){
        return  dao.queryUser(user);
    }

}
