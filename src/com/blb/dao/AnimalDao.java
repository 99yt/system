package com.blb.dao;

import com.blb.entily.Animal;

import java.sql.SQLException;
import java.util.List;

public interface AnimalDao {
    public static final String SQL_QUERY_ALL_ANIMAL = "select * from animal";
    public static final String SQL_DELETE_ID_ANIMAL = "delete  from animal where id=?";
    public static final String SQL_ADD_ANIMAL = "insert into animal values(default,?,?,?,?)"; //id是自增，null/default
    public static final String SQL_QUERY_ONE_ANIMAL_BY_ID = "select * from animal where id=?";
    public static final String SQL_UPDATE_ONE_ANIMAL_BY_ID = "update animal set name=? , kind=? , age=? , gender=? where id=?";
     /**
     * 查询所有宠物信息
     * @return
     */
    List<Animal> queryAllAnimal() throws SQLException;

    /*
    *  根据id删除宠物信息
    * */
     int deleteAnimal(int delId) throws SQLException;


    /**
     * 添加宠物信息
     * @param addAnimal
     * @return
     */
    int insertAnimal(Animal addAnimal) throws SQLException ;

    Animal queryOneAnimal(int queryId) throws SQLException;

    int updateAnimal(Animal animal) throws SQLException;
}
