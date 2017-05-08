package com.github.lky.mybatis.dao.gen;

import com.github.lky.mybatis.entity.UserBookRelation;

public interface UserBookRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserBookRelation record);

    int insertSelective(UserBookRelation record);

    UserBookRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBookRelation record);

    int updateByPrimaryKey(UserBookRelation record);
}