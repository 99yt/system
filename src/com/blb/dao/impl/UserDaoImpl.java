package com.blb.dao.impl;

import com.blb.dao.UserDao;
import com.blb.entily.User;
import org.apache.commons.dbutils.QueryRunner;

public class UserDaoImpl implements UserDao {
    QueryRunner qr = new QueryRunner();

    @Override
    public User queryUser(User user) {
       // return //qr.query();
        return null;
    }
}
