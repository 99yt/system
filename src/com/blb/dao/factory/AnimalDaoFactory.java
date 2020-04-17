package com.blb.dao.factory;

import com.blb.dao.AnimalDao;
import com.blb.dao.impl.AnimalDaoImpl;

/**
 * 获取一个具体的DAO的实现类
 *
 */
public class AnimalDaoFactory {
    /**
     * 获取一个具体的DAO的实现类
     */
    public static AnimalDao getInstance() {
        //直接返回，使用反射+配置文件
        return new AnimalDaoImpl();
    }

}
