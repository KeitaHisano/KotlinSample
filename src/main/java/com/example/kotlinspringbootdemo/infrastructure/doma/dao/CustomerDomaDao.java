package com.example.kotlinspringbootdemo.infrastructure.doma.dao;

import com.example.kotlinspringbootdemo.infrastructure.doma.entity.CustomerDomaEntity;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@ConfigAutowireable
@Dao
public interface CustomerDomaDao {
    @Select
    List<CustomerDomaEntity> selectAll();

    @Insert
    int insert(CustomerDomaEntity entity);

    @Update
    int update(CustomerDomaEntity entity);

    @Select
    CustomerDomaEntity selectById(int id);

    @Delete
    int delete(CustomerDomaEntity entity);
}