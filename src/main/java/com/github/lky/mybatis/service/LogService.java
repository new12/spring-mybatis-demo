package com.github.lky.mybatis.service;

import java.util.Date;

/**
 * Created by longkeyu on 2017/5/31.
 */
public interface LogService {
    void record(String msg, Date time);
}
