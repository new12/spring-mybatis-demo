package com.github.lky.mybatis.model;

import com.github.lky.mybatis.entity.Book;

import java.util.List;

/**
 * Created by longkeyu on 2017/5/8.
 */
public class UserModel {
    private int id;
    private String name;
    private int age;
    private List<BookModel> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }
}
