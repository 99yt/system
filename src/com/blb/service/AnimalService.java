package com.blb.service;

import com.blb.dao.AnimalDao;
import com.blb.dao.factory.AnimalDaoFactory;
import com.blb.entily.Animal;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * 模型层：
 *
 * 	处理具体的业务请求
 */
public class AnimalService {

    AnimalDao dao;
    public AnimalService() {
        dao = AnimalDaoFactory.getInstance();
    }

    /**
     * 查询所有宠物信息
     * @return 所有宠物信息
     * @throws SQLException
     */
    public List<Animal> queryAllAnimal() throws SQLException {
        //数据持久化层操作
        return dao.queryAllAnimal();
    }


     /*
     根据id删除宠物信息
     * */
    public int delAnimal(int delId) throws SQLException {
        return dao.deleteAnimal(delId);
    }

    public int addAnimal(Animal addanimal) throws SQLException {
        return dao.insertAnimal(addanimal);
    }


    /**
     * 查询指定的宠物信息
     * @param
     * @return
     */
    public Animal queryOneAnimal(int queryId) throws SQLException {
        return dao.queryOneAnimal(queryId);
    }

     public int updateAnimal(Animal animal) throws SQLException {
        return dao.updateAnimal(animal);
     }

}