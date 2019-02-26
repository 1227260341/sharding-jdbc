package com.zj.modules.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.zj.modules.domain.UserEntity;

/**
 * Created by Kane on 2018/1/17.
 */
@Mapper
public interface User1Mapper {

    List<UserEntity> getAll();

    void insert(UserEntity user);
    
    @Select("select * from t_order order by id limit 3 ")
    List<UserEntity> getUsersByPage();

}
