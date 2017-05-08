package com.github.lky.mybatis.dao.ext;

import com.github.lky.mybatis.entity.UserBook;

/**
 * Created by longkeyu on 2017/5/8.
 */
public interface UserQueryDao {
    UserBook queryUser(Integer id);

    UserBook queryUserBook(Integer id);
}
