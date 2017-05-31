package com.github.lky.mybatis.service.impl;

import com.github.lky.mybatis.service.LogService;

import java.util.Date;

/**
 * Created by longkeyu on 2017/5/31.
 */
public class LogServiceImpl implements LogService {
    @Override
    public void record(String msg, Date date) {
        System.out.println(date + "     " + msg);
    }
}
