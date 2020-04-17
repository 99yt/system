package com.blb.dao;

import com.blb.entily.User;

public interface UserDao {
    public static final String SQL_QUERY_ALL_ANIMAL = "select * from animal";


    User  queryUser(User user);
}
