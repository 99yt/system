package com.blb.dao.impl;

import com.blb.dao.AnimalDao;
import com.blb.entily.Animal;
import com.blb.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AnimalDaoImpl implements AnimalDao {

    QueryRunner qr = new QueryRunner();

    @Override
    public List<Animal> queryAllAnimal() throws SQLException {
        return qr.query(DBUtils.getConnection(), SQL_QUERY_ALL_ANIMAL,
                new BeanListHandler<>(Animal.class));
    }

    @Override
    public int deleteAnimal(int delId) throws SQLException {
        return qr.update(DBUtils.getConnection(),SQL_DELETE_ID_ANIMAL,delId);
    }

    @Override
    public int insertAnimal(Animal addAnimal) throws SQLException {
        return qr.update(DBUtils.getConnection(),SQL_ADD_ANIMAL,
                addAnimal.getName(),
                addAnimal.getAge(),addAnimal.getKind(),addAnimal.getGender());
    }

    @Override
    public Animal queryOneAnimal(int queryId) throws SQLException {
        return qr.query(DBUtils.getConnection(),SQL_QUERY_ONE_ANIMAL_BY_ID,new BeanHandler<>(Animal.class),queryId);
    }

    @Override
    public int updateAnimal(Animal animal) throws SQLException {
        return qr.update(DBUtils.getConnection(),SQL_UPDATE_ONE_ANIMAL_BY_ID,
                animal.getName(),animal.getAge(),animal.getKind(),animal.getGender(),animal.getId());
    }
}

