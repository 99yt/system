package com.blb.dao.factory;

import com.blb.dao.UserDao;
import com.blb.dao.impl.UserDaoImpl;

public class UserDaoFactory {
    public static UserDao getInstance() {
        //直接返回，使用反射+配置文件
        return new UserDaoImpl();
    }
}
