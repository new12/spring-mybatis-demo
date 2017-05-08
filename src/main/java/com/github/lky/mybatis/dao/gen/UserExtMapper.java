package com.github.lky.mybatis.dao.gen;

import com.github.lky.mybatis.entity.UserExt;

public interface UserExtMapper {
    int insert(UserExt record);

    int insertSelective(UserExt record);
}