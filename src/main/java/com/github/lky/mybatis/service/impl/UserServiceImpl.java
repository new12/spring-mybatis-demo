package com.github.lky.mybatis.service.impl;

import com.github.lky.mybatis.dao.ext.BookDao;
import com.github.lky.mybatis.dao.ext.UserBookRelationDao;
import com.github.lky.mybatis.dao.ext.UserDao;
import com.github.lky.mybatis.dao.ext.UserExtDao;
import com.github.lky.mybatis.entity.Book;
import com.github.lky.mybatis.entity.User;
import com.github.lky.mybatis.entity.UserBookRelation;
import com.github.lky.mybatis.entity.UserExt;
import com.github.lky.mybatis.model.BookModel;
import com.github.lky.mybatis.model.UserModel;
import com.github.lky.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by longkeyu on 2017/5/8.
 */
@Component
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserBookRelationDao userBookRelationDao;

    @Autowired
    private UserExtDao userExtDao;

    @Override
    public void create(UserModel model) {
        User user = new User();
        user.setName(model.getName());
        userDao.insertSelective(user);
        Integer userId = user.getId();

        UserExt ext = new UserExt();
        ext.setAge(model.getAge());
        ext.setUserId(userId);
        userExtDao.insertSelective(ext);

        List<BookModel> books = model.getBooks();
        for (BookModel b : books){
            Book bo = new Book();
            bo.setName(b.getName());
            bo.setAuthor(b.getAuthor());
            bookDao.insertSelective(bo);
            Integer bookId = bo.getId();
            UserBookRelation relation = new UserBookRelation();
            relation.setBookId(bookId);
            relation.setUserId(userId);
            userBookRelationDao.insertSelective(relation);
        }
    }


}
